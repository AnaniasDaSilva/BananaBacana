package banana.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banana.model.Produto;

/**
 * Servlet implementation class modificarProdutoController
 * @param <Dis>
 */
@WebServlet("/modificarProdutoController")
public class modificarProdutoController<Dis> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private Produto produto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarProdutoController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @param <RequestDispatcher>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html: charset=UTF-8");
		
		String apagar = request.getParameter("apagar");
		String alterar = request.getParameter("alterar");
		String id = request.getParameter("id");
		
		
		if (apagar != null && id != null) {
			new Produto().excluir(Integer.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
			request.setAttribute("mensagem", "Produto apagado com sucesso!");
			dispatcher.forward(request, response);
			}else if (alterar != null && id != null){
				Produto produto = new Produto().buscarProdutoPorId(Integer.valueOf(id));
				RequestDispatcher dispatcher = request.getRequestDispatcher("alterarProduto.jsp");
				request.setAttribute("produto", produto);
				dispatcher.forward(request, response);
			}
		
		
		
				
	}


		
	}
	



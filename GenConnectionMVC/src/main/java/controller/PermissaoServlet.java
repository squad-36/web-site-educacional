package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PermissaoDAO;
import model.Permissao;

/**
 * Servlet implementation class PermissaoServlet
 */
@WebServlet(urlPatterns = { "/permissao", "/cadastrar-permissao", "/editar-permissao", "/atualizar-permissao", "/deletar-permissao" })
public class PermissaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PermissaoDAO PermissaoDao = new PermissaoDAO();
	Permissao permissao = new Permissao();

	public PermissaoServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/permissao":
			read(request, response);
			break;
			
		case "/cadastrar-permissao":
			create(request, response);
			break;
			
		case "/editar-permissao":
			readById(request, response);
			break;
			
		case "/atualizar-permissao":
			update(request, response);
			break;
			
		case "/deletar-permissao":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	
	// Create
		protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			permissao.setnome_permissao(request.getParameter("nome"));
			PermissaoDao.save(permissao);
			response.sendRedirect("permissao");
		
		}
		
		// Read
		protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Permissao> lista = PermissaoDao.getPermissao();

			request.setAttribute("permissao", lista);

			RequestDispatcher rd = request.getRequestDispatcher("./view/permissao/");
			rd.forward(request, response);
			
		}
		
		
		// Update
		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			
			permissao.setnome_permissao(request.getParameter("nome"));
			permissao.setId_permissao(Integer.parseInt(request.getParameter("id")));
			PermissaoDao.update(permissao);
			response.sendRedirect("permissao");
		}
		
		// Delete
		protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			PermissaoDao.deleteById(id);
			response.sendRedirect("permissao"); 
		}
			
			// Read by Id
			protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
				int id = Integer.parseInt(request.getParameter("id"));
				
				permissao = PermissaoDao.getpermissaoById(id);
				
				request.setAttribute("id", permissao.getId_permissao());
				request.setAttribute("nome", permissao.getnome_permissao());
				
				RequestDispatcher rd = request.getRequestDispatcher("./view/permissao/atualizar.jsp");
				rd.forward(request, response);

		}
		

}
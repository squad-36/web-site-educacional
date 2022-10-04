package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/usuario", "/cadastrar-usuario", "/editar-usuario", "/atualizar-usuario",
		"/deletar-usuario" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuario = new Usuario();

	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
			case "/usuario":
				read(request, response);
				break;

			case "/cadastrar-usuario":
				create(request, response);
				break;

			case "/editar-usuario":
				readById(request, response);
				break;

			case "/atualizar-usuario":
				update(request, response);
				break;

			case "/deletar-usuario":
				delete(request, response);
				break;

			default:
				response.sendRedirect("index.html");
				break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setImagem(request.getParameter("imagem"));
		usuarioDao.save(usuario);
		response.sendRedirect("usuario");

<<<<<<< HEAD:GenConnection-MVC/src/main/java/controller/UsuarioServlet.java
	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = usuarioDao.getUsuario();

		request.setAttribute("usuario", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setImagem(request.getParameter("imagem"));
		usuario.setId_usuario(Integer.parseInt(request.getParameter("id")));
		usuarioDao.update(usuario);
		response.sendRedirect("usuario");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDao.deleteById(id);
		response.sendRedirect("usuario");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		usuario = usuarioDao.getusuarioById(id);

		request.setAttribute("imagem", usuario.getImagem());
		request.setAttribute("id", usuario.getId_usuario());
		request.setAttribute("nome", usuario.getNome());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("senha", usuario.getSenha());

		RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/atualizar.jsp");
		rd.forward(request, response);

	}
=======
			RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/");
			rd.forward(request, response);
			
		}
		
		// Update
		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setImagem(request.getParameter("imagem"));
			usuario.setId_usuario(Integer.parseInt(request.getParameter("id")));
			usuarioDao.update(usuario);
			response.sendRedirect("usuario");
		}
		
		// Delete
		protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			usuarioDao.deleteById(id);
			response.sendRedirect("usuario");
		}
		
		// Read by Id
		protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			int id = Integer.parseInt(request.getParameter("id"));
			
			usuario = usuarioDao.getusuarioById(id);
			
			request.setAttribute("imagem", usuario.getImagem());
			request.setAttribute("id", usuario.getId_usuario());
			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("email", usuario.getEmail());
			request.setAttribute("senha", usuario.getSenha());
			
			RequestDispatcher rd = request.getRequestDispatcher("./view/usuario/atualizar.jsp");
			rd.forward(request, response);
			
		}
		
>>>>>>> main:GenConnectionMVC/src/main/java/controller/UsuarioServlet.java

}

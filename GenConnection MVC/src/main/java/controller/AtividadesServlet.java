package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AtividadesDAO;
import model.Atividades;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/atividades", "/cadastrar-atividades", "/editar-atividades", "/atualizar-atividades",
		"/deletar-atividades" })
public class AtividadesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AtividadesDAO atividadesDao = new AtividadesDAO();
	Atividades atividades = new Atividades();

	public AtividadesServlet() {
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
		case "/atividades":
			read(request, response);
			break;

		case "/cadastrar-atividades":
			create(request, response);
			break;

		case "/editar-atividades":
			readById(request, response);
			break;

		case "/atualizar-atividades":
			update(request, response);
			break;

		case "/deletar-atividades":
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

		atividades.setMaterias(request.getParameter("nome"));
		atividadesDao.save(atividades);
		response.sendRedirect("atividades");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividades> lista = atividadesDao.getAtividades();

		request.setAttribute("atividades", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/atividades/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		atividades.setMaterias(request.getParameter("nome"));
		atividades.setId_atividades(Integer.parseInt(request.getParameter("id")));
		atividadesDao.update(atividades);
		response.sendRedirect("atividades");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		atividadesDao.deleteById(id);
		response.sendRedirect("destino");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		atividades = atividadesDao.getAtividadesById(id);

		request.setAttribute("id", atividades.getId_atividades());
		request.setAttribute("nome", atividades.getMaterias());
		RequestDispatcher rd = request.getRequestDispatcher("./view/atividades/atualizar.jsp");
		rd.forward(request, response);

	}

}

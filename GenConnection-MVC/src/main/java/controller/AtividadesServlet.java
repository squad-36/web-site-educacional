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
@WebServlet(urlPatterns = { "/usuario", "/cadastrar-usuario", "/editar-usuario", "/atualizar-usuario",
		"/deletar-usuario" })
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

			default:
				response.sendRedirect("index.html");
				break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		atividades.setMaterias(request.getParameter("materias"));
	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividades> lista = atividadesDao.getAtividadesList();

		request.setAttribute("atividades", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/atividades/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		atividades.setMaterias(request.getParameter("materias"));
		atividades.setId_atividades(Integer.parseInt(request.getParameter("id_atividades")));
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_atividades = Integer.parseInt(request.getParameter("id_atividades"));
		atividadesDao.removeById(id_atividades);
		response.sendRedirect("atividades");
	}

}
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NotificacaoDAO;
import model.Notificacao;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/notificacao", "/cadastrar-notificacao", "/editar-notificacao", "/atualizar-notificacao",
		"/deletar-notificacao" })
public class NotificacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NotificacaoDAO notificacaoDao = new NotificacaoDAO();
	Notificacao notificacao = new Notificacao();

	public NotificacaoServlet() {
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
			case "/notificacao":
				read(request, response);
				break;

			case "/cadastrar-notificacao":
				create(request, response);
				break;

			case "/editar-notificacao":
				readById(request, response);
				break;

			case "/atualizar-notificacao":
				update(request, response);
				break;

			case "/excluir-notificacao":
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

		notificacao.setnome_notificacao(request.getParameter("nome"));
		notificacao.setMensagem(request.getParameter("mensagem"));
		notificacaoDao.save(notificacao);
		response.sendRedirect("notificacao");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notificacao> lista = notificacaoDao.getNotificacao();

		request.setAttribute("notificacao", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/notificacao/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		notificacao.setnome_notificacao(request.getParameter("nome"));
		notificacao.setMensagem(request.getParameter("mensagem"));
		notificacao.setId_notificacao(Integer.parseInt(request.getParameter("id")));
		notificacaoDao.update(notificacao);
		response.sendRedirect("notificacao");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		notificacaoDao.deleteById(id);
		response.sendRedirect("notificacao");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		notificacao = notificacaoDao.getnotificacaoById(id);
		request.setAttribute("id", notificacao.getId_notificacao());
		request.setAttribute("nome", notificacao.getnome_notificacao());
		request.setAttribute("mensagem", notificacao.getMensagem());
		RequestDispatcher rd = request.getRequestDispatcher("./view/notificacao/atualizar.jsp");
		rd.forward(request, response);

	}

}
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JogosDAO;
import model.Jogos;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/jogos", "/cadastrar-jogos", "/editar-jogos", "/atualizar-jogos", "/deletar-jogos" })
public class JogosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JogosDAO jogosDao = new JogosDAO();
	Jogos jogos = new Jogos();

	public JogosServlet() {
		super();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/jogos":
			read(request, response);
			break;
			
		case "/cadastrar-jogos":
			create(request, response);
			break;
			
		case "/editar-jogos":
			readById(request, response);
			break;
			
		case "/atualizar-jogos":
			update(request, response);
			break;
			
		case "/deletar-jogos":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	
	// Create
		protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			jogos.setnome_jogos(request.getParameter("nome"));
			jogos.setPontos(Integer.parseInt(request.getParameter("pontos")));
			jogosDao.save(jogos);
			response.sendRedirect("jogos");
		
		}
		
		// Read
		protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Jogos> lista = jogosDao.getJogos();

			request.setAttribute("jogos", lista);

			RequestDispatcher rd = request.getRequestDispatcher("./view/jogos/");
			rd.forward(request, response);
			
		}
		
		
		// Update
		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			
			jogos.setnome_jogos(request.getParameter("nome"));
			jogos.setPontos(Integer.parseInt(request.getParameter("pontos")));
			jogos.setId_jogos(Integer.parseInt(request.getParameter("id")));
			jogosDao.update(jogos);
			response.sendRedirect("jogos");
		}
		
		// Delete
		protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			jogosDao.deleteById(id);
			response.sendRedirect("jogos");
		}
		
		// Read by Id
					protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
						int id = Integer.parseInt(request.getParameter("id"));
						
						jogos = jogosDao.getJogosById(id);
						
						request.setAttribute("id", jogos.getId_jogos());
						request.setAttribute("nome", jogos.getnome_jogos());
						request.setAttribute("pontos", jogos.getPontos());
						
						RequestDispatcher rd = request.getRequestDispatcher("./view/jogos/atualizar.jsp");
						rd.forward(request, response);

				}
		

}
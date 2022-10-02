package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Atividades;

public class AtividadesDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	//Metodo para salvar
	public void save(Atividades atividades) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados
		String sql = "INSERT INTO Atividades(materias)" + " VALUE(?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, atividades.getMaterias());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	//Metodo para deletar
	public void removeById(int id_atividades) {

		String sql = "DELETE FROM Atividades WHERE id_atividades = ?";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_atividades);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	//Metodo para atualizar
	public void update(Atividades atividades) {

		String sql = "UPDATE Atividades SET materias = ?" + "WHERE id_atividades = ?";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, atividades.getMaterias());

			pstm.setInt(2, atividades.getId_atividades());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	//Metodo para ler
	public List<Atividades> getAtividadesList() {

		String sql = "SELECT * FROM Atividades";

		List<Atividades> atividadesList = new ArrayList<Atividades>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Atividades atividades = new Atividades();

				// Recupera o id do banco e atribui ele ao objeto
				atividades.setId_atividades(rset.getInt("id_atividades"));

				// Recupera o nome do banco e atribui ele ao objeto
				atividades.setMaterias(rset.getString("Materias"));

				// Adiciono o contato recuperado, a lista de contatos
				atividadesList.add(atividades);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return atividadesList;
	}

	// Metodo obter atividade por id
	public Atividades atividadesById(int id_atividades) {
		String sql = "SELECT * FROM Atividades WHERE id_atividades = ?";

		ResultSet rset = null;

		Atividades atividades = new Atividades();

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_atividades);
			rset = pstm.executeQuery();

			rset.next();

			// Recupera o nome do banco e atribui ele ao objeto
			atividades.setMaterias(rset.getString("materias"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return atividades;
	}

}
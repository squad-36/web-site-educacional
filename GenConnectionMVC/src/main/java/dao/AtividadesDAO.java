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

<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
	//Metodo para salvar
=======
	// Metodo pra salvar
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java
	public void save(Atividades atividades) {
		String sql = "INSERT INTO atividades (materias) values(?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql

<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
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
=======
			pstm.setString(1, atividades.getMaterias());
			
			// Executar a sql para inserção dos dados
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java
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

<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
	//Metodo para ler
	public List<Atividades> getAtividadesList() {
=======
	// Metodo para Ler
	public List<Atividades> getAtividades() {
		String sql = "select * from atividades;";
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java

		List<Atividades> Atividades = new ArrayList<Atividades>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Atividades atividades = new Atividades();

				atividades.setId_atividades(rset.getInt("id_atividades"));

				atividades.setMaterias(rset.getString("materias"));
				
				Atividades.add(atividades);

<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
				// Adiciono o contato recuperado, a lista de contatos
				atividadesList.add(atividades);
=======
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java
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

		return Atividades;
	}
	// Metodo pra atualizar

<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
	// Metodo obter atividade por id
	public Atividades atividadesById(int id_atividades) {
		String sql = "SELECT * FROM Atividades WHERE id_atividades = ?";

		ResultSet rset = null;

		Atividades atividades = new Atividades();
=======
	public void update(Atividades atividades) {
		String sql = "UPDATE atividades set materias = ? where id_atividades = ?;";
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/AtividadesDAO.java
			pstm.setInt(1, id_atividades);
			rset = pstm.executeQuery();

			rset.next();
=======
>>>>>>> main:GenConnectionMVC/src/main/java/dao/AtividadesDAO.java

			pstm.setString(1, atividades.getMaterias());

			pstm.setInt(2, atividades.getId_atividades());

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

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM atividades WHERE id_atividades = ?";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public Atividades getAtividadesById(int id) {
		String sql = "SELECT * FROM atividades WHERE id_atividades = ?;";

		Atividades atividades = new Atividades();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			atividades.setId_atividades(rset.getInt("id_atividades"));

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
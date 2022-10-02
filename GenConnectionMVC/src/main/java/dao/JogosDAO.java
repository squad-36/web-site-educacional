package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Jogos;


public class JogosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Jogos Jogos) {
		String sql = "INSERT INTO Jogos (nome_jogos, pontos) values(?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setString(1, Jogos.getnome_jogos());
			
			pstm.setInt(2, Jogos.getPontos());
			
		
			// Executar a sql para inserção dos dados
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

	// Metodo para Ler
	public List<Jogos> getJogos() {
		String sql = "select * from Jogos;";

		List<Jogos> Jogos = new ArrayList<Jogos>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Jogos jogos = new Jogos();
				jogos.setId_jogos(rset.getInt("id_Jogos"));
				jogos.setnome_jogos(rset.getString("nome_jogos"));
				jogos.setPontos(rset.getInt("pontos"));
				Jogos.add(jogos);

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

		return Jogos;
	}
	// Metodo pra atualizar

	public void update(Jogos jogos) {
		String sql = "UPDATE Jogos set nome_jogos = ?, pontos = ? where id_jogos = ?;";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, jogos.getnome_jogos());		
			pstm.setInt(2, jogos.getPontos());	
			pstm.setInt(3, jogos.getId_jogos());
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
		String sql = "DELETE FROM Jogos WHERE id_jogos = ?";

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

	public Jogos getJogosById(int id) {
		String sql = "SELECT * FROM Jogos WHERE id_jogos = ?;";

		Jogos jogos = new Jogos();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			jogos.setId_jogos(rset.getInt("id_jogos"));

			jogos.setnome_jogos(rset.getString("nome_jogos"));
			
			jogos.setPontos(rset.getInt("pontos"));
			
		

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

		return jogos;
	}

}
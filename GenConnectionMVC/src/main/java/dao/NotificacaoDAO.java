package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Notificacao;

public class NotificacaoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Notificacao notificacao) {
		String sql = "INSERT INTO notificacao (nome_notificacao, mensagem) values(?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql

			pstm.setString(1, notificacao.getnome_notificacao());
<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/NotificacaoDAO.java

			pstm.setString(3, notificacao.getMensagem());
=======
			
			pstm.setString(2, notificacao.getMensagem());
>>>>>>> main:GenConnectionMVC/src/main/java/dao/NotificacaoDAO.java

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
	public List<Notificacao> getNotificacao() {
		String sql = "select * from notificacao;";

		List<Notificacao> Notificacao = new ArrayList<Notificacao>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
<<<<<<< HEAD:GenConnection-MVC/src/main/java/dao/NotificacaoDAO.java
				Notificacao notificacao = new Notificacao(0, sql, sql);

				notificacao.setnome_notificacao(rset.getString("nome"));

=======
				Notificacao notificacao = new Notificacao();

				notificacao.setnome_notificacao(rset.getString("nome_notificacao"));
				
>>>>>>> main:GenConnectionMVC/src/main/java/dao/NotificacaoDAO.java
				notificacao.setMensagem(rset.getString("mensagem"));

				notificacao.setId_notificacao(rset.getInt("id_notificacao"));

				Notificacao.add(notificacao);

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

		return Notificacao;
	}

	// Metodo pra atualizar
	public void update(Notificacao notificacao) {
		String sql = "UPDATE notificacao set nome_notificacao = ?, mensagem = ? where id_notificacao = ?;";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, notificacao.getnome_notificacao());

			pstm.setString(2, notificacao.getMensagem());

			pstm.setInt(3, notificacao.getId_notificacao());

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
		String sql = "DELETE FROM notificacao WHERE id_notificacao = ?";

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

	//Metodo obter notificacao por id
	public Notificacao getnotificacaoById(int id) {
		String sql = "SELECT * FROM notificacao WHERE id_notificacao = ?;";

		Notificacao notificacao = new Notificacao(id, sql, sql);

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			notificacao.setId_notificacao(rset.getInt("id_notificacao"));

			notificacao.setnome_notificacao(rset.getString("nome_notificacao"));

			notificacao.setMensagem(rset.getString("mensagem"));

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

		return notificacao;
	}

}

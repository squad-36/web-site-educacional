package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Usuario usuario) {
		String sql = "INSERT INTO Usuario (nome, email, senha, imagem) values(?, ?, ?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql

			pstm.setString(1, usuario.getNome());

			pstm.setString(2, usuario.getEmail());

			pstm.setString(3, usuario.getSenha());

			pstm.setString(4, usuario.getImagem());
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
	public List<Usuario> getUsuario() {
		String sql = "select * from Usuario;";

		List<Usuario> Usuario = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId_usuario(rset.getInt("id_usuario"));

				usuario.setNome(rset.getString("nome"));

				usuario.setEmail(rset.getString("email"));

				usuario.setSenha(rset.getString("senha"));

				usuario.setImagem(rset.getString("imagem"));

				Usuario.add(usuario);

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

		return Usuario;
	}

	// Metodo pra atualizar
	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario set nome = ?, email = ?, senha= ?, imagem = ? where id_usuario = ?;";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());

			pstm.setString(2, usuario.getEmail());

			pstm.setString(3, usuario.getSenha());

			pstm.setString(4, usuario.getImagem());

			pstm.setInt(5, usuario.getId_usuario());

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
		String sql = "DELETE FROM Usuario WHERE id_usuario = ?";

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

	//Metodo obter usuario por id
	public Usuario getusuarioById(int id) {
		String sql = "SELECT * FROM Usuario WHERE id_usuario = ?;";

		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			usuario.setId_usuario(rset.getInt("id_usuario"));

			usuario.setNome(rset.getString("nome"));

			usuario.setEmail(rset.getString("email"));

			usuario.setSenha(rset.getString("senha"));

			usuario.setImagem(rset.getString("imagem"));

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

		return usuario;
	}

}
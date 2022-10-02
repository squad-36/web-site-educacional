package model;

public class Usuario {

	private int id_usuario;
	private String nome;
	private String senha;
	private String email;
	private String imagem;

	// Contrutores
	public Usuario() {
	}

	public Usuario(int id_usuario, String nome, String senha, String email, String imagem) {
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.setImagem(imagem);
	}

	// Gets e sets
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
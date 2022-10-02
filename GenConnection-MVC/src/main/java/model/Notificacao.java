package model;

public class Notificacao {

	private int id_notificacao;
	private String nome_notificacao;
	private String mensagem;

	// Construtores
	public Notificacao() {
	}

	public Notificacao(int id_notificacao, String nome_notificacao, String mensagem) {
		this.id_notificacao = id_notificacao;
		this.nome_notificacao = nome_notificacao;
		this.mensagem = mensagem;
	}

	// Gets e Sets
	public int getId_notificacao() {
		return id_notificacao;
	}

	public void setId_notificacao(int id_notificacao) {
		this.id_notificacao = id_notificacao;
	}

	public String getnome_notificacao() {
		return nome_notificacao;
	}

	public void setnome_notificacao(String nome_notificacao) {
		this.nome_notificacao = nome_notificacao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

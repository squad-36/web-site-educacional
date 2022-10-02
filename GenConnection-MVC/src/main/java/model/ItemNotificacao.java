package model;

public class ItemNotificacao {

	private int id_usuario;
	private int id_notificacao;
	private String data;

	// Construtores
	public ItemNotificacao() {
	}

	public ItemNotificacao(int id_usuario, int id_notificacao, String data) {
		this.id_usuario = id_usuario;
		this.id_notificacao = id_notificacao;
		this.data = data;
	}

	// Gets e Sets
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_notificacao() {
		return id_notificacao;
	}

	public void setId_notificacao(int id_notificacao) {
		this.id_notificacao = id_notificacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
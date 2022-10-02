package model;

public class Permissao {

	private int id_permissao;
	private String nome_permissao;

	// Construtores
	public Permissao() {
	}

	public Permissao(int id_permissao, String nome_permissao) {
		this.id_permissao = id_permissao;
		this.nome_permissao = nome_permissao;
	}

	// Gets e Sets
	public int getId_permissao() {
		return id_permissao;
	}

	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}

	public String getnome_permissao() {
		return nome_permissao;
	}

	public void setnome_permissao(String nome_permissao) {
		this.nome_permissao = nome_permissao;
	}

}

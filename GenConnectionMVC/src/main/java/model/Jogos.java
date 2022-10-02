package model;

public class Jogos {

	private int id_jogos;
	private String nome_jogos;
	private int pontos;

//Construtores
	public Jogos() {
	}

	public Jogos(int id_jogos, String nome_jogos, int pontos) {

		this.id_jogos = id_jogos;
		this.nome_jogos = nome_jogos;
		this.pontos = pontos;
	}

//Gets e Sets
	public int getId_jogos() {
		return id_jogos;
	}

	public void setId_jogos(int id_jogos) {
		this.id_jogos = id_jogos;
	}

	public String getnome_jogos() {
		return nome_jogos;
	}

	public void setnome_jogos(String nome_jogos) {
		this.nome_jogos = nome_jogos;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
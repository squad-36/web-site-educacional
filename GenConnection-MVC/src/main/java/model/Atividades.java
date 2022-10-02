package model;

public class Atividades {

	private int id_atividades;
	private String materias;

	// Construtores
	public Atividades() {
	}

	public Atividades(int id_atividades, String materias) {
		this.id_atividades = id_atividades;
		this.materias = materias;
	}

	// Gets e Sets
	public int getId_atividades() {
		return id_atividades;
	}

	public void setId_atividades(int id_atividades) {
		this.id_atividades = id_atividades;
	}

	public String getMaterias() {
		return materias;
	}

	public void setMaterias(String materias) {
		this.materias = materias;
	}

}

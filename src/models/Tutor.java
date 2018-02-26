package models;

public class Tutor {

	private String disciplina;
	private int proficiencia;
	private int avaliacao;
	private int quantia;
	
	public Tutor(String disciplina, int proficiencia) {
		if (disciplina == null) {
			throw new NullPointerException();
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (proficiencia <= 0) {
			throw new ArithmeticException("Erro na definicao de papel: Proficiencia invalida");
		}
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.quantia = 0;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getQuantia() {
		return quantia;
	}

	public void setQuantia(int quantia) {
		this.quantia = quantia;
	}
	
	
	
	
}

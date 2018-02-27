package models;

public class Disciplina {
	
	private String disciplina;
	private int proficiencia;
	
	public Disciplina(String disciplina, int proficiencia) {
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
	}
	
	public int getProficiencia() {
		return this.proficiencia;
	}

}

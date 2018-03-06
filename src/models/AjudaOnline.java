package models;

public class AjudaOnline {

	private String matriculaAluno;
	private String disciplina;
	private String matriculaTutor;
	
	public AjudaOnline(String aluno, String disciplina, String tutor) {
		this.matriculaAluno = aluno;
		this.disciplina = disciplina;
		this.matriculaTutor = tutor;
	}

	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public String getMatriculaTutor() {
		return matriculaTutor;
	}
	
	
}

package models;

public class AjudaOnline {

	private String matriculaAluno;
	private String disciplina;
	private String matriculaTutor;
	
	public AjudaOnline(String aluno, String disciplina, String tutor) {
		if (aluno == null) {
			throw new NullPointerException("matricula de aluno nao pode ser vazio ou em branco");
		} 
		if (aluno.trim().equals("")) {
			throw new IllegalArgumentException("matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null) {
			throw new NullPointerException("disciplina nao pode ser vazio ou em branco");
		} 
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("disciplina nao pode ser vazio ou em branco");
		}
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

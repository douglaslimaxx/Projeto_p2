package ajuda;

import aluno.Aluno;

/**
 * Cria uma classe AjudaOnline que, atraves da disciplina, matriculaAluno e matriculaTutor, cadastra
 * pedidos de ajudas online.
 * @author Douglas Lima 
 *
 */

public class AjudaOnline {

	private String matriculaAluno;
	private String disciplina;
	private Aluno tutor;
	
	/**
	 * Metodo que cadrasta o pedido de ajuda online dos alunos a partir dos parametros 
	 * aluno, disciplina e tutor.
	 * 
	 * @param aluno String que representa o aluno que pediu ajuda.
	 * @param disciplina String que representa a disciplina.
	 * @param tutor2 String que representa o tutor.
	 */	
	public AjudaOnline(String aluno, String disciplina, Aluno tutor2) {
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
		this.tutor = tutor2;
	}
       /**
	 * Metodo que retorna a matricula do aluno.
	 * @return String.
	 */
	public String getMatriculaAluno() {
		return matriculaAluno;
	}

	/**
	 * Metodo que retorna a disciplina.
	 * @return String.
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Metodo que retorna a matricula do tutor.
	 * @return String.
	 */
	public Aluno getTutor() {
		return tutor;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.tutor.getMatricula() + ", disciplina - " + this.disciplina;
	}
}

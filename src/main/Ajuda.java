package main;

import java.io.Serializable;

public abstract class Ajuda implements Serializable{

	/**
	 *  @author Douglas
	 */
	private static final long serialVersionUID = 3L;
	protected String matriculaAluno;
	protected String disciplina;
	protected Aluno tutor;
	protected boolean avaliada;

	/**
	 * Metodo que cadrasta o pedido de ajuda online dos alunos a partir dos parametros 
	 * aluno, disciplina e tutor.
	 * 
	 * @param aluno String que representa o aluno que pediu ajuda.
	 * @param disciplina String que representa a disciplina.
	 * @param tutor2 String que representa o tutor.
	 */	
	public Ajuda(String aluno, String disciplina, Aluno tutor2) {
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
		this.avaliada = false;
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
	
	/**
	 * Metodo retorna algum atributo da ajuda. Mas qual do atributos sera retornado, 
	 * e determinado pelo parametro.
	 * @param atributo String que determina qual atributo sera retornado.
	 * @return String que e um dos atributos de Ajuda.
	 */
	public abstract String getInfoAjuda(String atributo);
	
	/**
	 * Metodo que muda o estado de uma ajuda para avaliada, caso essa nao tenha sido 
	 * avaliada. Se caso a ajuda ja foi avaliada, e lançado uma excecao.
	 */
	public void avaliando() {
		if (this.avaliada == true) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: Ajuda ja avaliada");
		} else {
			this.avaliada = true;
		}
	}
	
	@Override
	public abstract String toString();
	
}

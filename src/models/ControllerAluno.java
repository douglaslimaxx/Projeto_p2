package models;

/**
 * Essa classe e usada como controlador para a classe alunos.
 * 
 * @author Gabriel Felipe Cardoso Gomes - 117110681
 */

import java.util.HashMap;

public class ControllerAluno {

	private HashMap<String, Aluno> alunos;
	
	/**
	 * Construtor do Controller, ele cria um HashMap onde os alunos
	 * serao armazenados.
	 */
	public ControllerAluno() {
		alunos = new HashMap<String, Aluno>();
	}
	
	/**
	 * O controlador ira cadastrar o aluno no HashMap de forma
	 * matricula do aluno : aluno ( chave : valor ).
	 * @param nome String Representa o nome do aluno.
	 * @param matricula String Representa a matricula do aluno.
	 * @param codigoCurso int Um valor respectivo ao codigo do curso do aluno.
	 * @param telefone String Representa o telefone do aluno.
	 * @param email String Representa o email do aluno.
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunos.put(matricula, new Aluno(nome, matricula, email, telefone, codigoCurso));
	}
	
	/**
	 * Apos realizar a matricula do aluno para busca-lo, retornara uma
	 * representacao textual do cadastro do aluno.
	 * @param matricula String Matricula do aluno que sera procurada.
	 * @return String referente a representacao visual do aluno.
	 */
	
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString();
	}
	
	/**
	 * Lista todos os alunos que foram cadastrados no sistema.
	 * @return String referente a representacao visual dos alunos.
	 */
	public String listaAlunos() {
		String ret = "";
		int qtd = 0;
		for(Aluno a : alunos.values()) {
			if(qtd != 0)ret += ", ";
			ret += a.toString();
			qtd++;
		}
		return ret;
	}
	
	/**
	 * Retorna um atributo de particular de aluno.
	 * 
	 * @param matricula String referente a matricula do aluno
	 * @param atributo String referente ao atributo que sera retornado
	 * @return String representacao textual daquele atributo
	 */
	public String getInfoAluno(String matricula, String atributo) {
		switch(atributo) {
			case "nome":
				return alunos.get(matricula).getNome();
			case "matricula":
				return alunos.get(matricula).getMatricula();
			case "codigoCurso":
				return "" + alunos.get(matricula).getCodigoCurso();
			case "telefone":
				return alunos.get(matricula).getTelefone();
			case "email":
				return alunos.get(matricula).getEmail();
		}
		throw new IllegalArgumentException("");
	}
	
	/**
	 * Ao receber a matricula de um aluno, ira transformar aquele aluno em tutor daquela disciplina.
	 * 
	 * @param matricula String referente a matricula do aluno
	 * @param disciplina String referente a disciplina que o aluno sera tutor
	 * @param proficiencia int respectivo ao nivel de proficiencia daquele aluno naquela disciplina
	 */
	public void tornaTutor(String matricula, String disciplina, int proficiencia) {
		alunos.get(matricula).tornaTutor(disciplina, proficiencia);
	}
	
	/**
	 * Recupera a representacao textual de um tutor.
	 * 
	 * @param matricula String a matricula referente ao tutor o qual voce quer a representacao.
	 * @return String que representa um tutor de forma textual.
	 */
	public String recuperaTutor(String matricula) {
		if(alunos.get(matricula).isTutor()) return alunos.get(matricula).toString();
		throw new IllegalArgumentException("");
	}
	
	
	/**
	 * Retorna a representacao textual de todos os tutores cadastrados.
	 * 
	 * @return String com a representacao textual de todos os tutores que estao cadastrados.
	 */
	public String listaTutores() {
		String ret = "";
		int qtd = 0;
		for(Aluno a : alunos.values()) {
			if(!a.isTutor())continue;
			if(qtd != 0)ret += ", ";
			ret += a.toString();
			qtd++;
		}
		return ret;
	}
	
}

package models;

import java.util.ArrayList;

/**
 * Essa classe e usada como controlador para a classe alunos.
 * 
 * @author Gabriel Felipe Cardoso Gomes - 117110681
 */

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerAluno {

	private HashMap<String, Aluno> alunos;
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
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
		if(!validarEmail(email))throw new IllegalArgumentException("Email invalido");
		if(alunos.containsKey(matricula))throw new IllegalArgumentException("Aluno de mesma matricula ja cadastrado");
		alunos.put(matricula, new Aluno(nome, matricula, email, telefone, codigoCurso));
	}
	
	/**
	 * Metodo que verifica se um email e valido para o sistema, ou seja, se existe um "@" e conteudo antes e depois da mesma.
	 * @return boolean.
	 */	
    public static boolean validarEmail(String email){
        Matcher matcher; 
        matcher = pattern.matcher(email);
        return matcher.matches();
     }
    
	/**
	 * Apos realizar a matricula do aluno para busca-lo, retornara uma
	 * representacao textual do cadastro do aluno.
	 * @param matricula String Matricula do aluno que sera procurada.
	 * @return String referente a representacao visual do aluno.
	 */
	
	public String recuperaAluno(String matricula) {
		if(!alunos.containsKey(matricula)) throw new UnsupportedOperationException("Aluno nao encontrado");
		return alunos.get(matricula).toString();
	}
	
	/**
	 * Lista todos os alunos que foram cadastrados no sistema.
	 * @return String referente a representacao visual dos alunos.
	 */
	public String listaAlunos() {
		//GMB
		ArrayList<Aluno> alunosOrdenados = new ArrayList<Aluno>();
		for(Aluno a : alunos.values())alunosOrdenados.add(a);
		alunosOrdenados.sort((a1, a2) -> a1.getNome().compareTo(a2.getNome()));
		String ret = "";
		int qtd = 0;
		for(Aluno a : alunosOrdenados) {
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
		if(!alunos.containsKey(matricula)) throw new UnsupportedOperationException("Aluno nao encontrado");
		switch(atributo) {
			case "Nome":
				return alunos.get(matricula).getNome();
			case "Matricula":
				return alunos.get(matricula).getMatricula();
			case "CodigoCurso":
				return "" + alunos.get(matricula).getCodigoCurso();
			case "Telefone":
				return alunos.get(matricula).getTelefone();
			case "Email":
				return alunos.get(matricula).getEmail();
		}
		throw new IllegalArgumentException("Atributo nao encontrado");
	}
	
	/**
	 * Ao receber a matricula de um aluno, ira transformar aquele aluno em tutor daquela disciplina.
	 * 
	 * @param matricula String referente a matricula do aluno
	 * @param disciplina String referente a disciplina que o aluno sera tutor
	 * @param proficiencia int respectivo ao nivel de proficiencia daquele aluno naquela disciplina
	 */
	public void tornaTutor(String matricula, String disciplina, int proficiencia) {
		if(!alunos.containsKey(matricula)) throw new UnsupportedOperationException("Tutor nao encontrado");
		alunos.get(matricula).tornaTutor(disciplina, proficiencia);
	}
	
	/**
	 * Recupera a representacao textual de um tutor.
	 * 
	 * @param matricula String a matricula referente ao tutor o qual voce quer a representacao.
	 * @return String que representa um tutor de forma textual.
	 */
	public String recuperaTutor(String matricula) {
		if(!alunos.containsKey(matricula)) throw new UnsupportedOperationException("Tutor nao encontrado");
		if(alunos.get(matricula).isTutor()) return alunos.get(matricula).toString();
		throw new IllegalArgumentException("Tutor nao encontrado");
	}
	
	private Aluno alunoPorEmail(String email) {
		for(Aluno a : alunos.values()) {
			if(a.getEmail().equals(email))return a;
		}
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

	/**
	 * Cadastra o local de atendimento de um tutor com base no e-mail dele.
	 * @param email do aluno que tera o local atendimento cadastrado.
	 * @param local disponivel que o tutor possuira.
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		alunoPorEmail(email).cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Cadastra o horario em que um tutor estara disponivel com base no e-mail dele.
	 * @param email do tutor que tera o horario disponivel.
	 * @param horario disponivel do tutor.
	 * @param dia que o tutor estara disponivel.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		alunoPorEmail(email).cadastrarHorario(horario, dia);
		
	}

	/**
	 * Consulta se o tutor do email especificado possui esse horario e dia disponivel.
	 * @param email do aluno que voce quer verificar.
	 * @param horario que sera verificado.
	 * @param dia que sera verificado.
	 * @return booleano que representa se existe ou nao horario disponivel.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return alunoPorEmail(email).consultaHorario(horario, dia);
	}

	/**
	 * Consulta se o tutor do email especificado tem o local especificado disponível.
	 * @param email do aluno que voce quer verificar.
	 * @param local que sera verificado.
	 * @return booleano que representa se existe ou nao horario disponivel.
	 */
	public boolean consultaLocal(String email, String local) {
		return alunoPorEmail(email).consultaLocal(local);
	}

	public int totalDinheiroTutor(String email) {
		return alunoPorEmail(email).totalDinheiroTutor();
	}

	public void doar(String matriculaTutor, int valor) {
		alunos.get(matriculaTutor).doar(valor);
	}

	public String melhorTutor(String disciplina) {
		
		return null;
	}
	
}

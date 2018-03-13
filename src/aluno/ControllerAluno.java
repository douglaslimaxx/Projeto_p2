package aluno;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Essa classe e usada como controlador para a classe alunos.
 * 
 * @author Gabriel Felipe Cardoso Gomes - 117110681
 */

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import comparadores.EmailComparador;
import comparadores.MatriculaComparador;
import comparadores.NomeComparador;

public class ControllerAluno {

	private HashMap<String, Aluno> alunos;
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	private Comparator<Aluno> comparador;
	/**
	 * Construtor do Controller, ele cria um HashMap onde os alunos
	 * serao armazenados.
	 */
	public ControllerAluno() {
		alunos = new HashMap<String, Aluno>();
		this.comparador = new NomeComparador();
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
		validarEmail(email);
		if(alunos.containsKey(matricula))throw new IllegalArgumentException("Aluno de mesma matricula ja cadastrado");
		alunos.put(matricula, new Aluno(nome, matricula, email, telefone, codigoCurso, (this.alunos.size() + 1)));
	}
	
	/**
	 * Metodo que verifica se um email e valido para o sistema, ou seja, se existe um "@" e conteudo antes e depois da mesma.
	 * @return boolean.
	 */	
    public void validarEmail(String email){
    	if(email == null || email.trim().equals(""))throw new IllegalArgumentException("email nao pode ser vazio ou em branco");
        Matcher matcher; 
        matcher = pattern.matcher(email);
        if(!matcher.matches())throw new IllegalArgumentException("Email invalido");
     }
    
	/**
	 * Apos realizar a matricula do aluno para busca-lo, retornara uma
	 * representacao textual do cadastro do aluno.
	 * @param matricula String Matricula do aluno que sera procurada.
	 * @return String referente a representacao visual do aluno.
	 */
	
	public String recuperaAluno(String matricula) {
		if (matricula == null || matricula.trim().equals("")) throw new IllegalArgumentException("Matricula nao pode ser vazia ou nula");
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
		if(matricula == null || matricula.trim().equals("")) throw new IllegalArgumentException("matricula nao pode ser vazia ou nula");
		if(atributo == null || atributo.trim().equals("")) throw new IllegalArgumentException("Atributo nao pode ser vazio ou nulo");
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
		throw new IllegalArgumentException("Atributo invalido");
	}
	
	/**
	 * Ao receber a matricula de um aluno, ira transformar aquele aluno em tutor daquela disciplina.
	 * 
	 * @param matricula String referente a matricula do aluno
	 * @param disciplina String referente a disciplina que o aluno sera tutor
	 * @param proficiencia int respectivo ao nivel de proficiencia daquele aluno naquela disciplina
	 */
	public void tornaTutor(String matricula, String disciplina, int proficiencia) {
		if (matricula == null || matricula.trim().equals("")) throw new IllegalArgumentException("matricula nao pode ser vazia ou nula");
		if (disciplina == null || disciplina.trim().equals("")) throw new IllegalArgumentException("disciplina nao pode ser vazia ou nula");
		if (proficiencia <= 0 || proficiencia > 5) throw new NoSuchElementException("Proficiencia invalida");
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
		if (matricula == null || matricula.trim().equals("")) throw new IllegalArgumentException("matricula nao pode ser vazia ou nula");
		if(!alunos.containsKey(matricula)) throw new UnsupportedOperationException("Tutor nao encontrado");
		if(alunos.get(matricula).isTutor()) {
			return alunos.get(matricula).toString();
		} else {
			throw new IllegalArgumentException("aluno nao tutor");
		}
	}
	
	private Aluno alunoPorEmail(String email) {
		for(Aluno a : alunos.values()) {
			if(a.getEmail().equals(email))return a;
		}
		return null;
	}
	
	/**
	 * Retorna a representacao textual de todos os tutores cadastrados.
	 * 
	 * @return String com a representacao textual de todos os tutores que estao cadastrados.
	 */
	public String listaTutores() {
		String ret = "";
		int qtd = 0;
		List<Aluno> tutoresOrdenados = new ArrayList<Aluno>();
		tutoresOrdenados.addAll(alunos.values());
		tutoresOrdenados = tutoresOrdenados.stream().filter((Aluno t) -> t.isTutor() == true)
				.collect(Collectors.toList());
		tutoresOrdenados.sort(comparador);
		for(Aluno a : tutoresOrdenados) {
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
		if (local == null || local.trim().equals("")) throw new IllegalArgumentException("local nao pode ser vazio ou em branco");
		validarEmail(email);
		Aluno aluno = alunoPorEmail(email);
		if(aluno == null)throw new IllegalArgumentException("tutor nao cadastrado");
		alunoPorEmail(email).cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Cadastra o horario em que um tutor estara disponivel com base no e-mail dele.
	 * @param email do tutor que tera o horario disponivel.
	 * @param horario disponivel do tutor.
	 * @param dia que o tutor estara disponivel.
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		if (horario == null || horario.trim().equals("")) throw new IllegalArgumentException("horario nao pode ser vazio ou em branco");
		if (dia == null || dia.trim().equals("")) throw new IllegalArgumentException("dia nao pode ser vazio ou em branco");
		validarEmail(email);
		Aluno aluno = alunoPorEmail(email);
		if(aluno == null)throw new IllegalArgumentException("tutor nao cadastrado");
		aluno.cadastrarHorario(horario, dia);
		
	}

	/**
	 * Consulta se o tutor do email especificado possui esse horario e dia disponivel.
	 * @param email do aluno que voce quer verificar.
	 * @param horario que sera verificado.
	 * @param dia que sera verificado.
	 * @return booleano que representa se existe ou nao horario disponivel.
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		validarEmail(email);
		Aluno aluno = alunoPorEmail(email);
		if(aluno == null)return false;
		return aluno.consultaHorario(horario, dia);
	}

	/**
	 * Consulta se o tutor do email especificado tem o local especificado disponível.
	 * @param email do aluno que voce quer verificar.
	 * @param local que sera verificado.
	 * @return booleano que representa se existe ou nao horario disponivel.
	 */
	public boolean consultaLocal(String email, String local) {
		validarEmail(email);
		Aluno aluno = alunoPorEmail(email);
		if(aluno == null)return false;
		return aluno.consultaLocal(local);
	}

	public int totalDinheiroTutor(String email) {
		validarEmail(email);
		return alunoPorEmail(email).totalDinheiroTutor();
	}

	public void doar(String matriculaTutor, int valor) {
		if (!(this.alunos.containsKey(matriculaTutor))) {
			throw new IllegalArgumentException("Tutor nao encontrado");
		}
		if (!(this.alunos.get(matriculaTutor).isTutor())) throw new IllegalArgumentException("aluno nao eh tutor");
		this.alunos.get(matriculaTutor).doar(valor);
	}
	
	public double pegarNota(String matriculaTutor) {
		return this.alunos.get(matriculaTutor).getTutoria().getAvaliacao();
	}
	
	public String pegarNivel(String matriculaTutor) {
		String nivel = "";
		if (this.alunos.get(matriculaTutor).getTutoria().getAvaliacao() > 4.5) {
			nivel = "TOP";
		} else if ((this.alunos.get(matriculaTutor).getTutoria().getAvaliacao() > 3) && (this.alunos.get(matriculaTutor).getTutoria().getAvaliacao() <= 4.5)) {
			nivel = "Tutor";
		} else {
			nivel = "Aprendiz";
		} 
		return nivel;
	}

	public Aluno melhorTutor(String disciplina) {
		List<Aluno> tutores = new ArrayList<>();
		tutores.addAll(this.alunos.values());
		tutores = tutores.stream().filter((Aluno t) -> t.isTutor() == true)
				.collect(Collectors.toList());
		tutores = tutores.stream().filter((Aluno t) -> t.getTutoria().contemDisciplina(disciplina) == true)
				.collect(Collectors.toList());
		if (tutores.size() != 0) {
			return this.compareTutor(tutores, disciplina);
		}
		return null;
	}
	
	public Aluno melhorTutor(String disciplina, String horario, String dia, String local) {
		List<Aluno> tutores = new ArrayList<>();
		tutores.addAll(this.alunos.values());
		tutores = tutores.stream().filter((Aluno t) -> t.isTutor() == true)
				.collect(Collectors.toList());
		tutores = tutores.stream().filter((Aluno t) -> t.getTutoria().contemDisciplina(disciplina) == true)
				.collect(Collectors.toList());
		tutores = tutores.stream().filter((Aluno t) -> t.getTutoria().consultaHorario(horario, dia) == true)
				.collect(Collectors.toList());
		tutores = tutores.stream().filter((Aluno t) -> t.getTutoria().consultaLocal(local) == true)
				.collect(Collectors.toList());
		if (tutores.size() != 0) {
			return this.compareTutor(tutores, disciplina);
		}
		return null;
	}
	
	
	private Aluno compareTutor(List<Aluno> tutoresParaAjuda, String disciplina) {
		Aluno melhorTutor = null;
		int melhorProficiencia = 0;
		for (Aluno a : tutoresParaAjuda) {
			if (a.getTutoria().getDisciplina(disciplina).getProficiencia() > melhorProficiencia) {
				melhorTutor = a;
				melhorProficiencia = a.getTutoria().getDisciplina(disciplina).getProficiencia(); 
			}
		}
		return melhorTutor;
	}
	
	public void configurarOrdem(String atributo) {
		switch (atributo) {
		case "NOME":
			this.comparador = new NomeComparador();
			break;
		case "EMAIL":
			this.comparador = new EmailComparador();
			break;
		case "MATRICULA":
			this.comparador = new MatriculaComparador();
			break;
		default:
			throw new IllegalArgumentException("Erro na configuracao da ordem: Atributo invalido");
		}
	}
}

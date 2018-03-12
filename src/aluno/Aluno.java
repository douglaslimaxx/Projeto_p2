package aluno;


/**
 * Cria uma classe aluno atraves de sua matricula, nome, telefone e codigo de curso e email.
 * @author Marta Lais de Macedo Dantas.
 *
 */
public class Aluno {
	
	private int codigoCurso;
	private String matricula, nome, telefone, email;
	private Tutoria tutoria;
	private int cadastro;
	
	/**
	 * Metodo que constroi um objeto do tipo Aluno a partir dos parametros 
	 * nome, matricula, email, telefone e codigo do curso.
	 * 
	 * @param nome String que representa o nome do Aluno.
	 * @param matricula String que representa a matricula do Aluno.
	 * @param email String que representa o email do Aluno.
	 * @param telefone String que representa o telefone do Aluno.
	 * @param codigoCurso int que representa o codigo do curso do Aluno.
	 */
	public Aluno(String nome, String matricula, String email, String telefone, int codigoCurso, int cadastro) {
		if(nome == null || nome.trim().equals(""))throw new NullPointerException("Nome nao pode ser vazio ou nulo");
		if(matricula == null || matricula.trim().equals(""))throw new NullPointerException("matricula nao pode ser vazia ou nula");
		
		this.email = email;
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;
		this.tutoria = new Tutoria();
		this.cadastro = cadastro;
		
	}
	
	/**
	 * Metodo que retorna o codigo do curso.
	 * @return int.
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}
	
	/**
	 * Metodo que retorna a matricula.
	 * @return String.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Metodo que retorna o nome.
	 * @return String.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna o telefone.
	 * @return String.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo modifica o numero do telefone do Aluno a partir do parametro.
	 * @param telefone String que e o novo numero de telefone do Aluno.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo que retorna o email.
	 * @return String.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo modifica o email do aluno a partir do parametro.
	 * @param email String que e o novo do email do Aluno. 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Metodo que retorna um objeto do tipo Tutoria.
	 * @return Tutoria que e um objeto do tipo Tutoria.
	 */
	public Tutoria getTutoria() {
		return this.tutoria;
	}
	
	
    /**
	 * Metodo que retorna o formato de impressao do aluno.
	 * O telefone e opcional.
	 * @return toString de saida do Aluno.
	 */	
	@Override 
	public String toString() {
		if (telefone.equals(null) || telefone.trim().equals("")) {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - " + this.email;
		}
	}
	
	/**
	 * Metodo que valida um tutor.
	 * @return 
	 */
	public boolean isTutor() {
		return this.tutoria.isTutor();
	}
	
	/**
	 * Metodo que adiciona disciplina.
	 * @param disciplina String que representa a disciplina.
	 * @param proficiencia int que representa a proficiencia.                                                                                                                                             
	 * @return 
	 */	
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		if (disciplina == null) {
			throw new NullPointerException("disciplina nao pode ser vazia ou nula");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("disciplina nao pode ser vazia ou nula");
		}
		tutoria.adicionaDisciplina(disciplina, proficiencia);
	}

	/**
	 * Metodo que consulta o horário.
	 * @param horario String que representa o horario.
	 * @param dia String que representa o dia.                                                                                                                                             
	 * @return String.
	 */	 
	public boolean consultaHorario(String horario, String dia) {
		if (horario == null) {
			throw new NullPointerException("horario nao pode ser vazio ou nulo");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("horario nao pode ser vazio ou nulo");
		}
		if (dia == null) {
			throw new NullPointerException("horario nao pode ser vazio ou nulo");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("dia nao pode ser vazio ou nulo");
		}
		return tutoria.consultaHorario(horario, dia);
	}
	
	/**
	 * Metodo que consulta o local.
	 * @param local String que representa o local.                                                                                                                                         
	 * @return String.
	 */	 
	public boolean consultaLocal(String local) {
		if (local == null) {
			throw new NullPointerException("local nao pode ser vazio ou nulo");
		}
		if (local.trim().equals("")) {
			throw new IllegalArgumentException("local nao pode ser vazio ou nulo");
		}
		return tutoria.consultaLocal(local);
	}


	/**
	 * Metodo que cadastra o horario.
	 * @param horario String que representa o horario.
	 * @param dia String que representa o dia.                                                                                                                                      
	 * @return String.
	 */	 
	public void cadastrarHorario(String horario, String dia) {
		if (horario == null) {
			throw new NullPointerException("horario nao pode ser vazio ou em branco");
		}
		if (horario.trim().equals("")) {
			throw new IllegalArgumentException("horario nao pode ser vazio ou em branco");
		}
		if (dia == null) {
			throw new NullPointerException("dia nao pode ser vazio ou em branco");
		}
		if (dia.trim().equals("")) {
			throw new IllegalArgumentException("dia nao pode ser vazio ou em branco");
		}
		tutoria.cadastrarHorario(horario, dia);
	}

	/**
	 * Metodo que cadastra o local de atendimento.
	 * @param local String que representa o local.                                                                                                                                   
	 * @return String.
	 */	 
	public void cadastrarLocalDeAtendimento(String local) {
		if (local == null) {
			throw new NullPointerException("local nao pode ser vazio ou em branco");
		}
		if (local.trim().equals("")) {
			throw new IllegalArgumentException("local nao pode ser vazio ou em branco");
		}
		tutoria.cadastrarLocalDeAtendimento(local);
	}

	/**
	 * Metodo que transforma em tutor a partir da disciplina e da proeficiencia.
	 * @param disciplina String referente a disciplina.
	 * @param proficiencia int referente a proficiencia. 
	 * @return 
	 */
	public void tornaTutor(String disciplina, int proficiencia) {
		if (disciplina == null) {
			throw new NullPointerException("disciplina nao pode ser vazia ou nula");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("disciplina nao pode ser vazia ou nula");
		}
		this.tutoria.adicionaDisciplina(disciplina, proficiencia);		
	}

	/**
	 * Metodo que retorna o total de dinheiro do tutor.                                                                                                                              
	 * @return String.
	 */	 
	public int totalDinheiroTutor() {
		return tutoria.totalDinheiroTutor();
	}

	/**
	 * Metodo que faz a doacao de aluno para tutor.                                                                                                                              
	 * @return String.
	 */	 
	public void doar(int valor) {
		if (valor <= 0) {
			throw new UnsupportedOperationException("doacao nao pode ser zero ou negativa");
		}
		this.tutoria.doar(valor);
	}

	/**
	 * Metodo que retorna o cadastro.                                                                                                                              
	 * @return String.
	 */	 
	public int getCadastro() {
		return this.cadastro;
	}
}

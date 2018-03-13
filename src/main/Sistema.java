package main;

/**
 * Representa um Sistema de tutorias, onde alunos podem encontrar tutores que ensinam 
 * certas disciplinas, e tambem podem se tornar tutores de algumas disciplinas.
 * @author Douglas Lima
 *
 */
public class Sistema {
	
	
	private int dinheiroSistema;
	private ControllerAluno controllerAluno;
	private ControllerAjuda controllerAjuda;
	
	/**
	 * Constroi o Sistema, inicializando os seus dois atributos que sao controllers.
	 */
	public Sistema() {
		this.dinheiroSistema = 0;
		this.controllerAluno = new ControllerAluno();
		this.controllerAjuda = new ControllerAjuda();
	}
	
	/**
	 * Metodo que cadastra um aluno no sistema a partir dos parametros nome, matricula,
	 * codigoCurso, telefone e email.
	 * @param nome String referente ao nome do Aluno.
	 * @param matricula String referente ao matricula do Aluno. 
	 * @param codigoCurso int referente ao codigo do curso no qual o Aluno esta sendo matriculado.
	 * @param telefone String referente ao numero de telefone do Aluno.
	 * @param email String referente ao email do Aluno.
	 */
    public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
    	try {
    		this.controllerAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
    	} catch (Exception e){
    		throw new IllegalArgumentException("Erro no cadastro de aluno: " + e.getMessage());
    	}
    }
	
    /**
     * Metodo retorna a representacao textual do aluno, cuja matrícula sera passada 
     * como parametro.
     * @param matricula String referente a matricula do Aluno a ser exibido.
     * @return String de representacao textual do Aluno.
     */
    public String recuperaAluno(String matricula) {
    	try {
    		return this.controllerAluno.recuperaAluno(matricula);
    	}catch(Exception e) {
    		throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
    	}
    }
    
    /**
     * Metodo retorna uma lista contendo a representacao de todos os Alunos matriculados, 
     * ordenados a partir do nome.
     * @return String que e juncao da representacao textual dos Alunos.
     */
    public String listarAlunos() {
    	return this.controllerAluno.listaAlunos();
    }
    
    /**
     * Metodo que pega as informacoes dos alunos atraves da matricula e atributo.
     * @param matricula String referente a matricula do Aluno.
     * @param atributo 
     * @return 
     */
    public String getInfoAluno(String matricula, String atributo) {
    	try {
    		return this.controllerAluno.getInfoAluno(matricula, atributo);
    	}catch (Exception e) {
    		throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
    	}
    }
    
   /**
     * Metodo que transforma o Aluno em tutor atraves da matricula, disciplina e proficiencia.
     * @param matricula String referente a matricula do Aluno.
     * @param disciplina String referente a disciplina que sera dada a tutoria.
     * @param proficiencia int referente a proficiencia do tutor.
     * @return 
     */
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
    	try {
    		this.controllerAluno.tornaTutor(matricula, disciplina, proficiencia);
    	}catch (Exception e) {
    		throw new IllegalArgumentException("Erro na definicao de papel: " + e.getMessage());
    	}
    }
    
   /**
     * Metodo que recupera o Tutor atraves da matricula. 
     * @param matricula referente a matricula do Tutor.
     * @return
     */
    public String recuperaTutor(String matricula) {
    	try {
    		return this.controllerAluno.recuperaTutor(matricula);
    	}catch (Exception e) {
    		throw new IllegalArgumentException("Erro na busca por tutor: " + e.getMessage());
    	}
    }
    
   /**
     * Metodo que lista os tutores.
     * @return lista de tutores.
     */
    public String listarTutores() {
    	return this.controllerAluno.listaTutores();
    }
    
   /**
     * Metodo que cadastra os horarios dos tutores.
     * @param email String referente ao email do tutor.
     * @param horario String referente ao horario da tutoria.
     * @param dia String que referente ao dia da tutoria. 
     * @return
     */
    public void cadastrarHorario(String email, String horario, String dia) {
    	try {
    		this.controllerAluno.cadastrarHorario(email, horario, dia);
    	}catch (Exception e) {
    		throw new RuntimeException("Erro no cadastrar horario: " + e.getMessage());
    	}
    }
    
   /**
     * Metodo que cadastra o local de atendimento do tutor. 
     * @param email String referente ao email do tutor.
     * @param local String referente ao local da tutoria.
     * @return
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
    	try {
    		this.controllerAluno.cadastrarLocalDeAtendimento(email, local);
    	}catch (Exception e) {
    		throw new RuntimeException("Erro no cadastrar local de atendimento: " + e.getMessage());
    	}
    }
    
   /**
     * Metodo de consulta para os horarios dos tutores.
     * @param email String referente ao email do tutor.
     * @param horario String referente ao horario da tutoria.
     * @param dia String que referente ao dia da tutoria. 
     * @return
     */
    public boolean consultaHorario(String email, String horario, String dia) {
    	try {
    		return this.controllerAluno.consultaHorario(email, horario, dia);
    	} catch (Exception e) {
    		throw new RuntimeException("Erro na consulta horario: " + e.getMessage());
    	}
    	
    }
    
   /**
     * Metodo de consulta para os locais de tutoria.
     * @param email String referente ao email do tutor.
     * @param local String referente ao local da tutoria.
     * @return
     */
    public boolean consultaLocal(String email, String local) {
    	try {
    		return this.controllerAluno.consultaLocal(email, local);
    	} catch (Exception e) {
    		throw new RuntimeException("Erro na consulta local de atendimento: " + e.getMessage());
    	}
    }
    
    public void doar(String matriculaTutor, int totalCentavos) {
    	if(matriculaTutor == null || matriculaTutor.trim().equals("")) throw new IllegalArgumentException("Erro na doacao para tutor: matricula nao pode ser vazia ou nula");
    	String nivel = this.controllerAluno.pegarNivel(matriculaTutor);
    	double nota = this.controllerAluno.pegarNota(matriculaTutor);
    	double taxa_tutor;
    	switch (nivel) {
    		case "TOP":
    			taxa_tutor = 0.9 + ((nota - 4.5)/10.0);
    			break;
    		case "Tutor":
    			taxa_tutor = 0.8;
    			break;
    		case "Aprendiz":
    			taxa_tutor = 0.4 - ((3.0 - nota)/10.0);
    			break;
    		default:
    			throw new IllegalArgumentException("");
    	}
    	int calculo = (int)(1 - taxa_tutor) * totalCentavos;
    	this.dinheiroSistema += calculo;
    	try {
    		this.controllerAluno.doar(matriculaTutor, totalCentavos - calculo);
    	} catch (Exception e) {
    		throw new RuntimeException("Erro na doacao para tutor: " + e.getMessage());
    	}
    }
    
    public int totalDinheiroTutor(String emailTutor) {
    	return this.controllerAluno.totalDinheiroTutor(emailTutor);
    }
    
    public int totalDinheiroSistema() {
    	return this.dinheiroSistema;
    }

	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return controllerAjuda.pedirAjudaPresencial(matrAluno, disciplina, this.controllerAluno.melhorTutor(disciplina, horario, dia, localInteresse), horario, dia, localInteresse);
	}

	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return controllerAjuda.pedirAjudaOnline(matrAluno, disciplina, this.controllerAluno.melhorTutor(disciplina));
	}

	public String pegarTutor(int idAjuda) {
		return controllerAjuda.pegarTutor(idAjuda);
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return controllerAjuda.getInfoAjuda(idAjuda, atributo);
	}
	
	public void configurarOrdem(String atributo) {
		this.controllerAluno.configurarOrdem(atributo);
	}
	
	public String pegarNivel(String matricula) {
		return this.controllerAluno.pegarNivel(matricula);
	}
	
	public String pegarNota(String matricula) {
		double nota = this.controllerAluno.pegarNota(matricula);
		String resultado = String.format("%.2f", nota);
		resultado.replaceAll(".", ",");
		return resultado;
	}

	public void avaliarTutor(int idAjuda, int avaliacaoRecebida) {
		this.controllerAjuda.avaliarTutor(idAjuda, avaliacaoRecebida);
	}


}

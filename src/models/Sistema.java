package models;

/**
 * Representa um Sistema de tutorias, onde alunos podem encontrar tutores que ensinam 
 * certas disciplinas, e tambem podem se tornar tutores de algumas disciplinas.
 * @author Douglas Lima
 *
 */
public class Sistema {

	private ControllerAluno controllerAluno;
	private ControllerDisponibilidade controllerDisponibilidade;
	
	/**
	 * Constroi o Sistema, inicializando os seu dois atributos que sao controllers.
	 */
	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerDisponibilidade = new ControllerDisponibilidade(); 
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
    	this.controllerAluno.cadastraAluno(String nome, String matricula, int codigoCurso, String telefone, String email);
    }
    
    /**
     * Metodo retorna a representacao textual do aluno, cuja matrícula sera passada 
     * como parametro.
     * @param matricula String referente a matricula do Aluno a ser exibido.
     * @return String de representacao textual do Aluno.
     */
    public String recuperaAluno(String matricula) {
    	return this.controllerAluno.recuperaAluno(String matricula);
    }
    
    /**
     * Metodo retorna uma lista contendo a representacao de todos os Alunos matriculados, 
     * ordenados a partir do nome.
     * @return String que e juncao da representacao textual dos Alunos.
     */
    public String listarAlunos() {
    	return this.controllerAluno.listarAlunos();
    }
    
    /**
     * Metodo que pega as informacoes dos alunos atraves da matricula e atributo.
     * @param matricula String referente a matricula do Aluno.
     * @param atributo 
     * @return 
     */
    public String getInfoAluno(String matricula, String atributo) {
    	return this.controllerAluno.getInfoAluno(String matricula, String atributo);
    }
    
   /**
     * Metodo que transforma o Aluno em tutor atraves da matricula, disciplina e proficiencia.
     * @param matricula String referente a matricula do Aluno.
     * @param disciplina String referente a disciplina que sera dada a tutoria.
     * @param proficiencia int referente a proficiencia do tutor.
     * @return 
     */
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
    	this.controllerAluno.tornarTutor(String matricula, String disciplina, int proficiencia);
    }
    
   /**
     * Metodo que recupera o Tutor atraves da matricula. 
     * @param matricula referente a matricula do Tutor.
     * @return
     */
    public String recuperaTutor(String matricula) {
    	return this.controllerAluno.recuperaTutor(String matricula);
    }
    
   /**
     * Metodo que lista os tutores.
     * @return lista de tutores.
     */
    public String listarTutores() {
    	return this.listarTutores();
    }
    
   /**
     * Metodo que cadastra os horarios dos tutores.
     * @param email String referente ao email do tutor.
     * @param horario String referente ao horario da tutoria.
     * @param dia String que referente ao dia da tutoria. 
     * @return
     */
    public void cadastrarHorario(String email, String horario, String dia) {
    	this.controllerDisponibilidade.cadastrarHorario(String email, String horario, String dia);
    }
    
   /**
     * Metodo que cadastra o local de atendimento do tutor. 
     * @param email String referente ao email do tutor.
     * @param local String referente ao local da tutoria.
     * @return
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
    	this.controllerDisponibilidade.cadastrarLocalDeAtendimento(String email, String local);
    }
    
   /**
     * Metodo de consulta para os horarios dos tutores.
     * @param email String referente ao email do tutor.
     * @param horario String referente ao horario da tutoria.
     * @param dia String que referente ao dia da tutoria. 
     * @return
     */
    public boolean consultaHorario(String email, String horario, String dia) {
    	return this.controllerDisponibilidade.consultaHorario(String email, String horario, String dia);
    }
    
   /**
     * Metodo de consulta para os locais de tutoria.
     * @param email String referente ao email do tutor.
     * @param local String referente ao local da tutoria. 
     * @return
     */
    public boolean consultaLocal(String email, String local) {
    	return this.controllerDisponibilidade.consultaLocal(String email, String local);
    }
}

package models;

/**
 * Representa um Sistema de tutorias, onde alunos podem encontrar tutores que ensinam 
 * certas disciplinas, e também podem se tornar tutores de algumas disciplinas.
 * @author Douglas Lima
 *
 */
public class Sistema {

	private ControllerAluno controllerAluno;
	private ControllerDisponibilidade controllerDisponibilidade;
	
	/**
	 * Constrói o Sistema, inicializando os seu dois atributos que são controllers.
	 */
	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerDisponibilidade = new ControllerDisponibilidade(); 
	}
	
	/**
	 * Método que cadastra um aluno sistema, a partir dos paramêtros nome, matricula,
	 * codigoCurso, telefone e email.
	 * @param nome String que é o nome do Aluno.
	 * @param matricula String que é a matricula do Aluno. 
	 * @param codigoCurso int que é o código do curso o qual o Aluno está sendo 
	 * matriculado.
	 * @param telefone String que é o número de telefone do Aluno.
	 * @param email String que é o email do Aluno.
	 */
    public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
    	this.controllerAluno.cadastraAluno(String nome, String matricula, int codigoCurso, String telefone, String email);
    }
    
    /**
     * Método retorna a representação textual do aluno, cuja matrícula será passada 
     * como paramêtro.
     * @param matricula String que é matricula do Aluno a ser exibido.
     * @return String que é a representação textual do Aluno.
     */
    public String recuperaAluno(String matricula) {
    	return this.controllerAluno.recuperaAluno(String matricula);
    }
    
    /**
     * Método retorna uma lista contendo a representação de todos os Alunos matriculados, 
     * ordenados a partir do nome.
     * @return String que é junção da representação textual dos Alunos.
     */
    public String listarAlunos() {
    	return this.controllerAluno.listarAlunos();
    }
    
    /**
     * Método 
     * @param matricula
     * @param atributo
     * @return
     */
    public String getInfoAluno(String matricula, String atributo) {
    	return this.controllerAluno.getInfoAluno(String matricula, String atributo);
    }
    
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
    	this.controllerAluno.tornarTutor(String matricula, String disciplina, int proficiencia);
    }
    
    public String recuperaTutor(String matricula) {
    	return this.controllerAluno.recuperaTutor(String matricula);
    }
    
    public String listarTutores() {
    	return this.listarTutores();
    }
    
    public void cadastrarHorario(String email, String horario, String dia) {
    	this.controllerDisponibilidade.cadastrarHorario(String email, String horario, String dia);
    }
    
    public void cadastrarLocalDeAtendimento(String email, String local) {
    	this.controllerDisponibilidade.cadastrarLocalDeAtendimento(String email, String local);
    }
    
    public boolean consultaHorario(String email, String horario, String dia) {
    	return this.controllerDisponibilidade.consultaHorario(String email, String horario, String dia);
    }
    
    public boolean consultaLocal(String email, String local) {
    	return this.controllerDisponibilidade.consultaLocal(String email, String local);
    }
}

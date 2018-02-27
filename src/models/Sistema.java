package models;

public class Sistema {

	private ControllerAluno controllerAluno;
	private ControllerDisponibilidade controllerDisponibilidade;
	
	public Sistema() {
		this.controllerAluno = new ControllerAluno();
		this.controllerDisponibilidade = new ControllerDisponibilidade(); 
	}
	
    public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
    	this.controllerAluno.cadastraAluno(String nome, String matricula, int codigoCurso, String telefone, String email);
    }
    
    public String recuperaAluno(String matricula) {
    	return this.controllerAluno.recuperaAluno(String matricula);
    }
    
    public String listarAlunos() {
    	return this.controllerAluno.listarAlunos();
    }
    
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

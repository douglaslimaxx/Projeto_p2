package main;

public class Facade {

	private Sistema sistema = new Sistema();
	
	/**
	 * @param nome
	 * @param matricula
	 * @param codigoCurso
	 * @param telefone
	 * @param email
	 * @see main.Sistema#cadastrarAluno(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * @param matricula
	 * @return
	 * @see main.Sistema#recuperaAluno(java.lang.String)
	 */
	public String recuperaAluno(String matricula) {
		return sistema.recuperaAluno(matricula);
	}

	/**
	 * @return
	 * @see main.Sistema#listarAlunos()
	 */
	public String listarAlunos() {
		return sistema.listarAlunos();
	}

	/**
	 * @param matricula
	 * @param atributo
	 * @return
	 * @see main.Sistema#getInfoAluno(java.lang.String, java.lang.String)
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return sistema.getInfoAluno(matricula, atributo);
	}

	/**
	 * @param matricula
	 * @param disciplina
	 * @param proficiencia
	 * @see main.Sistema#tornarTutor(java.lang.String, java.lang.String, int)
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		sistema.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * @param matricula
	 * @return
	 * @see main.Sistema#recuperaTutor(java.lang.String)
	 */
	public String recuperaTutor(String matricula) {
		return sistema.recuperaTutor(matricula);
	}

	/**
	 * @return
	 * @see main.Sistema#listarTutores()
	 */
	public String listarTutores() {
		return sistema.listarTutores();
	}

	/**
	 * @param email
	 * @param horario
	 * @param dia
	 * @see main.Sistema#cadastrarHorario(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		sistema.cadastrarHorario(email, horario, dia);
	}

	/**
	 * @param email
	 * @param local
	 * @see main.Sistema#cadastrarLocalDeAtendimento(java.lang.String, java.lang.String)
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		sistema.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * @param email
	 * @param horario
	 * @param dia
	 * @return
	 * @see main.Sistema#consultaHorario(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		return sistema.consultaHorario(email, horario, dia);
	}

	/**
	 * @param email
	 * @param local
	 * @return
	 * @see main.Sistema#consultaLocal(java.lang.String, java.lang.String)
	 */
	public boolean consultaLocal(String email, String local) {
		return sistema.consultaLocal(email, local);
	}

	/**
	 * @param matriculaTutor
	 * @param totalCentavos
	 * @see main.Sistema#doar(java.lang.String, int)
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		sistema.doar(matriculaTutor, totalCentavos);
	}

	/**
	 * @param emailTutor
	 * @return
	 * @see main.Sistema#totalDinheiroTutor(java.lang.String)
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return sistema.totalDinheiroTutor(emailTutor);
	}

	/**
	 * @return
	 * @see main.Sistema#totalDinheiroSistema()
	 */
	public int totalDinheiroSistema() {
		return sistema.totalDinheiroSistema();
	}

	/**
	 * @param matrAluno
	 * @param disciplina
	 * @param horario
	 * @param dia
	 * @param localInteresse
	 * @return
	 * @see main.Sistema#pedirAjudaPresencial(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * @param matrAluno
	 * @param disciplina
	 * @return
	 * @see main.Sistema#pedirAjudaOnline(java.lang.String, java.lang.String)
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return sistema.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * @param idAjuda
	 * @return
	 * @see main.Sistema#pegarTutor(int)
	 */
	public String pegarTutor(int idAjuda) {
		return sistema.pegarTutor(idAjuda);
	}

	/**
	 * @param idAjuda
	 * @param atributo
	 * @return
	 * @see main.Sistema#getInfoAjuda(int, java.lang.String)
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return sistema.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * @param matricula
	 * @return
	 * @see main.Sistema#pegarNivel(java.lang.String)
	 */
	public String pegarNivel(String matricula) {
		return sistema.pegarNivel(matricula);
	}

	/**
	 * @param matricula
	 * @return
	 * @see main.Sistema#pegarNota(java.lang.String)
	 */
	public String pegarNota(String matricula) {
		return sistema.pegarNota(matricula);
	}
	
	
	
}

package models;

/**
 * Cria classe AjudaPresencial que, atraves de horario, dia e local cadastra pedidos de ajudas presenciais. 
 * @author Douglas Lima
 *
 */
public class AjudaPresencial extends AjudaOnline{

	private String horario;
	private String dia;
	private String local;
	
	/**
	 * Metodo que cadrasta o pedido de ajuda presencial dos alunos a partir dos parametros 
	 * aluno, disciplina, tutor, horario, dia e localInteresse.
	 * 
	 * @param aluno String que representa o aluno que pediu ajuda.
	 * @param disciplina String que representa a disciplina.
	 * @param tutor String que representa o tutor.
	 * @param horario String que representa o horario.
	 * @param dia String que representa o dia.
	 * @param localInteresse String que representa o lugar de interesse.
	 */	
	public AjudaPresencial(String aluno, String disciplina, Aluno tutor, String horario, String dia, String localInteresse) {
		super(aluno, disciplina, tutor);
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
		if (localInteresse == null) {
			throw new NullPointerException("local de interesse nao pode ser vazio ou em branco");
		} 
		if (localInteresse.trim().equals("")) {
			throw new IllegalArgumentException("local de interesse nao pode ser vazio ou em branco");
		}
		this.horario = horario;
		this.dia = dia;
		this.local = localInteresse;
	}
	
	
	/**
	 * Metodo que retorna o horario requisitado para a ajuda presencial.
	 * @return String.
	 */
	public String getHorario() {
		return this.horario;
	}

	/**
	 * Metodo que retorna o dia requisitado para a ajuda presencial.
	 * @return String.
	 */
	public String getDia() {
		return this.dia;
	}

	/**
	 * Metodo que retorna o local requisitado para a ajuda presencial.
	 * @return String.
	 */
	public String getLocal() {
		return this.local;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.getTutor().getMatricula() + ", horario - " + this.horario + ", dia - " + this.dia + ", local - " + this.local + ", disciplina - " + this.getDisciplina();
	}
		
}

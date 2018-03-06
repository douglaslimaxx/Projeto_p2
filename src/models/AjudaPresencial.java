package models;

public class AjudaPresencial extends AjudaOnline{

	private String horario;
	private String dia;
	private String local;
	
	public AjudaPresencial(String aluno, String disciplina, String tutor, String horario, String dia, String localInteresse) {
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
			throw new NullPointerException("local de interesse  nao pode ser vazio ou em branco");
		} 
		if (localInteresse.trim().equals("")) {
			throw new IllegalArgumentException("local de interesse nao pode ser vazio ou em branco");
		}
		this.horario = horario;
		this.dia = dia;
		this.setLocal(local);
	}

	public String getHorario() {
		return this.horario;
	}

	public String getDia() {
		return this.dia;
	}

	public String getLocal() {
		return this.local;
	}

	private void setLocal(String local) {
		this.local = local;
	}
		
}

package models;

public class AjudaPresencial extends AjudaOnline{

	private String horario;
	private String dia;
	private String local;
	
	public AjudaPresencial(String aluno, String disciplina, String tutor, String horario, String dia, String localInteresse) {
		super(aluno, disciplina, tutor);
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

package main;


/**
 * Cria classe AjudaPresencial que, atraves de horario, dia e local cadastra pedidos de ajudas presenciais. 
 * @author Douglas Lima
 *
 */
public class AjudaPresencial extends Ajuda{

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
	public String getInfoAjuda(String atributo) {
		if (atributo == null || atributo.trim().equals("")) {
    		throw new IllegalArgumentException("atributo nao pode ser vazio ou em branco");
    	}
    	if (!(atributo.equals("tutor") || atributo.equals("disciplina") || atributo.equals("aluno") || atributo.equals("dia") || atributo.equals("horario") || atributo.equals("localInteresse"))) {
    		throw new IllegalArgumentException("atributo nao encontrado");
    	}
		switch (atributo) {
		case "tutor":
			return this.getTutor().toString();
		case "disciplina":
			return this.getDisciplina();
		case "aluno":
			return this.getMatriculaAluno();
		case "horario":
			return this.getHorario();
		case "dia":
			return this.getDia();
		case "localInteresse":
			return this.getLocal();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.getTutor().getMatricula() + ", horario - " + this.horario + ", dia - " + this.dia + ", local - " + this.local + ", disciplina - " + this.getDisciplina();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AjudaPresencial other = (AjudaPresencial) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}
}

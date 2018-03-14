package main;


/**
 * Cria uma classe AjudaOnline que, atraves da disciplina, matriculaAluno e matriculaTutor, cadastra
 * pedidos de ajudas online.
 * @author Douglas Lima 
 *
 */

public class AjudaOnline extends Ajuda {

	private String matriculaAluno;
	private String disciplina;
	private Aluno tutor;
	
	public AjudaOnline(String aluno, String disciplina, Aluno tutor2) {
		super(aluno, disciplina, tutor2);
	}
	
	@Override
	public String getInfoAjuda(String atributo) {
		if (atributo == null || atributo.trim().equals("")) {
    		throw new IllegalArgumentException("atributo nao pode ser vazio ou em branco");
    	}
    	if (!(atributo.equals("tutor") || atributo.equals("disciplina") || atributo.equals("aluno"))) {
    		throw new IllegalArgumentException("atributo nao encontrado");
    	}
		switch (atributo) {
		case "tutor":
			return this.getTutor().toString();
		case "disciplina":
			return this.getDisciplina();
		case "aluno":
			return this.getMatriculaAluno();
		} 
		return null;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.tutor.getMatricula() + ", disciplina - " + this.disciplina;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((matriculaAluno == null) ? 0 : matriculaAluno.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AjudaOnline other = (AjudaOnline) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (matriculaAluno == null) {
			if (other.matriculaAluno != null)
				return false;
		} else if (!matriculaAluno.equals(other.matriculaAluno))
			return false;
		if (tutor == null) {
			if (other.tutor != null)
				return false;
		} else if (!tutor.equals(other.tutor))
			return false;
		return true;
	}	
}

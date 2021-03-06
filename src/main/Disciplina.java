package main;

import java.io.Serializable;

/**
 * Cria uma classe Disciplina //TODO
 * @author 
 *
 */

public class Disciplina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	private String disciplina;
	private int proficiencia;
	
	public Disciplina(String disciplina, int proficiencia) {
		if(disciplina == null) throw new NullPointerException("Disciplina nao pode ser vazia ou nula");
		if (disciplina.trim().equals("")) throw new IllegalArgumentException("Disciplina nao pode ser vazia ou nula");
		if ((proficiencia <= 0) || (proficiencia > 5)) throw new IllegalArgumentException("Proficiencia invalida");
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
	}
	
	/**
	 * Metodo que retorna a proficiencia do tutor naquela disciplina.
	 * @return int.
	 */
	public int getProficiencia() {
		return this.proficiencia;
	}
	
	public void setProficiencia(int proficiencia) {
		if ((proficiencia <= 0) || (proficiencia > 5)) throw new IllegalArgumentException("Proficiencia invalida");
		this.proficiencia = proficiencia;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + proficiencia;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (proficiencia != other.proficiencia)
			return false;
		return true;
	}

}

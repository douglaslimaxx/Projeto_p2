package models;

/**
 * Representa uma tutoria, que terá uma disciplina sobre a qual a tutoria acontecerá e 
 * a proficiência que o tutor tem nessa determinada disciplina.
 * @author Douglas Lima
 *
 */
public class Tutoria {

	private String disciplina;
	private int proficiencia;
	private int avaliacao;
	private int quantia;
	
	/**
	 * Método que constrói um objeto do tipo Tutoria a partir dos paramêtros 
	 * disciplina e proficiência.
	 * @param disciplina String que é o nome da disciplina da tutoria.
	 * @param proficiencia int que é a proficiência do tutor nessa disciplina.
	 */
	public Tutoria(String disciplina, int proficiencia) {
		if (disciplina == null) {
			throw new NullPointerException();
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (proficiencia <= 0) {
			throw new ArithmeticException("Erro na definicao de papel: Proficiencia invalida");
		}
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.avaliacao = 4;
		this.quantia = 0;
	}

	/**
	 * Método retorna o nome da disciplina da tutoria.
	 * @return String que é o nome da disciplina da tutoria.
	 */
	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		this.proficiencia = proficiencia;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public int getQuantia() {
		return quantia;
	}

	public void setQuantia(int quantia) {
		this.quantia = quantia;
	}
	
	
	
	
}

package models;

/**
 * Representa uma tutoria, que terá uma disciplina sobre a qual a tutoria
 * acontecerá e a proficiência que o tutor tem nessa determinada disciplina.
 * 
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
	 * 
	 * @param disciplina
	 *            String que é o nome da disciplina da tutoria.
	 * @param proficiencia
	 *            int que é a proficiência do tutor nessa disciplina.
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
	 * 
	 * @return String que é o nome da disciplina da tutoria.
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Método retorna um inteiro que representa a proficiência do tutor na
	 * disciplina.
	 * 
	 * @return int que é a proficiência do tutor na disciplina.
	 */
	public int getProficiencia() {
		return proficiencia;
	}

	/**
	 * Método que retorna a avaliação da tutoria da disciplina.
	 * 
	 * @return int que é a avaliação da tutoria.
	 */
	public int getAvaliacao() {
		return avaliacao;
	}

	/**
	 * Método que modifica o valor atribuído ao atributo Avaliação a partir de um
	 * paramêtro.
	 * 
	 * @param avaliacao
	 *            int que é o valor a ser atribuído ao atributo Avaliação.
	 */
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * Método retorna o valor recebido pelo sistema pela tutoria.
	 * 
	 * @return int que é o valor recebido pelo sistema.
	 */
	public int getQuantia() {
		return quantia;
	}

	/**
	 * Método que modifica o valor atribuído ao atributo quantia a partir de um
	 * paramêtro.
	 * 
	 * @param avaliacao
	 *            int que é o valor a ser atribuído ao atributo Quantia.
	 */
	public void setQuantia(int quantia) {
		this.quantia = quantia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avaliacao;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + proficiencia;
		result = prime * result + quantia;
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
		Tutoria other = (Tutoria) obj;
		if (avaliacao != other.avaliacao)
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (proficiencia != other.proficiencia)
			return false;
		if (quantia != other.quantia)
			return false;
		return true;
	}
}

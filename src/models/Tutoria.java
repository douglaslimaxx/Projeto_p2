package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma tutoria, que tera uma disciplina sobre a qual a tutoria
 * acontecera e a proficiencia que o tutor tem nessa determinada disciplina.
 * 
 * @author Douglas Lima
 *
 */
public class Tutoria {

	private int dinheiroTutor;
	private int avaliacao;
	private int quantia;
	private Map<String, Disciplina> disciplinas;
	private Disponibilidade disponibilidade;

	/**
	 * Metodo que constroi um objeto do tipo Tutoria a partir dos parametros
	 * disciplina e proficiencia.
	 * 
	 * @param disciplina
	 *            String referente ao nome da disciplina da tutoria.
	 * @param proficiencia
	 *            int referente a proficiencia do tutor nessa disciplina.
	 */
	public Tutoria() {
		this.avaliacao = 4;
		this.quantia = 0;
		this.disciplinas = new HashMap<>();
	}

	/**
	 * Metodo adiciona um objeto do tipo Disciplina no map de disciplinas, a partir
	 * dos parametros disciplina e proficiencia.
	 * 
	 * @param disciplina
	 *            String que e o nome da disciplina.
	 * @param proficiencia
	 *            que e a proficiencia do tutor na disciplina.
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		if (this.disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException("Ja eh tutor dessa disciplina");
		}
		this.disciplinas.put(disciplina, new Disciplina(disciplina, proficiencia));
	}

	/**
	 * Metodo retorna o nome da disciplina da tutoria.
	 *
	 * @return String referente ao nome da disciplina da tutoria.
	 */
	public Disciplina getDisciplina(String disciplina) {
		return this.disciplinas.get(disciplina);
	}

	/**
	 * Metodo retorna um inteiro que representa a proficiencia do tutor na
	 * disciplina.
	 * 
	 * @return int referente a proficiencia do tutor na disciplina.
	 */
	public int getProficiencia(String disciplina) {
		if (disciplina == null) {
			throw new NullPointerException("Disciplina nao pode ser vazia ou nula");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Disciplina nao pode ser vazia ou nula");
		}
		
		return this.disciplinas.get(disciplina).getProficiencia();
	}

	public void setProficiencia(String disciplina, int proficiencia) {
		if (disciplina == null) {
			throw new NullPointerException("Disciplina nao pode ser vazia ou nula");
		}
		if (disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Disciplina nao pode ser vazia ou nula");
		}
		this.disciplinas.get(disciplina).setProficiencia(proficiencia);
	}

	/**
	 * Metodo que retorna a avaliacao da tutoria da disciplina.
	 * 
	 * @return int referente a avaliação da tutoria.
	 */
	public int getAvaliacao() {
		return avaliacao;
	}

	/**
	 * Metodo que modifica o valor atribuído ao atributo Avaliacao a partir de um
	 * parametro.
	 * 
	 * @param avaliacao
	 *            int que e o valor a ser atribuído ao atributo Avaliacao.
	 */
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	/**
	 * Metodo retorna o valor recebido pelo sistema pela tutoria.
	 * 
	 * @return int referente ao valor recebido pelo sistema.
	 */
	public int getQuantia() {
		return quantia;
	}

	/**
	 * Método que modifica o valor atribuido ao atributo quantia a partir de um
	 * parametro.
	 * 
	 * @param avaliacao
	 *            int referente ao valor a ser atribuído ao atributo Quantia.
	 */
	public void setQuantia(int quantia) {
		this.quantia = quantia;
	}

	/**
	 * Consulta a disponibilidade de um horario a partir do horario e dia passados.
	 * 
	 * @param horario
	 *            String do horario a ser consultado.
	 * @param dia
	 *            String do dia a ser consultado.
	 * @return true caso o horário consultado esteja disponível e false caso não.
	 */
	public boolean consultaHorario(String horario, String dia) {
		return disponibilidade.consultaHorario(horario, dia);
	}

	/**
	 * Consulta a disponibilidade de um local para atendimento a partir do parametro
	 * de local passado.
	 * 
	 * @param local
	 *            String do local a ser consultado.
	 * @return true caso o local esteja disponível para atendimento e false caso
	 *         nao.
	 */
	public boolean consultaLocal(String local) {
		return disponibilidade.consultaLocal(local);
	}

	/**
	 * Cadastra um horario disponivel do tutor a partir do dia disponivel passado e
	 * tambem do horario recebido como parametro, associando um ao outro.
	 * 
	 * @param horario
	 *            String do horario a ser cadastrado.
	 * @param dia
	 *            String do dia a ser cadastrado.
	 */
	public void cadastrarHorario(String horario, String dia) {
		disponibilidade.cadastrarHorario(horario, dia);
	}

	/**
	 * Cadastra um local de atendimento a partir do local disponivel passado.
	 * 
	 * @param local
	 *            String do local a ser cadastrado
	 */
	public void cadastrarLocalDeAtendimento(String local) {
		disponibilidade.cadastrarLocalDeAtendimento(local);
	}

	public boolean isTutor() {
		return !this.disciplinas.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avaliacao;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
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
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (quantia != other.quantia)
			return false;
		return true;
	}

	public int totalDinheiroTutor() {
		return this.dinheiroTutor;
	}

	public void doar(int valor) {
		this.dinheiroTutor += valor;
	}

}

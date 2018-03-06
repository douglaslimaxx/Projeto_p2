package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Representa a disponibilidade de um tutor em relaçao a seus horarios e
 * locais de atendimento aos alunos.
 * 
 * @author Marcella Medeiros Siqueira Coutinho de Almeida
 *
 */

public class Disponibilidade {
	
	private Set<String> locaisDisponiveis = new HashSet<>();
	private Map<String, HashSet<String>> horariosDisponiveis = new HashMap<>();
	
/**
 * Constroi a disponibilidade do tutor a partir de seu email.
 * @param email String de email passado pelo tutor.
 */
	public Disponibilidade() {
		this.locaisDisponiveis = new HashSet<>();
		this.horariosDisponiveis = new HashMap<>();
		horariosDisponiveis.put("seg", new HashSet<String>());
		horariosDisponiveis.put("ter", new HashSet<String>());
		horariosDisponiveis.put("qua", new HashSet<String>());
		horariosDisponiveis.put("qui", new HashSet<String>());
		horariosDisponiveis.put("sex", new HashSet<String>());
	}
	
/**
 * Cadastra um horario disponivel do tutor a partir do dia disponivel passado
 * e tambem do horario recebido como parametro, associando um ao outro.
 * 
 * @param horario String do horario a ser cadastrado.
 * @param dia String do dia a ser cadastrado.
 */
	public void cadastrarHorario(String horario, String dia) {
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
		horariosDisponiveis.get(dia).add(horario);
	}

/**
 * Cadastra um local de atendimento a partir do local disponivel passado.
 * @param local String do local a ser cadastrado
 */
	public void cadastrarLocalDeAtendimento(String local) {
		if (local == null) {
			throw new NullPointerException("local nao pode ser vazio ou em branco");
		}
		if (local.trim().equals("")) {
			throw new IllegalArgumentException("local nao pode ser vazio ou em branco");
		}
		locaisDisponiveis.add(local);
	}
	
/**
 * Consulta a disponibilidade de um horario a partir do horario e dia passados.
 * @param horario String do horario a ser consultado.
 * @param dia String do dia a ser consultado.
 * @return true caso o horário consultado esteja disponível e false caso não.
 */
	public boolean consultaHorario(String horario, String dia) {
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
		boolean consulta = false;
		if (horariosDisponiveis.containsKey(dia)) {
			if (horariosDisponiveis.get(dia).contains(horario)) {
				consulta = true;;
			}
		}
		return consulta;
	}
	
/**
 * Consulta a disponibilidade de um local para atendimento a partir do parametro
 * de local passado.
 * @param local String do local a ser consultado.
 * @return true caso o local esteja disponível para atendimento e false caso nao.
 */
	public boolean consultaLocal(String local) {
		if (local == null) {
			throw new NullPointerException("local nao pode ser vazio ou em branco");
		}
		if (local.trim().equals("")) {
			throw new IllegalArgumentException("local nao pode ser vazio ou em branco");
		}
		return locaisDisponiveis.contains(local);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((horariosDisponiveis == null) ? 0 : horariosDisponiveis.hashCode());
		result = prime * result + ((locaisDisponiveis == null) ? 0 : locaisDisponiveis.hashCode());
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
		Disponibilidade other = (Disponibilidade) obj;
		if (horariosDisponiveis == null) {
			if (other.horariosDisponiveis != null)
				return false;
		} else if (!horariosDisponiveis.equals(other.horariosDisponiveis))
			return false;
		if (locaisDisponiveis == null) {
			if (other.locaisDisponiveis != null)
				return false;
		} else if (!locaisDisponiveis.equals(other.locaisDisponiveis))
			return false;
		return true;
	}
	
}

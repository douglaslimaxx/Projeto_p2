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
	private String email;
	
/**
 * Constroi a disponibilidade do tutor a partir de seu email.
 * @param email String de email passado pelo tutor.
 */
	public Disponibilidade(String email) {
		if (email.equals(null)) {
			throw new NullPointerException("Erro na definicao de papel: email nao pode ser vazio ou nulo");
		}
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro na definicao de papel: email nao pode ser vazio ou nulo");
		}
		this.email = email;
		this.locaisDisponiveis = new HashSet<>();
		this.horariosDisponiveis = new HashMap<>();
	}
	
/**
 * Cadastra um horario disponivel do tutor a partir do dia disponivel passado
 * e tambem do horario recebido como parametro, associando um ao outro.
 * 
 * @param horario String do horario a ser cadastrado.
 * @param dia String do dia a ser cadastrado.
 */
	public void cadastrarHorario(String horario, String dia) {
		if (horario.equals(null)) {
			throw new NullPointerException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
		horariosDisponiveis.get(dia).add(horario);
	}

/**
 * Cadastra um local de atendimento a partir do local disponivel passado.
 * @param local String do local a ser cadastrado
 */
	public void cadastrarLocalDeAtendimento(String local) {
		locaisDisponiveis.add(local);
	}
	
/**
 * Consulta a disponibilidade de um horario a partir do horario e dia passados.
 * @param horario String do horario a ser consultado.
 * @param dia String do dia a ser consultado.
 * @return true caso o horário consultado esteja disponível e false caso não.
 */
	public boolean consultaHorario(String horario, String dia) {
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
		return locaisDisponiveis.contains(local);
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
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
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
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

package models;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Representa a disponibilidade de um tutor em relação a seus horários e
 * locais de atendimento aos alunos.
 * 
 * @author Marcella Medeiros Siqueira Coutinho de Almeida
 *
 */

public class Disponibilidade {
	
	private HashSet<String> locaisDisponiveis = new HashSet<>();
	private HashMap<String, String> horariosDisponiveis = new HashMap<>();
	private String email;
	
/**
 * Constrói 	a disponibilidade do tutor a partir de seu email.
 * @param email String de email passado pelo tutor
 */
	public Disponibilidade(String email) {
		this.email = email;
		this.locaisDisponiveis = new HashSet<>();
		this.horariosDisponiveis = new HashMap<>();
	}
	
/**
 * Cadastra um horário disponível do tutor a partir do dia disponível passado
 * e também do horário recebido como parâmetro, associando um ao outro.
 * 
 * @param horario String do horário a ser cadastrado
 * @param dia String do dia a ser cadastrado 
 */
	public void cadastrarHorario(String horario, String dia) {
		horariosDisponiveis.put(dia, horario);
	}

/**
 * Cadastra um local de atendimento a partir do local disponível passado.
 * @param local String do local a ser cadastrado
 */
	public void cadastrarLocalDeAtendimento(String local) {
		locaisDisponiveis.add(local);
	}
	
/**
 * Consulta a disponibilidade de um horário a partir do horário e dia passados.
 * @param horario String do horário a ser consultado
 * @param dia String do dia a ser consultado
 * @return true caso o horário consultado esteja disponível e false caso não
 */
	public boolean consultaHorario(String horario, String dia) {
		boolean consulta = false;
		if (horariosDisponiveis.containsKey(horario)) {
			if (horariosDisponiveis.containsValue(horario)) {
				consulta = true;
			}
		}
		return consulta;
	}
	
/**
 * Consulta a disponibilidade de um local para atendimento a partir do parâmetro
 * de local passado.
 * @param local String do local a ser consultado
 * @return true caso o local esteja disponível para atendimento e false caso não
 */
	public boolean consultaLocal(String local) {
		return locaisDisponiveis.contains(local);
	}
	
	

}

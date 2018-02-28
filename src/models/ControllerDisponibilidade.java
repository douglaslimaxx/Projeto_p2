package models;

/**
 * 
 * 
 * @author Gabriel Felipe Cardoso Gomes - 117110681
 */
import java.util.HashMap;

public class ControllerDisponibilidade {

	private HashMap< String, Disponibilidade > disponibilidades;
	
	public ControllerDisponibilidade() {
		disponibilidades = new HashMap< String, Disponibilidade >();
	}
	
	private void createEmail(String email) {
		if(!disponibilidades.containsKey(email))disponibilidades.put(email, new Disponibilidade(email));
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		createEmail(email);
		disponibilidades.get(email).cadastrarHorario(horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		createEmail(email);
		disponibilidades.get(email).cadastrarLocalDeAtendimento(local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return disponibilidades.get(email).consultaHorario(horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return disponibilidades.get(email).consultaLocal(local);
	}
	
}

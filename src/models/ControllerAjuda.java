package models;

import java.util.HashMap;
import java.util.Map;

public class ControllerAjuda {

	private Map<Integer, AjudaOnline> ajudasOnline = new HashMap<>();
	private Map<Integer, AjudaPresencial> ajudasPresencial = new HashMap<>();
	
    public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
    	this.ajudasPresencial.put(this.ajudasPresencial.size(), new AjudaPresencial(matrAluno, disciplina, null, horario, dia, localInteresse));
    	return this.ajudasPresencial.size() - 1;
    }
    
    public int pedirAjudaOnline (String matrAluno, String disciplina) {
    	this.ajudasOnline.put(this.ajudasOnline.size(), new AjudaOnline(matrAluno, disciplina, null));
    	return this.ajudasOnline.size() - 1;
    }
    
    public String pegarTutor(int idAjuda) {
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		return this.ajudasOnline.get(idAjuda).getMatriculaTutor();
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		return this.ajudasPresencial.get(idAjuda).getMatriculaTutor();
    	}
    }
    
    public String getInfoAjuda(int idAjuda, String atributo) {
    	return "";
    }
	
}

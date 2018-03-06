package models;

import java.util.HashMap;
import java.util.Map;

public class ControllerAjuda {

	private Map<Integer, AjudaOnline> ajudasOnline = new HashMap<>();
	private Map<Integer, AjudaPresencial> ajudasPresencial = new HashMap<>();
	
    public int pedirAjudaPresencial (String matrAluno, String disciplina, String tutor, String horario, String dia, String localInteresse) {
    	this.ajudasPresencial.put(this.ajudasPresencial.size(), new AjudaPresencial(matrAluno, disciplina, tutor, horario, dia, localInteresse));
    	return this.ajudasPresencial.size() - 1;
    }
    
    public int pedirAjudaOnline (String matrAluno, String disciplina, String tutor) {
    	this.ajudasOnline.put(this.ajudasOnline.size(), new AjudaOnline(matrAluno, disciplina, tutor));
    	return this.ajudasOnline.size() - 1;
    }
    
    public String pegarTutor(int idAjuda) {
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		return this.ajudasOnline.get(idAjuda).getMatriculaTutor();
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		return this.ajudasPresencial.get(idAjuda).getMatriculaTutor();
    	} else {
    		throw new IllegalArgumentException("Erro na recuperacao de tutor de ajuda: tutor ");
    	}
    }
    
    public String getInfoAjuda(int idAjuda, String atributo) {
    	return "";
    }
	
}

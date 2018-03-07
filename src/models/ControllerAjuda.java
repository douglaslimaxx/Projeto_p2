package models;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ControllerAjuda {

	private Map<Integer, AjudaOnline> ajudasOnline = new HashMap<>();
	private Map<Integer, AjudaPresencial> ajudasPresencial = new HashMap<>();
	private int numeroAjudas = 0;
	
    public int pedirAjudaPresencial (String matrAluno, String disciplina, String tutor, String horario, String dia, String localInteresse) {
    	try{
    		this.ajudasPresencial.put(this.ajudasPresencial.size(), new AjudaPresencial(matrAluno, disciplina, tutor, horario, dia, localInteresse));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda presencial: " + e.getMessage());
    	}
    	this.numeroAjudas++;
    	return this.numeroAjudas;
    }
    
    public int pedirAjudaOnline (String matrAluno, String disciplina, String tutor) {
    	try{
    		this.ajudasOnline.put(this.ajudasOnline.size(), new AjudaOnline(matrAluno, disciplina, tutor));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda online: " + e.getMessage());
    	}
    	this.numeroAjudas++;
    	return this.numeroAjudas;
    }
    
    public String pegarTutor(int idAjuda) {
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		return this.ajudasOnline.get(idAjuda).getMatriculaTutor();
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		return this.ajudasPresencial.get(idAjuda).getMatriculaTutor();
    	} if (idAjuda < 0) {
    		throw new NoSuchElementException("Erro ao tentar recuperar tutor : id nao pode menor que zero");
    	} else {
    		throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado");
    	}
    }
	
    public String getInfoAjuda(int idAjuda, String atributo) {
    	if (!(this.ajudasOnline.containsKey(idAjuda) || this.ajudasPresencial.containsKey(idAjuda))){
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado");
    	}
    	if (idAjuda < 0) {
    		throw new NoSuchElementException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero");
    	}
    	if (atributo == null || atributo.trim().equals("")) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
    	}
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		switch (atributo) {
    		case "tutor":
    			this.ajudasOnline.get(idAjuda).getMatriculaTutor();
    		case "disciplina":
    			this.ajudasOnline.get(idAjuda).getDisciplina();
    		case "aluno":
    			this.ajudasOnline.get(idAjuda).getMatriculaAluno();
    		}   
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		switch (atributo) {
    		case "tutor":
    			this.ajudasPresencial.get(idAjuda).getMatriculaTutor();
    		case "disciplina":
    			this.ajudasPresencial.get(idAjuda).getDisciplina();
    		case "aluno":
    			this.ajudasPresencial.get(idAjuda).getMatriculaAluno();
    		case "horario":
    			this.ajudasPresencial.get(idAjuda).getHorario();
    		case "dia":
    			this.ajudasPresencial.get(idAjuda).getDia();
    		case "local":
    			this.ajudasPresencial.get(idAjuda).getLocal();
    		}
    	} 
    	throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
    }
    
    
	
}

package main;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


/**
 * 
 * @author Douglas Lima
 *
 */
public class ControllerAjuda {

	private Map<Integer, AjudaOnline> ajudasOnline = new HashMap<>();
	private Map<Integer, AjudaPresencial> ajudasPresencial = new HashMap<>();
	private int numeroAjudas = 0;
	
    public int pedirAjudaPresencial (String matrAluno, String disciplina, Aluno tutor, String horario, String dia, String localInteresse) {
    	try{
    		this.ajudasPresencial.put(this.numeroAjudas + 1, new AjudaPresencial(matrAluno, disciplina, tutor, horario, dia, localInteresse));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda presencial: " + e.getMessage());
    	}
    	this.numeroAjudas++;
    	return this.numeroAjudas;
    }
    
    public int pedirAjudaOnline (String matrAluno, String disciplina, Aluno tutor) {
    	try{
    		this.ajudasOnline.put(this.numeroAjudas + 1, new AjudaOnline(matrAluno, disciplina, tutor));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda online: " + e.getMessage());
    	}
    	this.numeroAjudas++;
    	return this.numeroAjudas;
    }
    
    public String pegarTutor(int idAjuda) {
    	 if (idAjuda <= 0) {
     		throw new NoSuchElementException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
     	} 
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		return this.ajudasOnline.get(idAjuda).toString();
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		return this.ajudasPresencial.get(idAjuda).toString();
    	} else {
     		throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
     	}
    }
	
    public String getInfoAjuda(int idAjuda, String atributo) {
    	if (idAjuda <= 0) {
    		throw new NoSuchElementException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
    	}
    	if (!(this.ajudasOnline.containsKey(idAjuda) || this.ajudasPresencial.containsKey(idAjuda))){
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
    	}
   
    	if (atributo == null || atributo.trim().equals("")) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
    	}
    	if (!(atributo.equals("tutor") || atributo.equals("disciplina") || atributo.equals("aluno") || atributo.equals("dia") || atributo.equals("horario") || atributo.equals("localInteresse"))) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
    	}
    	
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		switch (atributo) {
    		case "tutor":
    			return this.ajudasOnline.get(idAjuda).getTutor().toString();
    		case "disciplina":
    			return this.ajudasOnline.get(idAjuda).getDisciplina();
    		case "aluno":
    			return this.ajudasOnline.get(idAjuda).getMatriculaAluno();
    		}   
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		switch (atributo) {
    		case "tutor":
    			return this.ajudasPresencial.get(idAjuda).getTutor().toString();
    		case "disciplina":
    			return this.ajudasPresencial.get(idAjuda).getDisciplina();
    		case "aluno":
    			return this.ajudasPresencial.get(idAjuda).getMatriculaAluno();
    		case "horario":
    			return this.ajudasPresencial.get(idAjuda).getHorario();
    		case "dia":
    			return this.ajudasPresencial.get(idAjuda).getDia();
    		case "localInteresse":
    			return this.ajudasPresencial.get(idAjuda).getLocal();
    		}
    	}
		return null; 
    	
    }
    
    public void avaliarTutor(int idAjuda, int avalicaoRecebida) {
    	if (idAjuda <= 0) {
    		throw new NoSuchElementException("Erro ao tentar avaliar tutor : id nao pode menor que zero ");
    	} 
    	if (this.ajudasOnline.containsKey(idAjuda)) {
    		this.ajudasOnline.get(idAjuda).getTutor().avaliarTutor(avalicaoRecebida);;
    	} else if (this.ajudasPresencial.containsKey(idAjuda)) {
    		this.ajudasPresencial.get(idAjuda).getTutor().avaliarTutor(avalicaoRecebida);;
    	} else {
    		throw new IllegalArgumentException("Erro ao tentar avaliar tutor : id nao encontrado ");
    	}
    }
    
    
	
}

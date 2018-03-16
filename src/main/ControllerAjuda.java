package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * 
 * @author Douglas Lima
 *
 */
public class ControllerAjuda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private List<Ajuda> ajudas = new ArrayList<>();
	
    public int pedirAjudaPresencial (String matrAluno, String disciplina, Aluno tutor, String horario, String dia, String localInteresse) {
    	try{
    		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, tutor, horario, dia, localInteresse));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda presencial: " + e.getMessage());
    	}
    	return this.ajudas.size();
    }
    
    public int pedirAjudaOnline (String matrAluno, String disciplina, Aluno tutor) {
    	try{
    		this.ajudas.add(new AjudaOnline(matrAluno, disciplina, tutor));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda online: " + e.getMessage());
    	}
    	return this.ajudas.size();
    }
    
    public String pegarTutor(int idAjuda) {
    	 if (idAjuda <= 0) {
     		throw new NoSuchElementException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
     	} 
    	if (idAjuda > this.ajudas.size()) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
    	}
    	return this.ajudas.get(idAjuda - 1).toString();
    }
	
    public String getInfoAjuda(int idAjuda, String atributo) {
    	if (idAjuda <= 0) {
    		throw new NoSuchElementException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
    	}
    	if (idAjuda > this.ajudas.size()) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
    	}
    	try {
    		return this.ajudas.get(idAjuda - 1).getInfoAjuda(atributo);
    	} catch (Exception e) {
    		throw new RuntimeException("Erro ao tentar recuperar info da ajuda : " + e.getMessage());
    	}    	
    }
    
    public void avaliarTutor(int idAjuda, int avalicaoRecebida) {
    	if (idAjuda <= 0) {
    		throw new NoSuchElementException("Erro na avaliacao de tutor: id nao pode menor que zero ");
    	} 
    	if (avalicaoRecebida < 0) {
    		throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
    	}
		if (avalicaoRecebida > 5) {
			throw new IllegalArgumentException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
    	if (idAjuda > this.ajudas.size()) {
    		throw new IllegalArgumentException("Erro na avaliacao de tutor: id nao encontrado ");
    	}
    	this.ajudas.get(idAjuda - 1).avaliando();
    	this.ajudas.get(idAjuda - 1).getTutor().avaliarTutor(avalicaoRecebida);
    }
    
    
	
}

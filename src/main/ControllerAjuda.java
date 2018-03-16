package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Controller que e responsavel por toda a lógica que envolve as ajudas.
 * @author Douglas Lima
 *
 */
public class ControllerAjuda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private List<Ajuda> ajudas = new ArrayList<>();
	
	/**
	 * Metodo que cadastra uma Ajuda Presencial.
	 * @param matrAluno String que e a matricula do aluno que esta pedindo a ajuda.
	 * @param disciplina String que e a disciplina na qual a ajuda estaa sendo feita.
	 * @param tutor Aluno que e tutor selecionado para essa ajuda. 
	 * @param horario String que e o horario da ajuda. 
	 * @param dia String que e o dia da ajuda.
	 * @param localInteresse String que e o local de interesse da ajuda.
	 * @return int que e o numero de cadastro da ajuda.
	 */
    public int pedirAjudaPresencial (String matrAluno, String disciplina, Aluno tutor, String horario, String dia, String localInteresse) {
    	try{
    		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, tutor, horario, dia, localInteresse));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda presencial: " + e.getMessage());
    	}
    	return this.ajudas.size();
    }
    
    /**
     * Metodo que cadastra uma Ajuda Online.
	 * @param matrAluno String que e a matricula do aluno que esta pedindo a ajuda.
	 * @param disciplina String que e a disciplina na qual a ajuda estaa sendo feita.
	 * @param tutor Aluno que e tutor selecionado para essa ajuda. 
     * @return int que e o numero de cadastro da ajuda.
     */
    public int pedirAjudaOnline (String matrAluno, String disciplina, Aluno tutor) {
    	try{
    		this.ajudas.add(new AjudaOnline(matrAluno, disciplina, tutor));
    	} catch (Exception e) {
    		throw new RuntimeException("Erro no pedido de ajuda online: " + e.getMessage());
    	}
    	return this.ajudas.size();
    }
    
    /**
     * Metodo retorna uma representacao textual da ajuda, com informacoes do tutor, 
     * da disciplina e do horario, dia e local, caso a ajuda seja presencial.
     * @param idAjuda int que e o numero da ajuda
     * @return String que sao as informacoes de ajuda.
     */
    public String pegarTutor(int idAjuda) {
    	 if (idAjuda <= 0) {
     		throw new NoSuchElementException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
     	} 
    	if (idAjuda > this.ajudas.size()) {
    		throw new IllegalArgumentException("Erro ao tentar recuperar tutor : id nao encontrado ");
    	}
    	return this.ajudas.get(idAjuda - 1).toString();
    }
	
    /**
     * Metodo retorna algum atributo da ajuda. Mas qual do atributos sera retornado, 
	 * e determinado pelo parametro.
	 * @param atributo String que determina qual atributo sera retornado.
     * @param idAjuda que p numero da ajuda.
     * @return String que e um dos atributos de Ajuda.
     */
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
    
    /**
     * Metodo que avalia um tutor que deu a ajuda.
     * @param idAjuda int que e o numero de cadastro de ajuda.
     * @param avalicaoRecebida int que é a avaliacao dado pelo aluno ao tutor.
     */
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

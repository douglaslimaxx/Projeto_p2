package models;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cria uma classe aluno através de sua matrícula, nome, telefone e código de curso e email.
 * @author Marta Laís de Macedo Dantas.
 *
 */
public class Aluno {
	
	private int codigoCurso;
	private String matricula, nome, telefone, email;
	
	/**
	 * Método que constrói um objeto do tipo Aluno a partir dos paramêtros 
	 * nome, matrícula, email, telefone e código do curso.
	 * 
	 * @param nome String que representa o nome do Aluno.
	 * @param matricula String que representa a matrícula do Aluno.
	 * @param email String que representa o email do Aluno.
	 * @param telefone String que representa o telefone do Aluno.
	 * @param codigoCurso int que representa o código do curso do Aluno.
	 */

	public Aluno(String nome, String matricula, String email, String telefone, int codigoCurso) {
		entradaValida(nome);
		entradaValida(matricula);
		entradaValida(telefone);
		
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;		
		
	}
	
	/**
	 * Método que retorna se as entradas são válidas.
	 * @return void.
	 */	
	private void entradaValida(String entrada){
        if(entrada == null)throw new NullPointerException("Parâmetro null!");
        if(entrada.trim().equals("")) throw new IllegalArgumentException("Entrada vazia!");
    }
	
	/**
	 * Método que verifica se um email é válido para o sistema, ou seja, se existe um "@" e conteúdo antes e depois da mesma.
	 * @return boolean.
	 */	
	public static boolean validaEmail(String email) {
		boolean emailValido = false;
		if (email != null && email.length() > 0 ) {
			
			Pattern pattern = Pattern.compile("*@*");
			Matcher matcher = pattern.matcher(email);
			if (matcher.find()) {
				emailValido = true;				
			}
		}
		return emailValido;
	}
	
	/**
	 * Método que retorna o código do curso.
	 * @return int.
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	/**
	 * Método que retorna a matrícula.
	 * @return String.
	 */
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Método que retorna o nome.
	 * @return String.
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o telefone.
	 * @return String.
	 */
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método que retorna o email.
	 * @return String.
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	ArrayList listaTutor = new ArrayList();
	
	public void getTutor() {
		this.Tutor;
	}
	
	/**
	 * Método que retorna o formato de impressão do aluno.
	 * O telefone é opcional.
	 * @return toString de saída do Aluno.
	 */	
	@Override 
	public String toString() {
		if (telefone.equals(null) || telefone.trim().equals("")) {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
		} else {
			return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - " + this.email;
		}
	}
}

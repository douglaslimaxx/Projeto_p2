package models;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cria uma classe aluno atraves de sua matricula, nome, telefone e codigo de curso e email.
 * @author Marta Lais de Macedo Dantas.
 *
 */
public class Aluno {
	
	private int codigoCurso;
	private String matricula, nome, telefone, email;
	private Tutoria tutoria;
	
	/**
	 * Metodo que constroi um objeto do tipo Aluno a partir dos parametros 
	 * nome, matricula, email, telefone e codigo do curso.
	 * 
	 * @param nome String que representa o nome do Aluno.
	 * @param matricula String que representa a matricula do Aluno.
	 * @param email String que representa o email do Aluno.
	 * @param telefone String que representa o telefone do Aluno.
	 * @param codigoCurso int que representa o codigo do curso do Aluno.
	 */
	public Aluno(String nome, String matricula, String email, String telefone, int codigoCurso) {
		entradaValida(nome);
		entradaValida(matricula);
		entradaValida(telefone);
		
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;
		this.tutoria = new Tutoria();
		
	}
	
	/**
	 * Metodo que retorna se as entradas sao validas.
	 * @return void.
	 */		
	private void entradaValida(String entrada){
        if(entrada == null)throw new NullPointerException("Parâmetro null!");
        if(entrada.trim().equals("")) throw new IllegalArgumentException("Entrada vazia!");
    }
	
	/**
	 * Metodo que verifica se um email e valido para o sistema, ou seja, se existe um "@" e conteudo antes e depois da mesma.
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
	 * Metodo que retorna o codigo do curso.
	 * @return int.
	 */
	public int getCodigoCurso() {
		return codigoCurso;
	}
	
	/**
	 * Metodo que retorna a matricula.
	 * @return String.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Metodo que retorna o nome.
	 * @return String.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna o telefone.
	 * @return String.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Metodo modifica o numero do telefone do Aluno a partir do parametro.
	 * @param telefone String que e o novo numero de telefone do Aluno.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Metodo que retorna o email.
	 * @return String.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo modifica o email do aluno a partir do parametro.
	 * @param email String que e o novo do email do Aluno. 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Metodo que retorna um objeto do tipo Tutoria.
	 * @return Tutoria que e um objeto do tipo Tutoria.
	 */
	public Tutoria getTutoria() {
		return this.tutoria;
	}
	
	/**
	 * Metodo que retorna o formato de impressao do aluno.
	 * O telefone e opcional.
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

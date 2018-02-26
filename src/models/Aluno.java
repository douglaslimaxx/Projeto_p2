package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aluno {
	
	private int codigoCurso;
	private String matricula, nome, telefone, email;

	public Aluno(String nome, String matricula, String email, String telefone, int codigoCurso) {
		entradaValida(nome);
		entradaValida(matricula);
		entradaValida(telefone);
		
		this.nome = nome;
		this.matricula = matricula;
		this.telefone = telefone;
		this.codigoCurso = codigoCurso;		
		
	}
	
	private void entradaValida(String entrada){
        if(entrada == null)throw new NullPointerException("Parâmetro null!");
        if(entrada.trim().equals("")) throw new IllegalArgumentException("Entrada vazia!");
    }
	
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
	
	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean verificaTelefone(String telefone) {
		if (telefone.length() == 0) {
			return false;
		} else {
			return true;
		}		
	}
	
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email;
	}

}

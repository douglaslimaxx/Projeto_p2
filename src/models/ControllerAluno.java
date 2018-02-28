package models;

/**
 * Essa classe e usada como controlador para a classe alunos.
 * 
 * @author Gabriel Felipe Cardoso Gomes - 117110681
 */

import java.util.HashMap;

public class ControllerAluno {

	private HashMap<String, Aluno> alunos;
	
	public ControllerAluno() {
		alunos = new HashMap<String, Aluno>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		alunos.put(nome, new Aluno(nome, matricula, email, telefone, codigoCurso));
	}
	
	public String recuperaAluno(String matricula) {
		return alunos.get(matricula).toString();
	}
	
	public String listaAlunos() {
		String ret = "";
		int qtd = 0;
		for(Aluno a : alunos.values()) {
			if(qtd != 0)ret += ", ";
			ret += a.toString();
			qtd++;
		}
		return ret;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		switch(atributo) {
			case "nome":
				return alunos.get(matricula).getNome();
			case "matricula":
				return alunos.get(matricula).getMatricula();
			case "codigoCurso":
				return "" + alunos.get(matricula).getCodigoCurso();
			case "telefone":
				return alunos.get(matricula).getTelefone();
			case "email":
				return alunos.get(matricula).getEmail();
		}
		throw new IllegalArgumentException("");
	}
	
	public void tornaTutor(String matricula, String disciplina, int proficiencia) {
		alunos.get(matricula).tornaTutor(disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		if(alunos.get(matricula).isTutor()) return alunos.get(matricula).toString();
		throw new IllegalArgumentException("");
	}
	
	public String listaTutores() {
		String ret = "";
		int qtd = 0;
		for(Aluno a : alunos.values()) {
			if(!a.isTutor())continue;
			if(qtd != 0)ret += ", ";
			ret += a.toString();
			qtd++;
		}
		return ret;
	}
	
}

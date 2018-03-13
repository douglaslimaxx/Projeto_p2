package main;

import java.util.Comparator;


/**
 * Classe que compara os os nomes dos alunos, utilizando o comparator (compareTo).
 * @author Douglas Lima
 * 
 */
public class NomeComparador implements Comparator<Aluno>{

	/**
	 * Metodo que compara os nomes dos alunos.
	 * @return
	 * 
	 */
	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getNome().compareTo(o2.getNome()) != 0) {
			return o1.getNome().compareTo(o2.getNome());
		} else {
			return o1.getMatricula().compareTo(o2.getMatricula());
		}	
	}
}

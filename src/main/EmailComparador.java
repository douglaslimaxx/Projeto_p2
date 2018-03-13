package main;

import java.util.Comparator;


/**
 * Classe que compara os emails dos alunos, utilizando o comparator (compareTo).
 * @author Douglas Lima
 * 
 */
public class EmailComparador implements Comparator<Aluno>{

	/**
	 * Metodo que compara os emails dos alunos.
	 * @return
	 * 
	 */
	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getEmail().compareTo(o2.getEmail()) != 0) {
			return o1.getEmail().compareTo(o2.getEmail());
		} else {
			return o1.getMatricula().compareTo(o2.getMatricula());
		}
	}

}

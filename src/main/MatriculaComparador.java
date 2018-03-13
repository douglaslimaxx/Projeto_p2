package main;

import java.util.Comparator;


/**
 * Classe que compara a matricula dos alunos, utilizando o comparator (compareTo).
 * @author Douglas Lima
 * 
 */
public class MatriculaComparador implements Comparator<Aluno>{

	/**
	 * Metodo que compara a matricula de dois alunos.
	 * @return
	 */
	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());
	}

}

package models;

import java.util.Comparator;

/**
 * 
 * @author Douglas Lima
 *
 */
public class NomeComparador implements Comparator<Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getNome().compareTo(o2.getNome()) != 0) {
			return o1.getNome().compareTo(o2.getNome());
		} else {
			return o1.getMatricula().compareTo(o2.getMatricula());
		}
		
	}

}

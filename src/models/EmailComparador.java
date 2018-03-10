package models;

import java.util.Comparator;

/**
 * 
 * @author Douglas Lima
 *
 */
public class EmailComparador implements Comparator<Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getEmail().compareTo(o2.getMatricula()) != 0) {
			return o1.getEmail().compareTo(o2.getMatricula());
		} else {
			return o1.getMatricula().compareTo(o2.getMatricula());
		}
	}

}

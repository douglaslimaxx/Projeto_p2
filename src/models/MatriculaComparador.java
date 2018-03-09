package models;

import java.util.Comparator;

public class MatriculaComparador implements Comparator<Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());
	}

}

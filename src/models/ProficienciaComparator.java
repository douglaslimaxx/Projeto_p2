package models;

import java.util.Comparator;

public class ProficienciaComparator implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getTutoria().getProficiencia(disciplina) - o1.getTutoria().getProficiencia(disciplina); 
	}

}

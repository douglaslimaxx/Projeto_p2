package models;

import java.util.Comparator;

public class ProficienciaComparator implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getTutoria().getProficiencia(disciplina)==o2.getTutoria().getProficiencia(disciplina)) {
			return o1.getTutoria().getProficiencia(disciplina) - o1.getTutoria().getProficiencia(disciplina);
		} else {
			return o1.getCadastro() - o2.getCadastro();
		}
		 
	}

}

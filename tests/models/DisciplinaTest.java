package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Disciplina;

public class DisciplinaTest {
	private Disciplina Discreta;
	
	@Before
	public void setUp() {
		Discreta = new Disciplina("discreta", 2);
	}

	@Test
	public void testaDisciplinaNula() {
		try {
			Discreta = new Disciplina(null, 2);
		} catch (NullPointerException df) {
			assertEquals(df.getMessage(), "Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testaDisciplinaVazia() {
		try {
			Discreta = new Disciplina("    ", 2);
		} catch (IllegalArgumentException fg) {
			assertEquals(fg.getMessage(), "Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testaProficienciaMenor() {
		try {
			Discreta = new Disciplina("discreta", 0);
		} catch (IllegalArgumentException af) {
			assertEquals(af.getMessage(), "Proficiencia invalida");
		}
	}
	
	@Test
	public void testaProficienciaMaior() {
		try {
			Discreta = new Disciplina("discreta", 6);
		} catch (IllegalArgumentException dj) {
			assertEquals(dj.getMessage(), "Proficiencia invalida");
		}
	}
	
	@Test
	public void testaSetProficienciaMenor() {
		try {
			Discreta.setProficiencia(0);
		} catch (IllegalArgumentException kl) {
			assertEquals(kl.getMessage(), "Proficiencia invalida");
		}
	}
	
	@Test
	public void testaSetProficienciaMaior() {
		try {
			Discreta.setProficiencia(6);
		} catch (IllegalArgumentException mp) {
			assertEquals(mp.getMessage(), "Proficiencia invalida");
		}
	}

}

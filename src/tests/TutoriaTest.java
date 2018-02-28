package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Tutoria;

public class TutoriaTest {

	private Tutoria tutoria;

	@Before
	public void setUp() {
		tutoria = new Tutoria();
	}
	
	@Test
	public void testeAvaliacaoInicia4() {
		String msg = "Avaliacao deve iniciar com 4";
		assertEquals(msg, 4, this.tutoria.getAvaliacao());
	}
	
	@Test
	public void testeQuantiaInicia0() {
		String msg = "Quantia deve iniciar com 0";
		assertEquals(msg, 0, this.tutoria.getQuantia());
	}
	
	@Test
	public void testeMapIniciaVazio() {
		String msg = "O mapa de disciplinas deve iniciar vazio";
		assertTrue(msg, !this.tutoria.isTutor());
	}
	
	@Test
	public void testeAdicionaDisciplinaDisciplinaNula() {
		try {
			this.tutoria.adicionaDisciplina(null, 3);
		} catch (NullPointerException dn){
			assertEquals(dn.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaDisciplinaVazia() {
		try {
			this.tutoria.adicionaDisciplina("   ", 3);
		} catch (NullPointerException dv){
			assertEquals(dv.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaZero() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", 0);
		} catch (NullPointerException pz){
			assertEquals(pz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaMenorZero() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", -2);
		} catch (NullPointerException pmz){
			assertEquals(pmz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaMaiorCinco() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", 6);
		} catch (NullPointerException pmc){
			assertEquals(pmc.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
}

package models;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

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
		} catch (IllegalArgumentException dv){
			assertEquals(dv.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaZero() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", 0);
		} catch (NoSuchElementException pz){
			assertEquals(pz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaMenorZero() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", -2);
		} catch (NoSuchElementException pmz){
			assertEquals(pmz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeAdicionaDisciplinaProficienciaMaiorCinco() {
		try {
			this.tutoria.adicionaDisciplina("Ingles", 6);
		} catch (NoSuchElementException pmc){
			assertEquals(pmc.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeGetDisciplinaDisciplinaNula() {
		try {
			this.tutoria.getDisciplina(null);
		} catch (NullPointerException dn){
			assertEquals(dn.getMessage(), "Erro na recuperação de disciplina: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetDisciplinaDisciplinaVazia() {
		try {
			this.tutoria.getDisciplina("   ");
		} catch (IllegalArgumentException dv){
			assertEquals(dv.getMessage(), "Erro na recuperação de disciplina: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetProficienciaDisciplinaNula() {
		try {
			this.tutoria.getProficiencia(null);
		} catch (NullPointerException dn){
			assertEquals(dn.getMessage(), "Erro na recuperação da proficiencia: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetProficienciaDisciplinaVazia() {
		try {
			this.tutoria.getProficiencia("   ");
		} catch (IllegalArgumentException dv){
			assertEquals(dv.getMessage(), "Erro na recuperação da proficiencia: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeSetProficienciaDisciplinaNula() {
		try {
			this.tutoria.setProficiencia(null, 3);
		} catch (NullPointerException dn){
			assertEquals(dn.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeSetProficienciaDisciplinaVazia() {
		try {
			this.tutoria.setProficiencia("   ", 3);
		} catch (IllegalArgumentException dv){
			assertEquals(dv.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeSetProficienciaProficienciaZero() {
		try {
			this.tutoria.setProficiencia("Ingles", 0);
		} catch (NoSuchElementException pz){
			assertEquals(pz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeSetProficienciaProficienciaMenorZero() {
		try {
			this.tutoria.setProficiencia("Ingles", -2);
		} catch (NoSuchElementException pmz){
			assertEquals(pmz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeSetProficienciaProficienciaMaiorCinco() {
		try {
			this.tutoria.setProficiencia("Ingles", 6);
		} catch (NoSuchElementException pmc){
			assertEquals(pmc.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
}

package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.Disponibilidade;

public class DisponibilidadeTest {

	private Disponibilidade disponibilidade;
	
	@Before
	public void setUp() {
		disponibilidade = new Disponibilidade("algumnome@email.com");
	}


	@Test
	public void testeEmailNulo() {
		try {
			disponibilidade = new Disponibilidade(null);
		} catch (NullPointerException ms) {
			assertEquals(ms.getMessage(), "Erro na definicao de papel: email nao pode ser vazio ou nulo");
		}
	}

	@Test
	public void testeEmailVazio() {
		try {
			disponibilidade = new Disponibilidade("");
		} catch (IllegalArgumentException ma) {
			assertEquals(ma.getMessage(), "Erro na definicao de papel: email nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastroHorarioNulo() {
		try {
			this.disponibilidade.cadastrarHorario(null, "seg");
		} catch (NullPointerException ls) {
			assertEquals(ls.getMessage(), "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	

}

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
			disponibilidade = new Disponibilidade("   ");
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
	
	@Test
	public void testeCadastroHorarioVazio() {
		try {
			this.disponibilidade.cadastrarHorario("   ", "seg");
		} catch (IllegalArgumentException sk) {
			assertEquals(sk.getMessage(), "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastroDiaNulo() {
		try {
			this.disponibilidade.cadastrarHorario("seg", null);
		} catch (NullPointerException jp) {
			assertEquals(jp.getMessage(), "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastroDiaVazio() {
		try {
			this.disponibilidade.cadastrarHorario("seg", "   ");
		} catch (IllegalArgumentException ka) {
			assertEquals(ka.getMessage(), "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastroLocalNulo() {
		try {
			this.disponibilidade.cadastrarLocalDeAtendimento(null);
		} catch (NullPointerException tl) {
			assertEquals(tl.getMessage(), "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastroLocalVazio() {
		try {
			this.disponibilidade.cadastrarLocalDeAtendimento("    ");
		} catch (IllegalArgumentException po) {
			assertEquals(po.getMessage(), "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioNulo() {
		try {
			this.disponibilidade.consultaHorario(null, "seg");
		} catch (NullPointerException lq) {
			assertEquals(lq.getMessage(), "Erro ao consultar horario de atendimento: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioVazio() {
		try {
			this.disponibilidade.consultaHorario("", "seg");
		} catch (IllegalArgumentException yg) {
			assertEquals(yg.getMessage(), "Erro ao consultar horario de atendimento: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaDiaNulo() {
		try {
			this.disponibilidade.consultaHorario("15:00", null);
		} catch (NullPointerException hb) {
			assertEquals(hb.getMessage(), "Erro ao consultar horario de atendimento: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaDiaVazio() {
		try {
			this.disponibilidade.consultaHorario("15:00", "");
		} catch (IllegalArgumentException qw) {
			assertEquals(qw.getMessage(), "Erro ao consultar horario de atendimento: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalNulo() {
		try {
			this.disponibilidade.consultaLocal(null);
		} catch (NullPointerException sd) {
			assertEquals(sd.getMessage(), "Erro ao consultar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalVazio() {
		try {
			this.disponibilidade.consultaLocal("   ");
		} catch (IllegalArgumentException rg) {
			assertEquals(rg.getMessage(), "Erro ao consultar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}

	
	

}

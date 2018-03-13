package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ajuda.AjudaPresencial;
import aluno.Aluno;

public class AjudaPresencialTest {

	private AjudaPresencial ajuda;
	private Aluno tutor;
	
	@Before
	public void setUp() {
		tutor = new Aluno("Douglas", "1111", "douglas@mail.com", "9999", 2, 1);
		this.tutor.adicionaDisciplina("p2", 4);
		this.tutor.cadastrarHorario("15:00", "sex");
		this.tutor.cadastrarLocalDeAtendimento("biblioteca");
		ajuda = new AjudaPresencial("2222", "p2", tutor, "15:00", "sex", "biblioteca");
	}
	
	@Test
	public void testeCriarAjudaPresencialHorarioNulo() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, null, "sex", "biblioteca");
		} catch (NullPointerException hn) {
			assertEquals(hn.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialHorarioVazio() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, "   ", "sex", "biblioteca");
		} catch (IllegalArgumentException hv) {
			assertEquals(hv.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialDiaNulo() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, "15:00", null, "biblioteca");
		} catch (NullPointerException dn) {
			assertEquals(dn.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialDiaVazio() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, "15:00", "    ", "biblioteca");
		} catch (IllegalArgumentException dv) {
			assertEquals(dv.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialLocalNulo() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, "15:00", "sex", null);
		} catch (NullPointerException ln) {
			assertEquals(ln.getMessage(), "local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialLocalVazio() {
		try {
			ajuda = new AjudaPresencial("2222", "p2", tutor, "15:00", "sex", "    ");
		} catch (IllegalArgumentException lv) {
			assertEquals(lv.getMessage(), "local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaPresencialHorarioCorreto() {
		String msg = "O horario que foi cadastrado da ajuda é as 15:00";
		assertEquals(msg, "15:00", ajuda.getHorario());
	}
	
	@Test
	public void testeCriarAjudaPresencialDiaCorreto() {
		String msg = "O dia que foi cadastrado da ajuda é a sexta";
		assertEquals(msg, "sex", ajuda.getDia());
	}

	@Test
	public void testeCriarAjudaPresencialLocalCorreto() {
		String msg = "O local que foi cadastrado da ajuda é a biblioteca";
		assertEquals(msg, "biblioteca", ajuda.getLocal());
	}
	
	@Test
	public void testeCriarAjudaPresencialCorreto() {
		String msg = "A representacao textual de ajuda Presencial deve ser da seguinte forma: "
				+ "Tutor - (matricula do tutor), horario - (horario da ajuda), dia - (dia da ajuda), local (local da ajuda), disciplina - (disciplina)";
		assertEquals(msg, "Tutor - 1111, horario - 15:00, dia - sex, local - biblioteca, disciplina - p2", ajuda.toString());
	}

}

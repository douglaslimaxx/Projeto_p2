package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ajuda.AjudaOnline;
import aluno.Aluno;

public class AjudaOnlineTest {

	private AjudaOnline ajuda;
	private Aluno tutor;
	
	@Before
	public void setUp() {
		tutor = new Aluno("Douglas", "1111", "douglas@mail.com", "9999", 2, 1);
		this.tutor.adicionaDisciplina("p2", 4);
		ajuda = new AjudaOnline("2222", "p2", tutor);
	}
	
	@Test
	public void testeCriarAjudaOnlineAlunoNulo() {
		try {
			ajuda = new AjudaOnline(null, "p2", tutor);
		} catch (NullPointerException an) {
			assertEquals(an.getMessage(), "matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaOnlineAlunoVazio() {
		try {
			ajuda = new AjudaOnline("   ", "p2", tutor);
		} catch (IllegalArgumentException av) {
			assertEquals(av.getMessage(), "matricula de aluno nao pode ser vazio ou em branco");
		}
	}

	@Test
	public void testeCriarAjudaOnlineDisciplinaNula() {
		try {
			ajuda = new AjudaOnline("Douglas", null, tutor);
		} catch (NullPointerException dn) {
			assertEquals(dn.getMessage(), "disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaOnlineDisciplinaVazia() {
		try {
			ajuda = new AjudaOnline("Douglas", "   ", tutor);
		} catch (IllegalArgumentException dv) {
			assertEquals(dv.getMessage(), "disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCriarAjudaOnlineAlunoCorreto() {
		String msg = "A matricula do aluno que pediu a ajuda é '2222'";
		assertEquals(msg, "2222", ajuda.getMatriculaAluno());
	}
	
	@Test
	public void testeCriarAjudaOnlineDisciplinaCorreta() {
		String msg = "A disciplina na qual a ajuda é feita deve ser 'p2'";
		assertEquals(msg, "p2", ajuda.getDisciplina());
	}
	
	@Test
	public void testeCriarAjudaOnlineTutorCorreto() {
		String msg = "A tutor que vai realizar a ajuda é douglas";
		assertEquals(msg, tutor, ajuda.getTutor());
	}
	
	@Test
	public void testeCriarAjudaOnlineCorreto() {
		String msg = "A representacao textual de uma ajuda online deve ser da seguinte "
				+ "forma: Tutor - (matricula do tutor), disciplina - (disciplina)";
		assertEquals(msg, "Tutor - 1111, disciplina - p2", ajuda.toString());
	}
	
}

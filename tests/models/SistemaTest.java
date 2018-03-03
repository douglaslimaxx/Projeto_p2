package models;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	private Sistema sistema;
	
	@Before
	public void setUp() {
		sistema = new Sistema();
	}
	
	@Test
	public void testeDinheiroIniciaZero() {
		String msg = "Dinheiro de Sistema deve iniciar vazio";
		assertEquals(msg, 0, this.sistema.totalDinheiroSistema());
	}
	
	@Test
	public void testeCadastrarAlunoNomeNulo() {
		try {
			this.sistema.cadastrarAluno(null, "1111", 2, "9999", "misscoisinha@poomail.com");
		} catch (NullPointerException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoNomeVazio() {
		try {
			this.sistema.cadastrarAluno("   ", "1111", 2, "9999", "misscoisinha@poomail.com");
		} catch (IllegalArgumentException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoMatriculaNula() {
		try {
			this.sistema.cadastrarAluno("Douglas", null, 2, "9999", "misscoisinha@poomail.com");
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro no cadastro de aluno: Matricula nao pode ser vazia ou nula");
		}
	}

	@Test
	public void testeCadastrarAlunoMatriculaVazia() {
		try {
			this.sistema.cadastrarAluno("Douglas", "   ", 2, "9999", "misscoisinha@poomail.com");
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro no cadastro de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeCadastrarAlunoTelefoneNulo() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, null, "misscoisinha@poomail.com");
		} catch (NullPointerException tn) {
			assertEquals(tn.getMessage(), "Erro no cadastro de aluno: Telefone nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailNulo() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", null);
		} catch (NullPointerException en) {
			assertEquals(en.getMessage(), "Erro no cadastro de aluno: Email nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido1() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "@");
		} catch (IllegalArgumentException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido2() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "@poomail.com");
		} catch (IllegalArgumentException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido3() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@");
		} catch (IllegalArgumentException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido4() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinhapoomail.com");
		} catch (IllegalArgumentException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeRecuperaAlunoMatriculaNula() {
		try {
			this.sistema.recuperaAluno(null);
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro na busca por aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaAlunoMatriculaVazia() {
		try {
			this.sistema.recuperaAluno("  ");
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro na busca por aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetInfoAlunoMatriculaNula() {
		try {
			this.sistema.getInfoAluno(null, "Nome");
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetInfoAlunoMatriculaVazia() {
		try {
			this.sistema.getInfoAluno("   ", "Nome");
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}

	@Test
	public void testeGetInfoAlunoInfoNula() {
		try {
			this.sistema.getInfoAluno("1111", null);
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetInfoAlunoInfoVazia() {
		try {
			this.sistema.getInfoAluno("1111", "   ");
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorMatriculaNula() {
		try {
			this.sistema.tornarTutor(null, "p2", 3);
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro na definicao de papel: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorMatriculaVazia() {
		try {
			this.sistema.tornarTutor("   ", "p2", 3);
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro na definicao de papel: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorDisciplinaNula() {
		try {
			this.sistema.tornarTutor("1111", null, 3);
		} catch (NullPointerException dn) {
			assertEquals(dn.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorDisciplinaVazia() {
		try {
			this.sistema.tornarTutor("1111", "    ", 3);
		} catch (IllegalArgumentException dv) {
			assertEquals(dv.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorProficienciaZero() {
		try {
			this.sistema.tornarTutor("1111", "p2", 0);
		} catch (NoSuchElementException pz){
			assertEquals(pz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeTornarTutorProficienciaMenorZero() {
		try {
			this.sistema.tornarTutor("1111", "p2", -6);
		} catch (NoSuchElementException pmz){
			assertEquals(pmz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	

	@Test
	public void testeTornarTutorProficienciaMaiorCinco() {
		try {
			this.sistema.tornarTutor("1111", "p2", 9);
		} catch (NoSuchElementException pmc){
			assertEquals(pmc.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeRecuperaTutorMatriculaNula() {
		try {
			this.sistema.recuperaTutor(null);
		} catch (NullPointerException mn) {
			assertEquals(mn.getMessage(), "Erro na busca por Tutor: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaTutorMatriculaVazia() {
		try {
			this.sistema.recuperaTutor("  ");
		} catch (IllegalArgumentException mv) {
			assertEquals(mv.getMessage(), "Erro na busca por Tutor: Matricula nao pode ser vazia ou nula");
		}
	}
	
	
	
}

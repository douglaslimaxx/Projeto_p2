package models;

import static org.junit.Assert.*;

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
		} catch (RuntimeException nn) {
			assertEquals(nn.getMessage(), "Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoNomeVazio() {
		try {
			this.sistema.cadastrarAluno("   ", "1111", 2, "9999", "misscoisinha@poomail.com");
		} catch (RuntimeException nv) {
			assertEquals(nv.getMessage(), "Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoMatriculaNula() {
		try {
			this.sistema.cadastrarAluno("Douglas", null, 2, "9999", "misscoisinha@poomail.com");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no cadastro de aluno: Matricula nao pode ser vazia ou nula");
		}
	}

	@Test
	public void testeCadastrarAlunoMatriculaVazia() {
		try {
			this.sistema.cadastrarAluno("Douglas", "   ", 2, "9999", "misscoisinha@poomail.com");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no cadastro de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeCadastrarAlunoTelefoneNulo() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, null, "misscoisinha@poomail.com");
		} catch (RuntimeException tn) {
			assertEquals(tn.getMessage(), "Erro no cadastro de aluno: Telefone nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailNulo() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", null);
		} catch (RuntimeException en) {
			assertEquals(en.getMessage(), "Erro no cadastro de aluno: Email nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido1() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "@");
		} catch (RuntimeException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido2() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "@poomail.com");
		} catch (RuntimeException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido3() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@");
		} catch (RuntimeException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido4() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinhapoomail.com");
		} catch (RuntimeException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	
	@Test
	public void testeCadastrarAlunoEmailInvalido5() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "");
		} catch (RuntimeException ei) {
			assertEquals(ei.getMessage(), "Erro no cadastro de aluno: Email invalido");
		}
	}
	@Test
	public void testeCadastrarAlunoMatriculaJaCadastrada() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.cadastrarAluno("Joao", "1111", 2, "4563", "coisinha@poomail.com");
		} catch (RuntimeException jc) {
			assertEquals(jc.getMessage(), "Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
	}
	
	
	@Test
	public void testeRecuperaAlunoMatriculaNula() {
		try {
			this.sistema.recuperaAluno(null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na busca por aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaAlunoMatriculaVazia() {
		try {
			this.sistema.recuperaAluno("  ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na busca por aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaAlunoNaoCadastrado() {
		try {
			this.sistema.recuperaAluno("1112");
		} catch (RuntimeException nc) {
			assertEquals(nc.getMessage(), "Erro na busca por aluno: Aluno nao encontrado");
		}
	}
	@Test
	public void testeRecuperaAlunoCorreto() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		String msg = "Representacao desse Aluno deve estar da seguinte forma - '1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com'";
		assertEquals(msg, "1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com", this.sistema.recuperaAluno("1111"));
	}
	
	@Test
	public void testeListarAluno() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.cadastrarAluno("Marta", "3333", 2, "6363", "martatop@poogmail.com");
		this.sistema.cadastrarAluno("Gabriel", "0000", 2, "7777", "doritos@poomail.com");
		String msg = "A lista de alunos, deve ter a representacao textual dos alunos cadastrados, em ordem alfabeticas dos nomes";
		assertEquals(msg, ("1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com" + System.lineSeparator() +
						"0000 - Gabriel - 2 - 7777 - doritos@poomail.com" + System.lineSeparator() +
						"2222 - Marcella - 2 - 8888 - cella@poomail.com" + System.lineSeparator() + 
						"3333 - Marta - 2 - 6363 - martatop@poogmail.com" + System.lineSeparator()), 
						this.sistema.listarAlunos());
	}
	
	@Test
	public void testeGetInfoAlunoMatriculaNula() {
		try {
			this.sistema.getInfoAluno(null, "Nome");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetInfoAlunoMatriculaVazia() {
		try {
			this.sistema.getInfoAluno("   ", "Nome");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na obtencao de informacao de aluno: Matricula nao pode ser vazia ou nula");
		}
	}

	@Test
	public void testeGetInfoAlunoInfoNula() {
		try {
			this.sistema.getInfoAluno("1111", null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na obtencao de informacao de aluno: Atributo nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeGetInfoAlunoInfoVazia() {
		try {
			this.sistema.getInfoAluno("1111", "   ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na obtencao de informacao de aluno: Atributo nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testeGetInfoAlunoNaoCadastrado() {
		try {
			this.sistema.getInfoAluno("1152", "Nome");
		} catch (RuntimeException nd) {
			assertEquals(nd.getMessage(), "Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
	}
	
	@Test
	public void testeGetInfoAtributoInvalido() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.getInfoAluno("1111", "musica favorita");
		} catch (RuntimeException ai) {
			assertEquals(ai.getMessage(), "Erro na obtencao de informacao de aluno: Atributo invalido");
		}
	}
	
	@Test
	public void testeTornarTutorMatriculaNula() {
		try {
			this.sistema.tornarTutor(null, "p2", 3);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na definicao de papel: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorMatriculaVazia() {
		try {
			this.sistema.tornarTutor("   ", "p2", 3);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na definicao de papel: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorDisciplinaNula() {
		try {
			this.sistema.tornarTutor("1111", null, 3);
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorDisciplinaVazia() {
		try {
			this.sistema.tornarTutor("1111", "    ", 3);
		} catch (RuntimeException dv) {
			assertEquals(dv.getMessage(), "Erro na definicao de papel: Disciplina nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeTornarTutorProficienciaZero() {
		try {
			this.sistema.tornarTutor("1111", "p2", 0);
		} catch (RuntimeException pz){
			assertEquals(pz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeTornarTutorProficienciaMenorZero() {
		try {
			this.sistema.tornarTutor("1111", "p2", -6);
		} catch (RuntimeException pmz){
			assertEquals(pmz.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	

	@Test
	public void testeTornarTutorProficienciaMaiorCinco() {
		try {
			this.sistema.tornarTutor("1111", "p2", 9);
		} catch (RuntimeException pmc){
			assertEquals(pmc.getMessage(), "Erro na definicao de papel: Proficiencia Invalida");
		}
	}
	
	@Test
	public void testeTornarTutorAlunoNaoCadastrado() {
		try {
			this.sistema.tornarTutor("1179", "Ingles", 4);
		} catch (RuntimeException nc) {
			assertEquals(nc.getMessage(), "Erro na definicao de papel: Tutor nao encontrado");
		}
	}
	
	@Test
	public void testeTornarTutorAlunoJaTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.tornarTutor("1111", "p2", 3);
			this.sistema.tornarTutor("1111", "p2", 3);
		} catch (RuntimeException jt) {
			assertEquals(jt.getMessage(), "Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
	}
	
	@Test
	public void testeRecuperaTutorMatriculaNula() {
		try {
			this.sistema.recuperaTutor(null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na busca por Tutor: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaTutorMatriculaVazia() {
		try {
			this.sistema.recuperaTutor("  ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na busca por Tutor: Matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testeRecuperaTutorNaoCadastrado() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.recuperaTutor("0000");
		} catch (RuntimeException nc) {
			assertEquals(nc.getMessage(), "Erro na busca por tutor: Tutor nao encontrado");
		}
	}
	
	@Test
	public void testeListarTutoresNomeComparador() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.cadastrarAluno("Marta", "3333", 2, "6363", "martatop@poogmail.com");
		this.sistema.cadastrarAluno("Gabriel", "0000", 2, "7777", "doritos@poomail.com");
		this.sistema.tornarTutor("1111", "Programacao 2", 3);
		this.sistema.tornarTutor("2222", "Ic", 5);
		String msg = "O método listarTutores deve retornar uma concatenação da "
				+ "representação textual de todos os alunos que se tornaram tutores"
				+ "ordenando-os pelo nome";
		assertEquals(msg, "1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com" + ", " + 
				"2222 - Marcella - 2 - 8888 - cella@poomail.com", this.sistema.listarTutores());
	}
	
	@Test
	public void testeListarTutoresEmailComparador() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "Programacao 2", 3);
		this.sistema.tornarTutor("2222", "Ic", 5);
		this.sistema.configurarOrdem("EMAIL");
		String msg = "O método listarTutores deve retornar uma concatenação da "
				+ "representação textual de todos os alunos que se tornaram tutores"
				+ "ordenando-os pelo email";
		assertEquals(msg, "2222 - Marcella - 2 - 8888 - cella@poomail.com" + ", " +
				"1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com", this.sistema.listarTutores());
	}
	
	@Test
	public void testeListarTutoresMatriculaComparador() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "Programacao 2", 3);
		this.sistema.tornarTutor("2222", "Ic", 5);
		this.sistema.configurarOrdem("MATRICULA");
		String msg = "O método listarTutores deve retornar uma concatenação da "
				+ "representação textual de todos os alunos que se tornaram tutores"
				+ "ordenando-os pela matricula";
		assertEquals(msg, "1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com" + ", " + 
				"2222 - Marcella - 2 - 8888 - cella@poomail.com", this.sistema.listarTutores());
	}
	
	@Test
	public void testeCadastrarHorarioEmailNulo() {
		try {
			this.sistema.cadastrarHorario(null, "15:00", "seg");
		} catch (RuntimeException en) {
			assertEquals(en.getMessage(), "Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioEmailVazio() {
		try {
			this.sistema.cadastrarHorario("   ", "15:00", "seg");
		} catch (RuntimeException ev) {
			assertEquals(ev.getMessage(), "Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioHorarioNulo() {
		try {
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", null, "seg");
		} catch (RuntimeException hn) {
			assertEquals(hn.getMessage(), "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioHorarioVazio() {
		try {
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", "   ", "seg");
		} catch (RuntimeException hv) {
			assertEquals(hv.getMessage(), "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioDiaNulo() {
		try {
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", null);
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioDiaVazio() {
		try {
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "   ");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarHorarioTutorNaoCadastrado() {
		try {
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "seg");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar horario: tutor nao cadastrado");
		}
	}
	
	@Test
	public void testeCadastrarHorarioAlunoNaoTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "seg");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar horario: aluno nao eh tutor");
		}
	}
	
	@Test
	public void testeCadastrarHorarioCorreto() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.tornarTutor("1111", "ingles", 5);
		this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "seg");
		String msg = "O tutor Douglas deve ter esse horario disponivel, apos o cadastro";
		assertTrue(msg, this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", "seg"));
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoEmailNulo() {
		try {
			this.sistema.cadastrarLocalDeAtendimento(null, "LCC2");
		} catch (RuntimeException en) {
			assertEquals(en.getMessage(), "Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoEmailVazio() {
		try {
			this.sistema.cadastrarLocalDeAtendimento("   ", "LCC2");
		} catch (RuntimeException ev) {
			assertEquals(ev.getMessage(), "Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoTutorNaoCadastrado() {
		try {
			this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "LCC2");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoAlunoNaoTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "LCC2");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro no cadastrar local de atendimento: aluno nao eh tutor");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoLocalNulo() {
		try {
			this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", null);
		} catch (RuntimeException ln) {
			assertEquals(ln.getMessage(), "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoLocalVazio() {
		try {
			this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "   ");
		} catch (RuntimeException lv) {
			assertEquals(lv.getMessage(), "Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeCadastrarLocalDeAtendimentoCorreto() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.tornarTutor("1111", "ingles", 5);
		this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "LCC2");
		String msg = "O tutor Douglas deve ter esse local disponivel, apos o cadastro";
		assertTrue(msg, this.sistema.consultaLocal("misscoisinha@poomail.com", "LCC2"));
	}
	
	@Test
	public void testeConcultaHorarioEmailNulo() {
		try {
			this.sistema.consultaHorario(null, "15:00", "seg");
		} catch (RuntimeException en) {
			assertEquals(en.getMessage(), "Erro na consulta horario: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioEmailVazio() {
		try {
			this.sistema.consultaHorario("   ", "15:00", "seg");
		} catch (RuntimeException ev) {
			assertEquals(ev.getMessage(), "Erro na consulta horario: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioHorarioNulo() {
		try {
			this.sistema.consultaHorario("misscoisinha@poomail.com", null, "seg");
		} catch (RuntimeException hn) {
			assertEquals(hn.getMessage(), "Erro na consulta horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioHorarioVazio() {
		try {
			this.sistema.consultaHorario("misscoisinha@poomail.com", "   ", "seg");
		} catch (RuntimeException hv) {
			assertEquals(hv.getMessage(), "Erro na consulta horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioDiaNulo() {
		try {
			this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", null);
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioDiaVazio() {
		try {
			this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", "   ");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta horario: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaHorarioTutorNaoCadastrado() {
		try {
			this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", "seg");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta horario: tutor nao cadastrado");
		}
	}
	
	@Test
	public void testeConsultaHorarioAlunoNaoTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", "seg");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta horario: aluno nao eh tutor");
		}
	}
	
	@Test
	public void testeConsultaHorarioIndisponivel() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.tornarTutor("1111", "ingles", 5);
		String msg = "O tutor Douglas nao deve ter esse horario disponivel";
		assertFalse(msg, this.sistema.consultaHorario("misscoisinha@poomail.com", "15:00", "seg"));
	}
	
	@Test
	public void testeConsultaLocalEmailNulo() {
		try {
			this.sistema.consultaLocal(null, "LCC2");
		} catch (RuntimeException en) {
			assertEquals(en.getMessage(), "Erro na consulta local de atendimento: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalEmailVazio() {
		try {
			this.sistema.consultaLocal("   ", "LCC2");
		} catch (RuntimeException ev) {
			assertEquals(ev.getMessage(), "Erro na consulta local de atendimento: email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalTutorNaoCadastrado() {
		try {
			this.sistema.consultaLocal("misscoisinha@poomail.com", "LCC2");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta local de atendimento: tutor nao cadastrado");
		}
	}
	
	@Test
	public void testeConsultaLocalAlunoNaoTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.consultaLocal("misscoisinha@poomail.com", "LCC2");
		} catch (RuntimeException dn) {
			assertEquals(dn.getMessage(), "Erro na consulta local de atendimento: aluno nao eh tutor");
		}
	}
	
	@Test
	public void testeConsultaLocalLocalNulo() {
		try {
			this.sistema.consultaLocal("misscoisinha@poomail.com", null);
		} catch (RuntimeException ln) {
			assertEquals(ln.getMessage(), "Erro na consulta local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalLocalVazio() {
		try {
			this.sistema.consultaLocal("misscoisinha@poomail.com", "   ");
		} catch (RuntimeException lv) {
			assertEquals(lv.getMessage(), "Erro na consulta local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeConsultaLocalIndisponivel() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.tornarTutor("1111", "ingles", 5);
		String msg = "O tutor Douglas nao deve ter esse local disponivel";
		assertFalse(msg, this.sistema.consultaLocal("misscoisinha@poomail.com", "LCC2"));
	}
	
	@Test
	public void testeDoarMatriculaNula() {
		try {
			this.sistema.doar(null, 100);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro na doacao para tutor: matriculaTutor nao vazia ou nula");
		}
	}
	
	@Test
	public void testeDoarMatriculaVazia() {
		try {
			this.sistema.doar("   ", 100);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na doacao para tutor: matriculaTutor nao vazia ou nula");
		}
	}
	
	@Test
	public void testeDoarMatriculaTutorNaoEncontrado() {
		try {
			this.sistema.doar("1111", 100);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na doacao para tutor: Tutor nao encontrado");
		}
	}
	
	@Test
	public void testeDoarMatriculaAlunoNaoTutor() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.doar("1111", 100);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro na doacao para tutor: Aluno nao Tutor");
		}
	}
	
	@Test
	public void testeDoarMatriculaTotalCentavosZero() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.tornarTutor("1111", "p2", 4);
			this.sistema.doar("1111", 0);
		} catch (RuntimeException tcz) {
			assertEquals(tcz.getMessage(), "Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
	}
	
	@Test
	public void testeDoarMatriculaTotalCentavosMenorZero() {
		try {
			this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
			this.sistema.tornarTutor("1111", "p2", 4);
			this.sistema.doar("1111", -9);
		} catch (RuntimeException tcmz) {
			assertEquals(tcmz.getMessage(), "Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
	}

	@Test
	public void testePedirAjudaPresencialMatriculaNula() {
		try {
			this.sistema.pedirAjudaPresencial(null, "p2", "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialMatriculaVazia() {
		try {
			this.sistema.pedirAjudaPresencial("   ", "p2", "15:00", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialMatriculaNaoCadastrada() {
		try {
			this.sistema.pedirAjudaPresencial("111", "p2", "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: matricula nao cadastrada");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDisciplinaNula() {
		try {
			this.sistema.pedirAjudaPresencial("1111", null, "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDisciplinaVazia() {
		try {
			this.sistema.pedirAjudaPresencial("1111", "    ", "15:00", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialHorarioNulo() {
		try {
			this.sistema.pedirAjudaPresencial("1111", "p2", null, "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialHorarioVazio() {
		try {
			this.sistema.pedirAjudaPresencial("111", "p2", "   ", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDiaNulo() {
		try {
			this.sistema.pedirAjudaPresencial("1111", "p2", "15:00", null, "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDiaVazio() {
		try {
			this.sistema.pedirAjudaPresencial("111", "p2", "15:00", null, "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialLocalNulo() {
		try {
			this.sistema.pedirAjudaPresencial("1111", "p2", "15:00", "seg", null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialLocalVazio() {
		try {
			this.sistema.pedirAjudaPresencial("1111", "p2", "15:00", "seg", "    ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialCorreta() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		String msg = "O método pedirAjudaPresencial deve retornar o id da ajuda cadastrada";
		assertEquals(msg, 1, this.sistema.pedirAjudaPresencial("1111", "discreta", "11:00", "seg", "biblioteca"));
	}
	
	
	@Test
	public void testePedirAjudaOnlineMatriculaNula() {
		try {
			this.sistema.pedirAjudaOnline(null, "p2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineMatriculaVazia() {
		try {
			this.sistema.pedirAjudaOnline("   ", "p2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineMatriculaNaoCadastrada() {
		try {
			this.sistema.pedirAjudaOnline("111", "p2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: matricula nao cadastrada");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineDisciplinaNula() {
		try {
			this.sistema.pedirAjudaOnline("1111", null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineDisciplinaVazia() {
		try {
			this.sistema.pedirAjudaOnline("1111", "    ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineCorreta() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		String msg = "O método pedirAjudaOnline deve retornar o id da ajuda cadastrada";
		assertEquals(msg, 1, this.sistema.pedirAjudaOnline("1111", "discreta"));
	}
	
	@Test
	public void testePegarTutorIdAjudaZero() {
		try {
			this.sistema.pegarTutor(0);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testePegarTutorIdAjudaMenorZero() {
		try {
			this.sistema.pegarTutor(-1);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testePegarTutorIdAjudaNaoCadastrada() {
		try {
			this.sistema.pegarTutor(1);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao encontrado ");
		}
	}

	@Test
	public void testePegarTutorAjudaOnlineCorreto() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		String msg = "O método pegarTutor deve retornar as informacoes de tutoria"
				+ ", matricula e a disciplina do tutor";
		assertEquals(msg, "Tutor - 1111, disciplina - p2", this.sistema.pegarTutor(1));
		
	}
	
	@Test
	public void testePegarTutorAjudaPresencialCorreto() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "ter");
		this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.sistema.pedirAjudaPresencial("2222", "p2", "15:00", "ter", "biblioteca");
		String msg = "O método pegarTutor deve retornar as informacoes de tutoria"
				+ ", matricula, a disciplina, o horario, dia e local disponivel do tutor";
		assertEquals(msg, "Tutor - 1111, horario - 15:00, dia - ter, local - biblioteca, disciplina - p2", this.sistema.pegarTutor(1));
		
	}
	
	@Test
	public void testeGetInfoAjudaIdZero() {
		try {
			this.sistema.getInfoAjuda(0, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testeGetInfoAjudaIdMenorZero() {
		try {
			this.sistema.getInfoAjuda(-1, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testeGetInfoAjudaIdNaoCadastrado() {
		try {
			this.sistema.getInfoAjuda(1, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoNulo() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		try {
			this.sistema.getInfoAjuda(1, null);
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoVazio() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		try {
			this.sistema.getInfoAjuda(1, "   ");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoNaoEncontrado() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		try {
			this.sistema.getInfoAjuda(1, "ALTURA");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoTutor() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é tutor, ele retorna "
				+ "a representacao textual do tutor";
		assertEquals(msg, "1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com", this.sistema.getInfoAjuda(1, "tutor"));
	}
	
	@Test
	public void testeGetInfoAjudaAtributodisciplina() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é disciplina, ele retorna "
				+ "o nome da disciplina";
		assertEquals(msg, "p2", this.sistema.getInfoAjuda(1, "disciplina"));
	}
	
	@Test
	public void testeGetInfoAjudaAluno() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é aluno, ele retorna "
				+ "a matricula do aluno";
		assertEquals(msg, "2222", this.sistema.getInfoAjuda(1, "aluno"));
	}
	
	@Test
	public void testeGetInfoAjudaHorario() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é horario, ele retorna "
				+ "o horario da ajuda";
		assertEquals(msg, "15:00", this.sistema.getInfoAjuda(1, "horario"));
	}
	
	@Test
	public void testeGetInfoAjudaDia() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é dia, ele retorna "
				+ "o dia da ajuda";
		assertEquals(msg, "qua", this.sistema.getInfoAjuda(1, "dia"));
	}
	
	@Test
	public void testeGetInfoAjudaLocal() {
		this.sistema.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.sistema.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.sistema.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.sistema.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.sistema.tornarTutor("1111", "p2", 4);
		this.sistema.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é local, ele retorna "
				+ "o local da ajuda";
		assertEquals(msg, "biblioteca", this.sistema.getInfoAjuda(1, "localInteresse"));
	}
	
}

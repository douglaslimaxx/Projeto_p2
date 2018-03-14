package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Aluno;
import main.ControllerAjuda;

public class ControllerAjudaTest {

	private ControllerAjuda controller;
	private Aluno tutor;
		
	@Before
	public void setUp() {
		controller = new ControllerAjuda();
		tutor = new Aluno("Douglas", "1111", "douglas@mail.com", "9999", 2, 1);
		tutor.tornaTutor("p2", 4);
	}
	
	@Test
	public void testePedirAjudaPresencialMatriculaNula() {
		try {
			this.controller.pedirAjudaPresencial(null, "p2", tutor, "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialMatriculaVazia() {
		try {
			this.controller.pedirAjudaPresencial("   ", "p2", tutor, "15:00", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialMatriculaNaoCadastrada() {
		try {
			this.controller.pedirAjudaPresencial("111", "p2", tutor, "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: matricula nao cadastrada");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDisciplinaNula() {
		try {
			this.controller.pedirAjudaPresencial("1111", null, tutor, "15:00", "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDisciplinaVazia() {
		try {
			this.controller.pedirAjudaPresencial("1111", "    ", tutor, "15:00", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialHorarioNulo() {
		try {
			this.controller.pedirAjudaPresencial("1111", "p2", tutor, null, "seg", "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialHorarioVazio() {
		try {
			this.controller.pedirAjudaPresencial("111", "p2", tutor, "   ", "seg", "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDiaNulo() {
		try {
			this.controller.pedirAjudaPresencial("1111", "p2", tutor, "15:00", null, "LCC2");
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialDiaVazio() {
		try {
			this.controller.pedirAjudaPresencial("111", "p2", tutor, "15:00", null, "LCC2");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialLocalNulo() {
		try {
			this.controller.pedirAjudaPresencial("1111", "p2", tutor, "15:00", "seg", null);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialLocalVazio() {
		try {
			this.controller.pedirAjudaPresencial("1111", "p2", tutor, "15:00", "seg", "    ");
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaPresencialCorreta() {
		String msg = "O método pedirAjudaPresencial deve retornar o id da ajuda cadastrada";
		assertEquals(msg, 1, this.controller.pedirAjudaPresencial("1111", "discreta", tutor, "11:00", "seg", "biblioteca"));
	}
	
	
	@Test
	public void testePedirAjudaOnlineMatriculaNula() {
		try {
			this.controller.pedirAjudaOnline(null, "p2", tutor);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineMatriculaVazia() {
		try {
			this.controller.pedirAjudaOnline("   ", "p2", tutor);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineMatriculaNaoCadastrada() {
		try {
			this.controller.pedirAjudaOnline("111", "p2", tutor);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: matricula nao cadastrada");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineDisciplinaNula() {
		try {
			this.controller.pedirAjudaOnline("1111", null, tutor);
		} catch (RuntimeException mn) {
			assertEquals(mn.getMessage(), "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineDisciplinaVazia() {
		try {
			this.controller.pedirAjudaOnline("1111", "    ", tutor);
		} catch (RuntimeException mv) {
			assertEquals(mv.getMessage(), "Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testePedirAjudaOnlineCorreta() {
		String msg = "O método pedirAjudaOnline deve retornar o id da ajuda cadastrada";
		assertEquals(msg, 1, this.controller.pedirAjudaOnline("1111", "discreta", tutor));
	}
	
	@Test
	public void testePegarTutorIdAjudaZero() {
		try {
			this.controller.pegarTutor(0);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testePegarTutorIdAjudaMenorZero() {
		try {
			this.controller.pegarTutor(-1);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testePegarTutorIdAjudaNaoCadastrada() {
		try {
			this.controller.pegarTutor(1);
		} catch(RuntimeException idz) {
			assertEquals(idz.getMessage(), "Erro ao tentar recuperar tutor : id nao encontrado ");
		}
	}

	/**@Test
	public void testePegarTutorAjudaOnlineCorreto() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		String msg = "O método pegarTutor deve retornar as informacoes de tutoria"
				+ ", matricula e a disciplina do tutor";
		assertEquals(msg, "Tutor - 1111, disciplina - p2", this.controller.pegarTutor(1));
		
	}
	
	@Test
	public void testePegarTutorAjudaPresencialCorreto() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.cadastrarHorario("misscoisinha@poomail.com", "15:00", "ter");
		this.controller.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.controller.pedirAjudaPresencial("2222", "p2", "15:00", "ter", "biblioteca");
		String msg = "O método pegarTutor deve retornar as informacoes de tutoria"
				+ ", matricula, a disciplina, o horario, dia e local disponivel do tutor";
		assertEquals(msg, "Tutor - 1111, horario - 15:00, dia - ter, local - biblioteca, disciplina - p2", this.controller.pegarTutor(1));
		
	}*/
	
	@Test
	public void testeGetInfoAjudaIdZero() {
		try {
			this.controller.getInfoAjuda(0, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testeGetInfoAjudaIdMenorZero() {
		try {
			this.controller.getInfoAjuda(-1, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
	}
	
	@Test
	public void testeGetInfoAjudaIdNaoCadastrado() {
		try {
			this.controller.getInfoAjuda(1, "NOME");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
	}
	
	/**@Test
	public void testeGetInfoAjudaAtributoNulo() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		try {
			this.controller.getInfoAjuda(1, null);
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoVazio() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		try {
			this.controller.getInfoAjuda(1, "   ");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoNaoEncontrado() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		try {
			this.controller.getInfoAjuda(1, "ALTURA");
		} catch (RuntimeException iz) {
			assertEquals(iz.getMessage(), "Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
	
	@Test
	public void testeGetInfoAjudaAtributoTutor() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é tutor, ele retorna "
				+ "a representacao textual do tutor";
		assertEquals(msg, "1111 - Douglas - 2 - 9999 - misscoisinha@poomail.com", this.controller.getInfoAjuda(1, "tutor"));
	}
	
	@Test
	public void testeGetInfoAjudaAtributodisciplina() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é disciplina, ele retorna "
				+ "o nome da disciplina";
		assertEquals(msg, "p2", this.controller.getInfoAjuda(1, "disciplina"));
	}
	
	@Test
	public void testeGetInfoAjudaAluno() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaOnline("2222", "p2");
		String msg = "O metodo getInfoAjuda, quando o atributo é aluno, ele retorna "
				+ "a matricula do aluno";
		assertEquals(msg, "2222", this.controller.getInfoAjuda(1, "aluno"));
	}
	
	@Test
	public void testeGetInfoAjudaHorario() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.controller.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é horario, ele retorna "
				+ "o horario da ajuda";
		assertEquals(msg, "15:00", this.controller.getInfoAjuda(1, "horario"));
	}
	
	@Test
	public void testeGetInfoAjudaDia() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.controller.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é dia, ele retorna "
				+ "o dia da ajuda";
		assertEquals(msg, "qua", this.controller.getInfoAjuda(1, "dia"));
	}
	
	@Test
	public void testeGetInfoAjudaLocal() {
		this.controller.cadastrarAluno("Douglas", "1111", 2, "9999", "misscoisinha@poomail.com");
		this.controller.cadastrarAluno("Marcella", "2222", 2, "8888", "cella@poomail.com");
		this.controller.cadastrarHorario("misscoisinha@poomail.com", "15:00", "qua");
		this.controller.cadastrarLocalDeAtendimento("misscoisinha@poomail.com", "biblioteca");
		this.controller.tornarTutor("1111", "p2", 4);
		this.controller.pedirAjudaPresencial("2222", "p2", "15:00", "qua", "biblioteca");
		String msg = "O metodo getInfoAjuda, quando o atributo é local, ele retorna "
				+ "o local da ajuda";
		assertEquals(msg, "biblioteca", this.controller.getInfoAjuda(1, "localInteresse"));
	}*/
}

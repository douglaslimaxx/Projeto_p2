package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import main.Aluno;

public class AlunoTest {
	private Aluno Fulano;

	
	@Before
	public void setUp() {
		Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "3321-3456", 65, 14);
	}
	
	@Test
	public void testaNomeNulo() {
		try {
			Fulano = new Aluno(null, "117110", "florence@maquina.com", "3321-3456", 65, 14);  
		} catch (NullPointerException qw) {
			assertEquals(qw.getMessage(), "Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testaNomeVazio() {
		try {
			Fulano = new Aluno("    ", "117110", "florence@maquina.com", "3321-3456", 65, 14);
		} catch (NullPointerException he) {
			assertEquals(he.getMessage(), "Nome nao pode ser vazio ou nulo");
		}
	}
	
	@Test
	public void testaMatriculaNulo() {
		try {
			Fulano = new Aluno("Florence", null, "florence@maquina.com", "3321-3456", 65, 14);
		} catch (NullPointerException ri) {
			assertEquals(ri.getMessage(), "matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testaMatriculaVazia() {
		try {
			Fulano = new Aluno("Florence", "     ", "florence@maquina.com", "3321-3456", 65, 14);
		} catch (NullPointerException bn) {
			assertEquals(bn.getMessage(), "matricula nao pode ser vazia ou nula");
		}
	}
	
	@Test
	public void testaEmailNulo() {
		try {
			Fulano = new Aluno("Florence", "117110", null, "3321-3456", 65, 14);
		} catch (NullPointerException vi) {
			assertEquals(vi.getMessage(), "email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaEmailVazio() {
		try {
			Fulano = new Aluno("Florence", "117110", "     ", "3321-3456", 65, 14);
		} catch (IllegalArgumentException ur) {
			assertEquals(ur.getMessage(), "email nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaTelefoneNulo() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", null, 65, 14);
		} catch (NullPointerException pn) {
			assertEquals(pn.getMessage(), "telefone nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaTelefoneVazio() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "     ", 65, 14);
		} catch (IllegalArgumentException bx) {
			assertEquals(bx.getMessage(), "telefone nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCodigoZero() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "3321-3456", 0, 14);
		} catch (IllegalArgumentException gg) {
			assertEquals(gg.getMessage(), "codigo de curso nao pode ser zero ou negativo");
		}
	}
	
	@Test
	public void testaCodigoNegativo() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "3321-3456", -1, 14);
		} catch (IllegalArgumentException we) {
			assertEquals(we.getMessage(), "codigo de curso nao pode ser zero ou negativo");
		}
	}
	
	@Test
	public void testaCadastroZero() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "3321-3456", 65, 0);
		} catch (IllegalArgumentException cn) {
			assertEquals(cn.getMessage(), "cadastro nao pode ser zero ou negativo");
		}
	}
	
	@Test
	public void testaCadastroNegativo() {
		try {
			Fulano = new Aluno("Florence", "117110", "florence@maquina.com", "3321-3456", 65, -1);
		} catch (IllegalArgumentException lp) {
			assertEquals(lp.getMessage(), "cadastro nao pode ser zero ou negativo");
		}
	}
	
	@Test
	public void testaAdicionaDisciplinaNula() {
		try {
			Fulano.adicionaDisciplina(null, 2);
		} catch (NullPointerException ty) {
			assertEquals(ty.getMessage(), "disciplina nao pode ser vazia ou em branco");
		}
	}
	
	@Test
	public void testaAdicionaDisciplinaVazia() {
		try {
			Fulano.adicionaDisciplina("    ", 2);
		} catch (IllegalArgumentException pi) {
			assertEquals(pi.getMessage(), "disciplina nao pode ser vazia ou em branco");
		}
	}
	
	@Test
	public void testaConsultaHorarioNulo() {
		try {
			Fulano.consultaHorario(null, "seg");
		} catch (NullPointerException ij) {
			assertEquals(ij.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaConsultaHorarioVazio() {
		try {
			Fulano.consultaHorario("    ", "seg");
		} catch (IllegalArgumentException gh) {
			assertEquals(gh.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaConsultaDiaNulo() {
		try {
			Fulano.consultaHorario("9:00", null);
		} catch (NullPointerException lk) {
			assertEquals(lk.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaConsultaDiaVazio() {
		try {
			Fulano.consultaHorario("9:00", "    ");
		} catch (IllegalArgumentException ad) {
			assertEquals(ad.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaConsultaLocalNulo() {
		try {
			Fulano.consultaLocal(null);
		} catch (NullPointerException xl) {
			assertEquals(xl.getMessage(), "local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaConsultaLocalVazio() {
		try {
			Fulano.consultaLocal("     ");
		} catch (IllegalArgumentException so) {
			assertEquals(so.getMessage(), "local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraHorarioNulo() {
		try {
			Fulano.cadastrarHorario(null, "ter");
		} catch (NullPointerException sd) {
			assertEquals(sd.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraHorarioVazio() {
		try {
			Fulano.cadastrarHorario("    ", "ter");
		} catch (IllegalArgumentException pb) {
			assertEquals(pb.getMessage(), "horario nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraDiaNulo() {
		try {
			Fulano.cadastrarHorario("15:00", null);
		} catch (NullPointerException jk) {
			assertEquals(jk.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraDiaVazio() {
		try {
			Fulano.cadastrarHorario("15:00", "     ");
		} catch (IllegalArgumentException gt) {
			assertEquals(gt.getMessage(), "dia nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraLocalNulo() {
		try {
			Fulano.cadastrarLocalDeAtendimento(null);
		} catch (NullPointerException as) {
			assertEquals(as.getMessage(), "local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaCadastraLocalVazio() {
		try {
			Fulano.cadastrarLocalDeAtendimento("     ");
		} catch (IllegalArgumentException er) {
			assertEquals(er.getMessage(), "local nao pode ser vazio ou em branco");
		}
	}
	
	@Test
	public void testaTornaTutorNulo() {
		try {
			Fulano.tornaTutor(null, 2);
		} catch (NullPointerException gb) {
			assertEquals(gb.getMessage(), "disciplina nao pode ser vazia ou em branco");
		}
	}
	
	@Test
	public void testaTornaTutorVazio() {
		try {
			Fulano.tornaTutor("     ", 2);
		} catch (IllegalArgumentException hj) {
			assertEquals(hj.getMessage(), "disciplina nao pode ser vazia ou em branco");
		}
	}
	
	@Test
	public void testaDoarZero() {
		try {
			Fulano.doar(0);
		} catch (UnsupportedOperationException nm) {
			assertEquals(nm.getMessage(), "doacao nao pode ser zero ou negativa");
		}
	}
	
	@Test
	public void testaDoarNegativo() {
		try {
			Fulano.doar(-1);
		} catch (UnsupportedOperationException nm) {
			assertEquals(nm.getMessage(), "doacao nao pode ser zero ou negativa");
		}
	}
	
	@Test
	public void testaAdicionaProficienciaMenor() {
		try {
			Fulano.adicionaDisciplina("calculo", 0);
		} catch (IllegalArgumentException bi) {
			assertEquals(bi.getMessage(), "proficiencia invalida");
		}
	}
	
	@Test
	public void testaAdicionaProficienciaMaior() {
		try {
			Fulano.adicionaDisciplina("calculo", 6);
		} catch (IllegalArgumentException ka) {
			assertEquals(ka.getMessage(), "proficiencia invalida");
		}
	}
	
	@Test
	public void testaTornaProficienciaMenor() {
		try {
			Fulano.tornaTutor("prog", 0);
		} catch (IllegalArgumentException jh) {
			assertEquals(jh.getMessage(), "proficiencia invalida");
		}
	}
	
	@Test
	public void testaTornaProficienciaMaior() {
		try {
			Fulano.tornaTutor("prog", 6);
		} catch (IllegalArgumentException po) {
			assertEquals(po.getMessage(), "proficiencia invalida");
		}
	}
	
	
 
}

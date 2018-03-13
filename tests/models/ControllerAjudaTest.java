package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ajuda.ControllerAjuda;
import aluno.Aluno;

public class ControllerAjudaTest {

	private ControllerAjuda controller;
	private Aluno tutor;
	
	@Before
	public void setUp() {
		controller = new ControllerAjuda();
		tutor = new Aluno("Douglas", "1111", "douglas@mail.com", "9999", 2, 1);
		tutor.tornaTutor("p2", 4);
	}

	
}

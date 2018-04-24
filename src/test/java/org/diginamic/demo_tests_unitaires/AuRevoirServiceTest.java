package org.diginamic.demo_tests_unitaires;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.model.Pizza;
import pizzeria.services.AuRevoirService;

public class AuRevoirServiceTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Rule 
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC() {
		AuRevoirService auRevoirService = new AuRevoirService();
		IPizzaDao pizzaMemDao = new PizzaMemDao();

		systemInMock.provideLines();
		auRevoirService.executeUC(new Scanner(System.in), pizzaMemDao);
		assertEquals(systemOutRule.getLog(), "Au revoir\r\n");
	}

}

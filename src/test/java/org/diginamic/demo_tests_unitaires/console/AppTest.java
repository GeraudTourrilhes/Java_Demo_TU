package org.diginamic.demo_tests_unitaires.console;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertFalse;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;


import java.util.Scanner;

import org.diginamic.demo_tests_unitaires.exception.CalculException;
import org.diginamic.demo_tests_unitaires.service.CalculService;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class AppTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	private App app;
	
	private CalculService calculService;
	


	@Before
	public void setUp() throws Exception {

		this.calculService = mock(CalculService.class);
	
		this.app = new App(new Scanner(System.in), calculService);

	}

	//@Ignore
	@Test
	public void testAfficherTitre() throws Exception { 
		this.app.afficherTitre();

		String logConsole = systemOutRule.getLog();
	
		assertThat(logConsole).contains("**** Application Calculatrice ****");

	}
	
	//@Ignore
	@Test
	public void testEvaluer() throws Exception { 
		
		
		String expression = "3+4+5";
		when(this.calculService.additionner(expression)).thenReturn(12);
		this.app.evaluer(expression);
		
		verify(this.calculService).additionner(expression);
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("3+4+5=12");
		
		

	}
	
	//@Ignore
	@Test
	public void testEvaluerExpressionInvalide() throws Exception { 
		
		
		String expression = "3-4+5";
		when(this.calculService.additionner(expression)).thenThrow(new CalculException(expression));
		this.app.evaluer(expression);
		
		verify(this.calculService).additionner(expression);
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("L'expression " + expression +" est invalide.\r\n");
		
		

	}
	
	//@Ignore
	@Test
	public void testDemarrerAvecExpressionFin() throws Exception { 
		
		systemInMock.provideLines("fin");
		this.app = new App(new Scanner(System.in), calculService);
		this.app.demarrer();

		String logConsole = systemOutRule.getLog();
	
		assertThat(logConsole).contains("**** Application Calculatrice ****\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "Aurevoir :-(");


	}
	
	//@Ignore
	@Test
	public void testDemarrerAvecExpressionCalculPlusFin() throws Exception { 
		String expression = "1+2";
		systemInMock.provideLines(expression, "fin");
		this.app = new App(new Scanner(System.in), calculService);
		
		
		when(calculService.additionner(expression)).thenReturn(3);
		this.app.demarrer();
		
		verify(this.calculService).additionner(expression);
		
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("**** Application Calculatrice ****\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "1+2=3\r\nVeuillez saisir une expression :\r\n"
				+ "Aurevoir :-(");

	}
	
	@Test 
	public void testDemarrerAvecExpressionInvalidePlusFin() throws Exception { 
		String expression = "AAAA";
		systemInMock.provideLines(expression, "fin");
		this.app = new App(new Scanner(System.in), calculService);
		
		
		when(calculService.additionner(expression)).thenThrow(new CalculException(expression));
		this.app.demarrer();
		
		verify(this.calculService).additionner(expression);
		
		
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "L'expression " + expression + " est invalide.\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "Aurevoir :-(");

	}
	
	@Test
	public void testDemarrerAvecDeuxExpressionCalculPlusFin() throws Exception { 
		String expression1 = "1+2";
		String expression2 = "30+2";
		systemInMock.provideLines(expression1, expression2, "fin");
		this.app = new App(new Scanner(System.in), calculService);
		
		
		when(calculService.additionner(expression1)).thenReturn(3);
		when(calculService.additionner(expression2)).thenReturn(32);
		this.app.demarrer();
		
		verify(this.calculService).additionner(expression1);
		verify(this.calculService).additionner(expression2);
		
		
		String logConsole = systemOutRule.getLog();
		
		assertThat(logConsole).contains("**** Application Calculatrice ****\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "1+2=3\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "30+2=32\r\n"
				+ "Veuillez saisir une expression :\r\n"
				+ "Aurevoir :-(");

	}


}

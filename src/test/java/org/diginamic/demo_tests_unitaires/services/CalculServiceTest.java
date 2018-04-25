package org.diginamic.demo_tests_unitaires.services;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.diginamic.demo_tests_unitaires.exception.CalculException;
import org.diginamic.demo_tests_unitaires.service.CalculService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	
	@Test
	public void testAditionner() throws Exception {
		

		LOG.info("Etant donné, une instance de la classe CalculService");
		CalculService calculService = new CalculService();
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4"); 
		
		int somme = calculService.additionner("1+3+4");
		
		LOG.info("Alors j'obtiens le résultat 8");
		assertThat(somme).isEqualTo(8);
	}
	
	@Test (expected = CalculException.class)
	public void testAditionnerExpressionInvalide() throws Exception {
		

		LOG.info("Etant donné, une instance de la classe CalculService");
		CalculService calculService = new CalculService();
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1-3+4"); 
		LOG.info("Alors l'expression est invalide");
		calculService.additionner("1-3+4");
		
		
	}

}

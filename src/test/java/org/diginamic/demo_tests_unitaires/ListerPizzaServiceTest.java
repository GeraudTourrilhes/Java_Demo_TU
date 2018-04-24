package org.diginamic.demo_tests_unitaires;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.services.ListerPizzasService;

public class ListerPizzaServiceTest {

	
	@Rule 
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void test() {
		ListerPizzasService listerPizzaService = new ListerPizzasService();
		IPizzaDao pizzaMemDao = new PizzaMemDao();
		
		systemInMock.provideLines("CAMP", "Campagnarde", "500,00");
		listerPizzaService.executeUC(new Scanner(System.in), pizzaMemDao);
		
		assertTrue(true);
		

	}

}

package pizzeria;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.model.Pizza;
import pizzeria.services.AjouterPizzaService;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;


public class AjouterPizzaServiceTest {


	@Rule 
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC() {
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		IPizzaDao pizzaMemDao = new PizzaMemDao();
		
		systemInMock.provideLines("CAMP", "Campagnarde", "500,00");
		ajouterPizzaService.executeUC(new Scanner(System.in), pizzaMemDao);
		Pizza pizza = new Pizza("CAMP", "Campagnarde", 500.00);
		assertTrue(pizzaMemDao.findAllPizzas().contains(pizza));
		
		

	}

}

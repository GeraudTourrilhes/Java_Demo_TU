package pizzeria;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pizzeria.dao.PizzaMemDao;
import pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	private PizzaMemDao pizzaMemDao;
	
	@Before
	public void setUp()
	{
		 pizzaMemDao = new PizzaMemDao();
		
		
	}
	
	@Test
	public void testFindAllPizzas() {
		assertTrue(pizzaMemDao.findAllPizzas().size() == 8);
	}

	@Test
	public void testSaveNewPizza() {
		Pizza pizza = new Pizza("CAMP", "Campagnarde", 500);
		pizzaMemDao.saveNewPizza(pizza);
		assertTrue(pizzaMemDao.findAllPizzas().contains(pizza));

		
	}

	@Test
	public void testUpdatePizza() {
		Pizza pizza = new Pizza("CAMP", "Campagnarde", 500);
		pizzaMemDao.updatePizza("FRO", pizza);
		assertTrue(pizzaMemDao.findAllPizzas().contains(pizza));
	}

	@Test
	public void testDeletePizza() {
		String codePizza = pizzaMemDao.findAllPizzas().get(0).getCode();
		
		pizzaMemDao.deletePizza(codePizza);
		
		assertNotEquals(pizzaMemDao.findAllPizzas().get(0).getCode(),codePizza);
		
	}

	@Test
	public void testFindPizzaByCode() {
		assertEquals(pizzaMemDao.findAllPizzas().get(0), pizzaMemDao.findPizzaByCode("PEP"));
		
	}
	
	@Test
	public void testPizzaExists() {
		assertTrue(pizzaMemDao.pizzaExists("FRO"));
		
	}

}

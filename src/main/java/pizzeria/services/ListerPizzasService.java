package pizzeria.services;

import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("Lister les pizzas");
		for (Pizza pizza: dao.findAllPizzas()){
			System.out.println(pizza);
		}

	}

}

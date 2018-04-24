package pizzeria.services;

import java.util.Scanner;

import pizzeria.dao.IPizzaDao;

public class AuRevoirService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("Au revoir");
	}

}

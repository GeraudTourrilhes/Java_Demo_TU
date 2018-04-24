package pizzeria.services;

import java.util.Scanner;

import pizzeria.dao.IPizzaDao;

public abstract class MenuService {

	public abstract void executeUC(Scanner scanner, IPizzaDao dao);
}

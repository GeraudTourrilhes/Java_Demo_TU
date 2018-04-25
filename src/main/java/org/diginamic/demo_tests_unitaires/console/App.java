package org.diginamic.demo_tests_unitaires.console;

import java.util.Iterator;
import java.util.Scanner;

import org.diginamic.demo_tests_unitaires.exception.CalculException;
import org.diginamic.demo_tests_unitaires.service.CalculService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	private Scanner scanner;

	private CalculService calculatrice;
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	

	public App(Scanner scanner, CalculService calculatrice) { 
		this.scanner = scanner;

		this.calculatrice = calculatrice;

	}

	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");

	}

	public void demarrer() {

		
		afficherTitre();
		
		/*while (scanner.hasNext())
		{
			String expression = scanner.next();

			LOG.info("Veuillez saisir une expression :");
			if(expression.equals("fin"))
			{
				LOG.info("Aurevoir :-(");
			}
			else
			{
					evaluer(expression);
			
				
			}
		}*/
		
		LOG.info("Veuillez saisir une expression :");
		String expression = scanner.nextLine();
		while(!expression.equals("fin"))
		{
			evaluer(expression);
			LOG.info("Veuillez saisir une expression :");
			expression = scanner.nextLine();
		}
		LOG.info("Aurevoir :-(");
		
		
			
	}

	protected void evaluer(String expression) {
		try{
			int resultat =  this.calculatrice.additionner(expression);
			LOG.info(expression + "=" + resultat);
		}catch (CalculException e) {
			LOG.info(e.getMessage().toString());
		}
		

	}

}

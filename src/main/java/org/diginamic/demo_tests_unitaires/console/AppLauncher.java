package org.diginamic.demo_tests_unitaires.console;

import java.util.Scanner;

import org.diginamic.demo_tests_unitaires.service.CalculService;

public class AppLauncher {
	
	public static void main(String[] args) {

			try {
				Scanner scanner = new Scanner(System.in);
				
				new App(scanner, new CalculService()).demarrer();
	
			}catch (Exception e) {
				// TODO: handle exception
			}

		}

}

package org.diginamic.demo_tests_unitaires.service;

import org.diginamic.demo_tests_unitaires.exception.CalculException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);
	
	public int additionner(String expression)
	{
		int resultat = 0;
		String[] tableauString = expression.split("\\+");
		
		for (String string : tableauString) {
			try
			{
				
				resultat += Integer.parseInt(string);
				LOG.debug("Le résultat est " + resultat);

			}catch (Exception e){
				throw new CalculException(expression);
			}
		
		
			
			
		} 
			
		
		LOG.debug("Evaluation de l'expression " +  expression);
		return resultat;
	}

}

package org.diginamic.demo_tests_unitaires.exception;


public class CalculException extends RuntimeException{ 

	private String expression;
	
	  public CalculException(String expression){

	    //LOG.error("L'expression " + expression + " est invalide.");
		  this.expression = expression;

	  }
	  
	  public String getMessage()
	  {
		return "L'expression " + expression + " est invalide.";
		  
	  }
}

package org.diginamic.demo_tests_unitaires;

import org.junit.Test;

import junit.framework.TestCase;


public class AppTest extends TestCase
{
	@Test
    public void testLevenshte()
    {
		 CharSequence rhs = "Chien";
		    
			CharSequence lhs = "Chat";
			assertEquals(StringUtils.levenshteinDistance(lhs, rhs), 3);
			
			rhs = "Chat";
			    
			lhs = "Chien";
			assertEquals(StringUtils.levenshteinDistance(lhs, rhs), 3);
    }
    
	@Test
    public void testLevenshteMajuscule()
    {
        CharSequence rhs = "chat";
    
		CharSequence lhs = "Chat";
		assertEquals(StringUtils.levenshteinDistance(lhs, rhs), 1);
    }
    
	@Test
    public void testLevenshteCaractereSpeciaux()
    {
        CharSequence rhs = "ch@t!";
    
		CharSequence lhs = "ch@t ";
		assertEquals(StringUtils.levenshteinDistance(lhs, rhs), 1);
    }
    
	@Test
    public void testLevenshteVide()
    {
        CharSequence rhs = "";
    
		CharSequence lhs = "ch@t!";
		assertEquals(StringUtils.levenshteinDistance(lhs, rhs), 5);
    }
	
	@Test
    public void testLevenshteNull()
    {
        CharSequence rhs = null;
    
		CharSequence lhs = null;
		assertEquals(StringUtils.levenshteinDistance(lhs, rhs), -1);
    }
}

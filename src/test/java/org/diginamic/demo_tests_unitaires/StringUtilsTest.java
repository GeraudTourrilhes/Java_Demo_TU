package org.diginamic.demo_tests_unitaires;

import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilsTest 
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
		assertEquals(StringUtils.levenshteinDistance("", "ch@t!"), 5);
    }
	
	@Test
    public void testLevenshteNull()
    {

		assertEquals(StringUtils.levenshteinDistance(null, null), -1);
		assertEquals(StringUtils.levenshteinDistance("test", null), -1);
    }
}

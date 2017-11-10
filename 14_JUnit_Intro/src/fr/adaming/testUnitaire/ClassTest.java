package fr.adaming.testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassTest {

	@Test//sert à spécifier que testAssertion est une méthode de test
	public void testAssertion(){
		String str1 = new String("abc");
		String str2 = "abc";
		String str3 = null;
		
		int v1 = 6;
		int v2 = 5;
		
		String[] tab1 = {"un","deux","trois"};
		String[] tab2 = {"un","deux","trois"};
		String[] tab3 = tab2;
		
		//tester si v1 et v2 sont égaux
		//assertEquals(v1, v2);
		//assert(v1==v2);
		
		//assertNull(str3);
		
		//assertArrayEquals(tab1, tab2);
		
		//assertSame detérmine si les deux objets sont les mêmes
		
		assertSame(tab2,tab3);
	}
	//methodes test: pas de parametre, pas de retour
	@Test
	public void testMethode(){
		assertEquals(0, 0);
	}
}

package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.ICalculatriceService;

@RunWith(SpringJUnit4ClassRunner.class)// lancer cette classe test avec le runner de spring
@ContextConfiguration(locations="file:src/main/resources/application-context.xml")//localisation du fichier application-context
//Specifier le context spring pour l'injection des dependances lords de l'execution des tests
public class CalculatriceServiceTest {

	@Autowired
	private ICalculatriceService calService;
	
	@BeforeClass//Pour specifier que cette methode s'execute avant le chargment de la classe
	public static void setUpCalculatriceServiceTest(){
		System.out.println("----------BeforeClass----------");
	}
	
	@Before//Cette méthode s'exécute avant chaque test
	public void setUp(){
		System.out.println("----------Before----------");
	}
	
	@Test
	public void testAddition(){
		//on doit donner des objets à la méthode assertEquals, donc Long et pas long
		assertEquals(calService.addition(new Long(2), new Long(2)), new Long(4));
	}
	
	@Ignore
	@Test
	public void testLireSymbole(){
		//tester la méthode liresymbole
		assertEquals(new Character(' '),calService.lireSymbole());
	}
	
	@After//Cette méthode s'exécute après chaque test
	public void tearDown(){
		System.out.println("----------After----------");
	}
	
	@AfterClass// Cette méthode s'exécute après la destruction de l'objet CalcServTest
	public static void tearDownCalculatriceServiceTest(){
		System.out.println("----------AfterClass---------");
	}
}

package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.service.IBanqueService;

public class ClassTest {

	public static void main(String[] args) {
		
		//recuperation du contexte par application-context.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//Recuperation du bean banqueservice depuis le contexte
		//IBanqueService banqueService = (IBanqueService) context.getBean("banqueServiceBean");
		
		//System.out.println("Avant l'exécution de la méthode"); utilisation de syso standard mais pas très springy
		//System.out.println("A l'exécution: "+banqueService.retrait(100));
		//System.out.println("Après l'exécution de la méthode");
		
		//Meme chose, mais avec spring aop/tissage -application-context>proxy-
		
		IBanqueService banqueService = (IBanqueService) context.getBean("banqueProxyBean");
		System.out.println("A l'exécution: "+banqueService.retrait(100));

	}

}

package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.Developpeur;
import fr.adaming.beans.Societe;

public class ClassTest {

	public static void main(String[] args){
		//1 recuperation du contexte
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//2 recuperation du dev devBean à partir du contexte
		Developpeur dev = (Developpeur)context.getBean("devBean");
		
		Developpeur cdp = (Developpeur)context.getBean("cdpBean");
		System.out.println(dev);
		System.out.println(cdp);
		
		//3recuperation de la ssii contenant les deux beans précédents
		
		Societe ssii = (Societe)context.getBean("ssiiBean");
		System.out.println(ssii);
	}
}

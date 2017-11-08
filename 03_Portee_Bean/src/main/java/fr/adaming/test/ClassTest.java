package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.ClientService;

public class ClassTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		ClientService cServ1 = (ClientService) context.getBean("csBean");
		
		cServ1.setMessage("Bonjour Toto");
		
		System.out.println("Le message de cServ1: "+cServ1.getMessage());
		
		ClientService cServ2 = (ClientService)context.getBean("csBean");
		
		System.out.println("Le message de cServ2: "+cServ2.getMessage());
	}

}

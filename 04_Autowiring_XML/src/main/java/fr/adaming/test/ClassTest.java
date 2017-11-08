package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.Client;

public class ClassTest {

	public static void main(String[] args) {
		//recuperation du contexte
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//recuperation du bean client
		Client client = (Client) context.getBean("clientBean");
		System.out.println(client);
		
		Client client1 = (Client) context.getBean("clientBean1");
		System.out.println(client1);
	}

}

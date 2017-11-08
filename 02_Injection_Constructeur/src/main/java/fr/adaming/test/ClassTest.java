package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.User;

public class ClassTest {

	public static void main(String[] args) {
		
		//etape 1 recuperation du contexte
		ApplicationContext context = new ClassPathXmlApplicationContext("application_context.xml");
		
		//Recuperation de l'objet
		
		User user = (User) context.getBean("userBean");
		System.out.println(user);
		
		User user1 = (User) context.getBean("userBean1");
		System.out.println(user1);
		
		User user2 = (User) context.getBean("userBean2");
		System.out.println(user2);
		
	}

}

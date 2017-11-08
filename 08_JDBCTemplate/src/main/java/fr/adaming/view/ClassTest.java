package fr.adaming.view;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.model.Utilisateur;

public class ClassTest {

	public static void main(String[] args) {
		
		//1 recuperation du contexte Spring
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//2 recuperation de userDAO
		
		IUtilisateurDAO userDAO = (IUtilisateurDAO) context.getBean("userDAOBean");
		/*
		Utilisateur util1 = new Utilisateur("Toto", "Titi", "Toto@t", 25);
		Utilisateur util2 = new Utilisateur("Roro", "Riri", "Roro@t", 22);
		Utilisateur util3 = new Utilisateur("Fofo", "Fifi", "Fofo@t", 19);
		Utilisateur util4 = new Utilisateur("Yoyo", "Yiyi", "Yoyo@t", 29);

		//3 Ajouter les users dans la bdd
		
		userDAO.addUser(util1);
		userDAO.addUser(util2);
		userDAO.addUser(util3);
		userDAO.addUser(util4);
		*/
		
		Utilisateur outUser = userDAO.getUserById(3);
		System.out.println(outUser);
		
		//userDAO.deleteUser(2);
		Utilisateur modUser = userDAO.getUserById(3);
		modUser.setAge(99);
		userDAO.updateUser(modUser);
		
		
		List<Utilisateur> outUsers = userDAO.getAllUsers();
		System.out.println(outUsers);
		
	}

}

package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String deniedMethod(){
		return "deniedPage";
	}
	
	//Methode pour afficher le formulaire de login
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String afficherFormConnection(){
		return "loginPage";
	}
	
	//Methode pour afficher le message d'erreur si le login a echoue
	@RequestMapping(value="/loginEchec",method=RequestMethod.GET)
	public String afficheEchecLogin(ModelMap model){
		model.addAttribute("erreur", true);
		return "loginPage";
	}
	
	//la méthode pour se déconnecter et revenir vers accueil
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String seDeconnecter(){
		
		return "loginPage";
	}
	
}

package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/societe")
public class SocieteController {

	@RequestMapping(method=RequestMethod.GET)
	public String affichePageAccueil(){
		return "accueil";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="admin/pageAdmin")
	public String affichePageAdmin(ModelMap modele){
		modele.addAttribute("message", "Bonjour Mr Admin!");
		
		return "adminPage";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="employe/pageEmploye")
	public String affichePageEmploye(ModelMap modele){
		modele.addAttribute("message", "Bonjour Mr Employe!");
		
		return "employePage";
	}
}

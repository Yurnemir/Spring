package fr.adaming.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // permet de déclarer la classe comme une entité de traitement de
			// spring mvc
@RequestMapping("/monde") // mapping dispatcher permettant de relier les
							// requetes commencant avec /monde à ce controleur
public class MonController {

//	@RequestMapping(method = RequestMethod.GET) // cette annotation permet de
//												// spécifier la méthode http
//												// supportée
//	public ModelAndView disBonjour1() {
//		//L'objet modelandview contient l'identifiant de la page et le modele qui sera transféré lors de la réponse
//		return new ModelAndView("bonjour", "message", "Bonjour tout le Monde");
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String disBonjour1(Model model){
		
		//le model est l'équivalent du managedBean
		model.addAttribute("message", "Bonjour tout le Monde");//Fonctionnement équivalent au précédent
		
		return "bonjour";
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/salle" , "/adaming"})
	// l'attribut value permet de rajouter une URI relative pour cette méthode
	// (URI globale sera celle ci plus celle de la classe)
	// On peut rajouter plusieurs URI à la suite
	public String disBonjourSalle(Map<String, String> model) {

		model.put("message", "Bonjour la Salle!");

		return "bonjour";
	}
	
	//URL avec parametres
	@RequestMapping(method=RequestMethod.GET, value="/personne")//mapping comme précédemment, avec parametres en syntaxe standard
	public String disBonjourPersonne(ModelMap model, @RequestParam("pPrenom") String prenom){
		//ajout de l'annotation requestparam pour indiquer un parametre de la requete
		//Si le nom du parametre dans la requete est le meme que la variable de la méthode, pas besoin de @RequestParam (ie pas d'alias)
		
		model.addAttribute("message","Bonjour "+prenom+"!");
		
		return "bonjour";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/personne/{pPrenom}/{pNom}") //syntaxe templateparameter, RequestParam est remplacé par PathVariable
	public String disBonjourPersonne2(Model model, @PathVariable("pPrenom") String prenom, @PathVariable("pNom") String nom){
		
		model.addAttribute("message","Bonjour "+prenom+" "+nom+"!");
		
		return "bonjour";
	}
}

package fr.adaming.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Poney;

@Controller
@RequestMapping("/poney")
public class MonController {
	// La méthode qui sert à afficher le formulaire et lui associer un modele
	// (GET)
	@RequestMapping(method=RequestMethod.GET, value="/afficheForm")
	public String afficherForm(Model model){
		// ajouter un poney vide dans le modele qui sera utilisé dans la page
		model.addAttribute("formPoney", new Poney());
		
		return "poneyForm";
	}
	
	//la méthode qui traite le formulaire soumis
	@RequestMapping(method=RequestMethod.POST, value="/soumettreForm")
	public String soumissionForm(ModelMap model,@Valid @ModelAttribute("formPoney") Poney poney, BindingResult result){
		//@ModelAttribute uniquement nécessaire si poney n'a pas le même nom
		//bindingresult: objet responsable de transporter les messages d'erreur dans les pages jsp
		
		if (result.hasErrors()){
			return "poneyForm";
		}
		System.out.println(poney);
		
		return "resultForm";
	}
	
	
	
}

package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;
import fr.adaming.service.IEtudiantService;

@Controller
@RequestMapping("/etudiant")
public class TestControleur {
	
	//Injection de la dépendance service
	@Autowired
	private IEtudiantService etuService;
	
	public void setEtuService(IEtudiantService etuService) {
		this.etuService = etuService;
	}

	private Formateur f;//remplacé par la suite (Spring security)
	@PostConstruct
	public void inti(){
		this.f = new Formateur(1,"form@eur","formateur");
	}
			
			
	@RequestMapping(method=RequestMethod.GET,value="/listeEtudiants")
	public ModelAndView afficherEtudiants(){
		
		List<Etudiant> listeEtudiants = etuService.getAllEtudiants(f);
		
		return new ModelAndView("accueil","listeEtudiants",listeEtudiants);
		
	}
	
	//Les méthodes du formulaire ajouter
	
	@RequestMapping(value="/afficheAjout", method=RequestMethod.GET) //Get car on va juste afficher le form
	public ModelAndView afficheFormAjout(){
		//"ajout": identifiant de la page ajout.jsp utilisé par le resolver
		return new ModelAndView("ajout","etudiantAjout",new Etudiant());
	}
	
	@RequestMapping(value="/insereEtudiant", method=RequestMethod.POST)
	public String soumettreFormAjout(Model modele,@ModelAttribute("etudiantAjout") Etudiant etudiant){
		System.out.println(etudiant.getNom());
		Etudiant eOut = etuService.ajoutEtudiant(etudiant, f);
		
		if(eOut.getId()!=0){
			List<Etudiant> listeEtudiants = etuService.getAllEtudiants(f);
			modele.addAttribute("listeEtudiants", listeEtudiants);
			return "accueil";
		} else {
			return "redirect:afficheAjout";
		}
	}
	
	//Methodes du formulaire supprimer
	
	@RequestMapping(value="/afficheSuppr", method=RequestMethod.GET)
	public ModelAndView afficheFormSuppr(){
		return new ModelAndView("suppression","etudiantSuppr",new Etudiant());
	}
	
	@RequestMapping(value="/supprimerEtudiant", method=RequestMethod.POST)
	public String soumettreFormSuppr(ModelMap model, RedirectAttributes redirAttr, Etudiant etudiant){
		Etudiant delEtudiant = etuService.deleteEtudiant(etudiant, f);
		
		if (delEtudiant != null){
			List<Etudiant> liste = etuService.getAllEtudiants(f);
			model.addAttribute("listeEtudiants",liste);
			return "accueil";
		} else {
			redirAttr.addFlashAttribute("message","L'étudiant n'a pas été supprimé");
			return "redirect:afficheSuppr";
		}
	}
	
	@RequestMapping(value="/supprimeViaLien/{pId}", method=RequestMethod.GET)
	public String supprViaLien(ModelMap model, @PathVariable("pId") int id){
		Etudiant delEtudiant = new Etudiant();
		delEtudiant.setId(id);
		etuService.deleteEtudiant(delEtudiant, this.f);
		
		List<Etudiant> liste = etuService.getAllEtudiants(f);
		model.addAttribute("listeEtudiants",liste);
		return "accueil";
		
	}
	
	//Methodes du formulaire de modification
	
	@RequestMapping(value="/afficheModif", method=RequestMethod.GET)
	public String afficheFormModif(ModelMap model){
		
		model.addAttribute("etudiantModif", new Etudiant());
		return "modification";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/modifierEtudiant")
	public String soumettreFormModif(RedirectAttributes redirectAttrib, ModelMap modele,@ModelAttribute("etudiantModif") Etudiant etudiant){
		Etudiant outEtudiant = etuService.modifEtudiant(etudiant, f);
		System.out.println(outEtudiant+" "+outEtudiant.getFormateur());
		if(outEtudiant!=null){
			List<Etudiant> liste = etuService.getAllEtudiants(f);
			modele.addAttribute("listeEtudiants", liste);
			return "accueil";
		} else {

			redirectAttrib.addFlashAttribute("message","L'étudiant n'a pas été modifié");
			return "redirect:afficheModif";

		}
	}
	
	@RequestMapping(value="/modifViaLien")
	public String afficheFormModifViaLien(Model model, @RequestParam("pId") int id){
		Etudiant e = new Etudiant();
		e.setId(id);
		Etudiant outEtudiant = etuService.getEtudiantById(e, f);
		
		model.addAttribute("etudiantModif",outEtudiant);
		
		return "modification";
	}
	
}

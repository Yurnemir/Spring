package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;
import fr.adaming.service.IEtudiantService;
import fr.adaming.service.IFormateurService;

@ManagedBean(name = "fMB")
@RequestScoped
public class FormateurManagedBean implements Serializable {

	// dectalartion et injection des dependences
	@ManagedProperty(value = "#{fService}") // injection dependence en utilisant
											// l'annotation JFS
	private IFormateurService formateurService;

	@ManagedProperty(value = "#{eService}")
	private IEtudiantService etudiantService;

	// declaration des attribut vue dans la page xhtml
	private Formateur formateur;

	public FormateurManagedBean() {
		this.formateur = new Formateur();
	}

	// le setter pour l'injection de dependances
	public void setFormateurService(IFormateurService formateurService) {
		this.formateurService = formateurService;
	}

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public String seConnecter() {

		// appel de la methode service
		Formateur fOut = formateurService.isExist(this.formateur);

		if (fOut != null) {
			// stockage du formateur trouv� dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("fSession", fOut);

			// recuperation de la liste des etudiants du formateur trouv�
			List<Etudiant> listeEtudiants = etudiantService.getAllEtudiants(fOut);

			// stockage du formateur trouv� dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeEtudiants",
					listeEtudiants);

			return "succes";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'id ou mdp erron�(s)"));

			return "echec";
		}

	}

}

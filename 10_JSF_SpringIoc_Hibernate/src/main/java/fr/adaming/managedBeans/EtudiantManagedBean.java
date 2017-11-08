package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;
import fr.adaming.service.IEtudiantService;

@ManagedBean(name="etuMB")
@RequestScoped
public class EtudiantManagedBean implements Serializable {

	@ManagedProperty(value="#{eService}")
	private IEtudiantService etuService;
	
	private Etudiant etudiant;
	private Formateur formateur;
	
	private List<Etudiant> listeEtudiants;
	
	private HttpSession session;
	
	@PostConstruct
	public void init(){
		etudiant = new Etudiant();
		
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		if(session!=null){
			listeEtudiants = (List<Etudiant>) session.getAttribute("listeEtudiants");
			formateur = (Formateur) session.getAttribute("fSession");
		}
	}

	public void setEtuService(IEtudiantService etuService) {
		this.etuService = etuService;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
	
	public String ajoutEtudiant(){
		if(etudiant != null){
			Etudiant outEtudiant = etuService.ajoutEtudiant(etudiant,formateur); //TODO le reste!
			if(outEtudiant.getId()!=0){
				List<Etudiant> listeEtudiants = etuService.getAllEtudiants(formateur);
				session.setAttribute("listeEtudiants", listeEtudiants);
				return "accueil";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible d'ajouter l'étudiant"));
				return "ajoutEtudiant";
			}
		}
		return "ajoutEtudiant";
	}
	
	public String supprEtudiant(){
		if(etudiant != null){
			boolean verif = etuService.supprEtudiant(etudiant,formateur); //TODO le reste!
			if(verif){
				List<Etudiant> listeEtudiants = etuService.getAllEtudiants(formateur);
				session.setAttribute("listeEtudiants", listeEtudiants);
				return "accueil";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de supprimer l'étudiant"));
				return "supprEtudiant";
			}
		}
		return "supprEtudiant";
	}
	
	public String getEtudiantById(){
		if(etudiant != null){
			Etudiant outEtudiant = etuService.getEtudiantById(etudiant,formateur); //TODO le reste!
			if(outEtudiant!=null){
				List<Etudiant> listeEtudiants = etuService.getAllEtudiants(formateur);
				session.setAttribute("listeEtudiants", listeEtudiants);
				return "accueil";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Impossible de trouver l'étudiant"));
				return "getEtudiant";
			}
		}
		return "getEtudiant";
	}
	
	public String modifEtudiant(){
		return null;
	}
	
}

package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

public interface IEtudiantService {
	public List<Etudiant> getAllEtudiants(Formateur f);
	
	public Etudiant ajoutEtudiant(Etudiant e, Formateur f);
	
	public Etudiant modifEtudiant(Etudiant e, Formateur f);
	
	public Etudiant getEtudiantById(Etudiant e, Formateur f);
	
	public Etudiant deleteEtudiant(Etudiant e, Formateur f);
}

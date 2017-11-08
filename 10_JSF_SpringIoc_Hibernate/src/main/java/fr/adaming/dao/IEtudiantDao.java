package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

public interface IEtudiantDao {
 
	public List<Etudiant> getAllEtudiants(Formateur f);

	public Etudiant ajoutEtudiant(Etudiant e);
	
	public boolean supprEtudiant(Etudiant e);
	
	public Etudiant getEtudiantById(Etudiant e);
	
	public Etudiant modifEtudiant(Etudiant e);
}

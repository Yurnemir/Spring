package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDAO;
import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	@Autowired
	private IEtudiantDAO etuDAO;

	@Override
	public List<Etudiant> getAllEtudiants(Formateur f) {
		return etuDAO.getAllEtudiants(f);
	}

	@Override
	public Etudiant ajoutEtudiant(Etudiant e, Formateur f) {
		e.setFormateur(f);
		return etuDAO.ajoutEtudiant(e);
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e, Formateur f) {
		Etudiant outEtudiant = etuDAO.getEtudiantById(e);
		System.out.println(outEtudiant+" "+e);
		if(outEtudiant!=null){
			if(outEtudiant.getFormateur().getId() == f.getId()){
				e.setFormateur(f);
				return etuDAO.modifEtudiant(e);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Etudiant getEtudiantById(Etudiant e, Formateur f) {
		Etudiant outEtudiant = etuDAO.getEtudiantById(e);
		if(outEtudiant!=null){
			if(outEtudiant.getFormateur().getId() == f.getId()){
				return outEtudiant;
			} else {
				return null;
			}	
		} else {
			return null;
		}
	}

	@Override
	public Etudiant deleteEtudiant(Etudiant e, Formateur f) {
		Etudiant outEtudiant = etuDAO.getEtudiantById(e);
		if(outEtudiant!=null){
			if(outEtudiant.getFormateur().getId() == f.getId()){
				etuDAO.deleteEtudiant(outEtudiant);
				return outEtudiant;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	

}

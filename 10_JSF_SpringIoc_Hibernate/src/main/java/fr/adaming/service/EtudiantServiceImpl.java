package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

@Service("eService")
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	@Autowired
	private IEtudiantDao etudiantDao;
	
	@Override
	public Etudiant ajoutEtudiant(Etudiant e, Formateur f) {
		e.setFormateur(f);
		return etudiantDao.ajoutEtudiant(e);
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e, Formateur f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant getEtudiantById(Etudiant e, Formateur f) {
		if(e.getFormateur().getId()==f.getId()){
			return etudiantDao.getEtudiantById(e);
		} else {
			return null;
		}
	}

	@Override
	public boolean supprEtudiant(Etudiant e, Formateur f) {
		if(e.getFormateur().getId()==f.getId()){
			return etudiantDao.supprEtudiant(e);
		} else {
		return false;
		}
	}

	public void setEtudiantDao(IEtudiantDao etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	@Override
	public List<Etudiant> getAllEtudiants(Formateur f) {
		return etudiantDao.getAllEtudiants(f);
	}

}

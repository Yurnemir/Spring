package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

@Repository
public class EtudiantDAOImpl implements IEtudiantDAO {

	@Autowired
	private SessionFactory sf;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiants(Formateur f) {
		String req = "FROM Etudiant e where e.formateur.id=:pIdF";
		Query query = sf.getCurrentSession().createQuery(req);
		query.setParameter("pIdF", f.getId());
		
		return (List<Etudiant>)query.list();
	}


	@Override
	public Etudiant ajoutEtudiant(Etudiant e) {
		
		sf.getCurrentSession().save(e);
		return e;
	}


	@Override
	public Etudiant modifEtudiant(Etudiant e) {
		System.out.println(e+"avant modif");
		sf.getCurrentSession().merge(e);
		System.out.println(e+"après modif");
		return e;
	}

	public Etudiant getEtudiantById(Etudiant e){
		return (Etudiant) sf.getCurrentSession().get(Etudiant.class, e.getId());
	}
	
	public void deleteEtudiant(Etudiant e){
		sf.getCurrentSession().delete(getEtudiantById(e));
	}
}

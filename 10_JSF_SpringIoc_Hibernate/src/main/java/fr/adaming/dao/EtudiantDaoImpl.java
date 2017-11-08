package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;

@Repository
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Etudiant> getAllEtudiants(Formateur f) {
		Session s=sf.getCurrentSession();
		// La requete HQL
		String req="FROM Etudiant e WHERE e.formateur.id=:pIdf";
		
		// recup d'un query
		Query query=s.createQuery(req);
		
		// passage des params
		query.setParameter("pIdf", f.getId());
		
		// envoi de la req et recup du resultat
		@SuppressWarnings("unchecked")
		List<Etudiant> liste=query.list();
		
		return liste;
	}

	@Override
	public Etudiant ajoutEtudiant(Etudiant e) {
		Session s=sf.getCurrentSession();
		s.save(e);
		return e;
	}

	@Override
	public boolean supprEtudiant(Etudiant e) {
		
		Session s = sf.getCurrentSession();
		
		String req = "DELETE FROM Etudiant e WHERE e.id=:pId and e.formateur.id=:pIdFormateur";
		
		Query query = s.createQuery(req);
		query.setParameter(0, e.getId());
		query.setParameter(1, e.getFormateur().getId());
		
		int verif = query.executeUpdate();
		
		if(verif!=0){
			return true;
		} else {
			return false;
		}
	}
	
	public Etudiant getEtudiantById(Etudiant e){
		Session s = sf.getCurrentSession();
		String request = "FROM Etudiant e WHERE e.id=:pId AND e.formateur.id=:pIdf";
		
		Query query = s.createQuery(request);
		query.setParameter("pId", e.getId());
		query.setParameter("pIdf", e.getFormateur().getId());
		
		Etudiant outEtu = (Etudiant)query.list().get(0);
		
		if(outEtu!=null){
			return outEtu;
		} else {
			return null;
		}
		
	}

	@Override
	public Etudiant modifEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return null;
	}

}

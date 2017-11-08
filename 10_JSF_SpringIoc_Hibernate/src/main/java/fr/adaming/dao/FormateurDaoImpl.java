package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Formateur;


@Repository // anotation pour la declaration du bean 
public class FormateurDaoImpl implements IFormateurDao {

	@Autowired // injection autmaiqtie du colaborateur sessionFactoryBean
	private SessionFactory sf;

	// le setter pour l'injection
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Formateur isExist(Formateur f) {
		// recuperation de la session
		Session s=sf.getCurrentSession();
		
		// la requete HQL
		String req="FROM Formateur f WHERE f.mail=:pMail AND f.passowrd=:pMdp";
		
		// creer un objet query
		Query query=s.createQuery(req);
		
		// passage des params
		query.setParameter("pMail", f.getMail());
		query.setParameter("pMdp", f.getPassowrd());
		
		
		// envoyer la requete et recup du resultat
		Formateur fOut=(Formateur) query.uniqueResult();
		
		
		return fOut;
	}

}

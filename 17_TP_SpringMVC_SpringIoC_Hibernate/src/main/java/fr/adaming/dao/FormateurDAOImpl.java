package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Formateur;

@Repository
public class FormateurDAOImpl implements IFormateurDAO {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Formateur getFormateurByMail(String mail) {
		String requete = "FROM Formateur f WHERE f.mail=:pMail";
		
		Query query = sf.getCurrentSession().createQuery(requete);
		query.setParameter("pMail", mail);
		
		return (Formateur) query.uniqueResult();
	}

}

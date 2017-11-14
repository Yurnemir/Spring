package fr.adaming.dao;

import fr.adaming.model.Formateur;

public interface IFormateurDAO {

	public Formateur getFormateurByMail(String mail);
}

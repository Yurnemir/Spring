package fr.adaming.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("clientBean")
public class Client implements Serializable {

	@Value(value="#{'toto'.toUpperCase()}")// pour l'injection de valeur à l'initialisation
	private String nom;
	
	@Value("#{adresseBean.adresseComplete()}")
	private String adresse;

	public Client() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
}

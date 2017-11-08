package fr.adaming.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("clientBean")
public class Client implements Serializable {

	@Value(value="Titi")// pour l'injection de valeur à l'initialisation
	private String nom;
	
	@Autowired(required=false) // pour l'injection automatique sans passer par l'annotation autowire dans application-context
	//@Qualifier("adresse1")			//utilise le mode byType par défaut
	private Adresse adresse;

	public Client() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
}

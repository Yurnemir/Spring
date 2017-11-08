package fr.adaming.beans;

import java.io.Serializable;

public class Client implements Serializable {

	private String nom;
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

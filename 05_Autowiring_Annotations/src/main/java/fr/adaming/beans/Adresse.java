package fr.adaming.beans;

import java.io.Serializable;

public class Adresse implements Serializable{
	private String adresseComplete;

	public Adresse() {
		super();
	}

	public String getAdresseComplete() {
		return adresseComplete;
	}

	public void setAdresseComplete(String adresseComplete) {
		this.adresseComplete = adresseComplete;
	}

	@Override
	public String toString() {
		return "Adresse [adresseComplete=" + adresseComplete + "]";
	}
	
	
}

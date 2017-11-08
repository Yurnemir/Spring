package fr.adaming.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("adresseBean") //déclare un bean de spring de maniere generale, avec un alias
public class Adresse implements Serializable{
	@Value("Rue Alexandre Dumas")
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

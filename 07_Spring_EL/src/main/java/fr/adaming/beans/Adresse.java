package fr.adaming.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("adresseBean") //déclare un bean de spring de maniere generale, avec un alias
public class Adresse implements Serializable{
	@Value("Nantes")
	private String ville;
	@Value("Place Royale")
	private String rue;
	
	public Adresse() {
		super();
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Override
	public String toString() {
		return "Adresse [ville=" + ville + ", rue=" + rue + "]";
	}
	
	public String adresseComplete(){
		return this.rue +", "+ this.ville;
	}
}

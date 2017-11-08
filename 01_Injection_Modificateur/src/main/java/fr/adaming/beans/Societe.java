package fr.adaming.beans;

import java.io.Serializable;

public class Societe implements Serializable{
	
	private String nom;
	private Developpeur developer;
	private Developpeur chefDeProjet;
	
	public Societe(){
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Developpeur getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developpeur developer) {
		this.developer = developer;
	}

	public Developpeur getChefDeProjet() {
		return chefDeProjet;
	}

	public void setChefDeProjet(Developpeur chefDeProjet) {
		this.chefDeProjet = chefDeProjet;
	}

	@Override
	public String toString() {
		return "Societe [nom=" + nom + ", developer=" + developer + ", chefDeProjet=" + chefDeProjet + "]";
	}
	
	

}

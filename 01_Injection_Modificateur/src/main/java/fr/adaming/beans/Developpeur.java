package fr.adaming.beans;

import java.io.Serializable;


public class Developpeur implements Serializable{

	private String nom;
	private int experience;
	
	public Developpeur(){
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Developpeur [nom=" + nom + ", experience=" + experience + "]";
	}
	
	
	
}

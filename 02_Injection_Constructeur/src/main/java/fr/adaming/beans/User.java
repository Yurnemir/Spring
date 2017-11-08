package fr.adaming.beans;

import java.io.Serializable;

public class User implements Serializable {
	
	private String nom;
	private String prenom;
	private int age;
	private double salaire;
	
	
	public User(String nom, String prenom, int age, double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.salaire = salaire;
	}


	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", salaire=" + salaire + "]";
	}

}

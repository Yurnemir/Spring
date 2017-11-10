package fr.adaming.model;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Poney {

	@NotEmpty(message="le champ doit etre rempli")
	private String nom;
	@NotEmpty(message="le champ doit etre rempli")
	private String couleur;
	@Range(min=0,max=25)
	private int age;
	@Max(value=200)
	private double taille;
	
	public Poney() {
		super();
	}
	
	public Poney(String nom, String couleur, int age, double taille) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.age = age;
		this.taille = taille;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getTaille() {
		return taille;
	}
	
	public void setTaille(double taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Poney [nom=" + nom + ", couleur=" + couleur + ", age=" + age + ", taille=" + taille + "]";
	}
	
	
	
}

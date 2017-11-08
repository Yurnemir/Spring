package fr.adaming.model;

import java.io.Serializable;

public class Utilisateur implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private int age;
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String nom, String prenom, String mail, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.age = age;
	}
	
	public Utilisateur(int id, String nom, String prenom, String mail, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", age=" + age
				+ "]";
	}
	
	
	
}

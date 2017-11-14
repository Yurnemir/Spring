package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="formateurs")
public class Formateur implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_f")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String mail;
	private String mdp;
	private boolean active;
	
	@OneToMany(mappedBy="formateur")
	private List<Etudiant> listeEtudiants;
	
	@OneToMany(mappedBy="formateur")
	private List<Role> roles;
	
	public Formateur() {
		super();
	}
	public Formateur(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}
	public Formateur(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}
	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Formateur [id=" + id + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	
	
	
}

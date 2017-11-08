package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Utilisateur;

public interface IUtilisateurDAO {

	public void addUser(Utilisateur u);
	
	public List<Utilisateur> getAllUsers();
	
	public Utilisateur getUserById(int id);
	
	public void updateUser(Utilisateur u);
	
	public void deleteUser(int id);
}

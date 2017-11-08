package fr.adaming.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import fr.adaming.model.Utilisateur;

public class UtilisateurDAOImpl extends JdbcDaoSupport implements IUtilisateurDAO {

	public void addUser(Utilisateur u) {
		String req = "INSERT INTO users (nom_u,prenom_u,mail_u,age_u) values(?,?,?,?)";
		
		this.getJdbcTemplate().update(req, new Object[]{u.getNom(),u.getPrenom(),u.getMail(),u.getAge()});
	}

	public List<Utilisateur> getAllUsers() {
		String req = "SELECT * FROM users";
		
		List<Utilisateur> result = this.getJdbcTemplate().query(req, new UtilisateurRowMapper());
		
		return result;
	}

	public Utilisateur getUserById(int id) {
		String req = "SELECT * FROM users WHERE id_u=?";
		
		Utilisateur user = this.getJdbcTemplate().queryForObject(req, new Object[]{id}, new UtilisateurRowMapper());
		
		return user;
	}

	public void updateUser(Utilisateur u) {
		String req = "UPDATE users SET nom_u=?,prenom_u=?,mail_u=?,age_u=? where id_u=?";
		
		this.getJdbcTemplate().update(req,new Object[]{u.getNom(),u.getPrenom(),u.getMail(),u.getAge(),u.getId()});
	}

	public void deleteUser(int id) {
		String req = "DELETE FROM users WHERE id_u=?";
		
		this.getJdbcTemplate().update(req, new Object[]{id});
		
	}

}

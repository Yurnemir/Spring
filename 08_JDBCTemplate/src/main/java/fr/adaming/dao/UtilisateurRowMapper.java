package fr.adaming.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.adaming.model.Utilisateur;

public class UtilisateurRowMapper implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet rs, int numeroLigne) throws SQLException {
		Utilisateur u = new Utilisateur(rs.getInt("id_u"),
										rs.getString("nom_u"),
										rs.getString("prenom_u"),
										rs.getString("mail_u"),
										rs.getInt("age_u"));
		return u;
	}

	
	
}

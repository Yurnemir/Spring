package fr.adaming.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.adaming.model.Utilisateur;

public class UtilisateurDAOImpl implements IUtilisateurDAO {
	
	private DataSource ds;
	private JdbcTemplate jt;
	//Setter pour l'injection de dépendance
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void addUser(Utilisateur u) {
		// 1 Creation de la requete SQL
		String req = "INSERT INTO users (nom_u,prenom_u,mail_u,age_u) values (?,?,?,?)";
		
		//Instanciation de jdbcTemplate
		jt = new JdbcTemplate(ds);
		
		//envoie de la requete, update renvoie l'int du nombre de lignes modifiées
		jt.update(req, new Object[]{u.getNom(),u.getPrenom(),u.getMail(),u.getAge()});
		
		//jt.getDataSource().getConnection().close();
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		//1 creation de la requete SQL
		
		String req = "SELECT * FROM users";
		
		//Instanciation de jdbctemplate
		jt=new JdbcTemplate(ds);
		
		
		
		//List<Map<String, Object>> lignes = jt.queryForList(req);
		
		
		//List<Utilisateur> liste = new ArrayList<Utilisateur>();
		
		/*for(Map<String,Object> ligne: lignes){
			Utilisateur user = new Utilisateur(	(int) ligne.get("id_u"),
												(String) ligne.get("nom_u"),
												(String) ligne.get("prenom_u"),
												(String) ligne.get("mail_u"),
												(int) ligne.get("age_u")
												);
			liste.add(user);
		}*/
		
		List<Utilisateur> result = jt.query(req, new UtilisateurRowMapper());
		

		return result;
	}

	@Override
	public Utilisateur getUserById(int id) {
		//1 creation de la requete SQL
		
		String req = "SELECT * FROM users WHERE id_u=?";
		
		//Instanciation de jdbctemplate
		jt=new JdbcTemplate(ds);
		
		//Utilisateur result = jt.queryForObject(req, new Object[]{id}, Utilisateur.class);
		Map<String,Object> ligne = jt.queryForMap(req, new Object[]{id});
		
		/*Utilisateur user = new Utilisateur(	(int) ligne.get("id_u"),
												(String) ligne.get("nom_u"),
												(String) ligne.get("prenom_u"),
												(String) ligne.get("mail_u"),
												(int) ligne.get("age_u")
												);
		*/
		Utilisateur user = jt.queryForObject(req, new Object[]{id}, new UtilisateurRowMapper());
		
		return user;
	}

	@Override
	public void updateUser(Utilisateur u) {
		String req = "UPDATE users SET nom_u=?,prenom_u=?,mail_u=?,age_u=? where id_u=?";
		
		jt = new JdbcTemplate(ds);
		
		jt.update(req,new Object[]{u.getNom(),u.getPrenom(),u.getMail(),u.getAge(),u.getId()});
	}

	@Override
	public void deleteUser(int id) {
		//1 creation de la requete
		String req = "DELETE FROM users WHERE id_u=?";
		
		//instanciation du jdbctemplate
		jt=new JdbcTemplate(ds);
		
		jt.update(req, new Object[]{id});
		
	}

}

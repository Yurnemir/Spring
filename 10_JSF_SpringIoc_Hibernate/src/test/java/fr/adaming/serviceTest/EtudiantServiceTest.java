package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Etudiant;
import fr.adaming.model.Formateur;
import fr.adaming.service.IEtudiantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class EtudiantServiceTest {

	//injection de la dépendance etudiantService
	@Autowired
	private IEtudiantService etudiantService;
	private Formateur f;
	private Etudiant e;
	
	@Before
	public void setUp(){
		f = new Formateur(1, "k@k", "k");
	}
	
	@Test
	public void testGetAllEtudiants(){
		int nombreAttendu = 1;
		f = new Formateur(1, "k@k", "k");
		assertEquals(nombreAttendu,etudiantService.getAllEtudiants(f).size());
	}
	
	@Test
	public void testGetAllEtudiants1(){
		String resultatAttendu = "Alix";
		//Test du premier element de la liste
		assertEquals(resultatAttendu, etudiantService.getAllEtudiants(f).get(0).getNom());
	}
	
	@Test
	public void testGetEtudiantById(){
		Etudiant knownEtudiant = new Etudiant();
		knownEtudiant.setId(1);
		knownEtudiant.setFormateur(f);
		assertEquals("Alix", etudiantService.getEtudiantById(knownEtudiant, f).getNom());
	}
	
	@Test
	@Transactional //pour rendre la methode de test transactionelle
	@Rollback(true)//Annuler la transaction après l'exécution de cette méthode
	public void testAddEtudiant(){
		Etudiant e=new Etudiant("TEST","Test",new Date(1988-10-22));
		
		//Recuperer la liste avant l'ajout
		int tailleInit = etudiantService.getAllEtudiants(f).size();
		
		etudiantService.ajoutEtudiant(e, f);
		
		assertEquals(tailleInit+1,etudiantService.getAllEtudiants(f).size());
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifEtudiant(){
		Etudiant etudiantInit = etudiantService.getAllEtudiants(f).get(0);
		String nomInit = new String(etudiantInit.getNom());
		nomInit.concat("test");
		etudiantInit.setNom(nomInit);
		assertEquals(nomInit,etudiantService.modifEtudiant(etudiantInit, f).getNom());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSupprEtudiant(){
		Etudiant e=etudiantService.getAllEtudiants(f).get(0);
		
		//Recuperer la liste avant l'ajout
		int tailleInit = etudiantService.getAllEtudiants(f).size();
		
		etudiantService.supprEtudiant(e, f);
		
		if (tailleInit > 1){
			assertEquals(tailleInit-1,etudiantService.getAllEtudiants(f).size());
		} else {
			assertTrue(etudiantService.getAllEtudiants(f).isEmpty());
		}
	}
}

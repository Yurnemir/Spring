package fr.adaming.lanceurTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import fr.adaming.testUnitaire.ClassTest;
import fr.adaming.testUnitaire.ClassTest2;

public class LanceurTest {

	public static void main(String[] args) {
		//Lancer les tests unitaires avec le lanceur de junit : JUnitCore
		
		Result result = JUnitCore.runClasses(ClassTest2.class);
		
		//result encapsule les infos sur les tests
		//recuperer le nombre de tests lancés
		int tests = result.getRunCount();
		System.out.println("Tests lancés: "+tests);
		//recuperer le nombre de tests lancés
		int echecs = result.getFailureCount();
		System.out.println("Tests échoués: "+echecs);
		for(Failure f : result.getFailures()){
			System.out.println(f);
		}
		
		System.out.println(result.wasSuccessful());
		
	}

}

package fr.adaming.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //Annotation pour déclarer un aspect qui est un ensemble de greffons
public class BanqueLoggingAspects {
	
	@Before("execution(* fr.adaming.service.IBanqueService.retrait(..))")
	//annotation before pour insérer un advice de type before(...)
	//execution permet de definir le point de jonction: l'endroit ou on veut inserer le greffon
	public void logBefore(JoinPoint pointJonction){
		//Difference d'obtention des parametres, noms, etc avec AOP
		System.out.println("Dans le before annoté, avant l'exécution de la méthode "+pointJonction.getSignature().getName()+"() invoquée avec les paramètres "+Arrays.toString(pointJonction.getArgs()));
	}
	
	//n'importe quelle methode de n'importe quel package avec n'importe quel paramètre
	@After("execution(* *.*(..))")
	public void logAfter(JoinPoint pointJonction){
		System.out.println("Dans le after annoté, après l'exécution de la méthode "+pointJonction.getSignature().getName()+"() invoquée avec les paramètres "+Arrays.toString(pointJonction.getArgs()));
	}
	
	@AfterReturning(value="execution(* *.*(..))",returning="resultat")//le retour sera renvoyé vers l'objet nommé "resultat"
	public void logAfterReturning(JoinPoint pointJonction, Object resultat){
		System.out.println("Dans le afterReturning annoté, après l'exécution de la méthode "+pointJonction.getSignature().getName()+"() invoquée avec les paramètres "+Arrays.toString(pointJonction.getArgs()));
		System.out.println("La valeur de retour est "+resultat.toString());
	}
	
	@AfterThrowing(value="execution(* *.*(..))", throwing="ex")
	public void logAfterThrowing(JoinPoint pointJonction, IllegalArgumentException ex){
		System.out.println("Après un throw de la méthode "+pointJonction.getSignature().getName());
		ex.printStackTrace();
	}
	
	@Around(value="execution(* *.*(..))")
	public void logAround(ProceedingJoinPoint pjp) throws Throwable{
		
		try{
		//execution des instructions pré-méthode
		System.out.println("Dans le around, avant l'exécution de la méthode " + pjp.getSignature().getName()
				+ "() invoquée avec les paramètres " + Arrays.toString(pjp.getArgs()));

		//appel de la méthode par proceed
		Object result = pjp.proceed();
		
		//post-méthode
		System.out.println("Dans le around, après l'exécution de la méthode "+pjp.getSignature().getName()+"() invoquée avec les paramètres "+Arrays.toString(pjp.getArgs()));
		System.out.println("La valeur de retour est "+result.toString());
		
		} catch (IllegalArgumentException ex){
			
			//tache a effectuer si exception
			System.out.println("Dans le around, après un throw de la méthode "+pjp.getSignature().getName());
			throw ex;
		}
		
	}
}

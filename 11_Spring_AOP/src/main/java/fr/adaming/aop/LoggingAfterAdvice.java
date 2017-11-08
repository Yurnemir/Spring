package fr.adaming.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Dans le after returning, après l'exécution de la méthode "+method.getName()+"() invoquée avec les paramètres "+Arrays.toString(args));
		System.out.println("La valeur de retour est "+returnValue.toString());

	}

}

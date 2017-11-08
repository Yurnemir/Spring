package fr.adaming.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Dans le before, avant l'exécution de la méthode "+method.getName()+"() invoquée avec les paramètres "+Arrays.toString(args));
		
	}

	
	
}

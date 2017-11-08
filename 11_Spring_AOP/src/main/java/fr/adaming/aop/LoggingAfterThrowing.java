package fr.adaming.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LoggingAfterThrowing implements ThrowsAdvice {

	//Exception peut être un type spécifique, et donc la méthode peut dépendre de l'exception renvoyée
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		System.out.println("Après un throw de la méthode "+method.getName());
	}
}

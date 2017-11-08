package fr.adaming.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		try{
		//execution des instructions pré-méthode
		System.out.println("Dans le invoke, avant l'exécution de la méthode " + methodInvocation.getMethod().getName()
				+ "() invoquée avec les paramètres " + Arrays.toString(methodInvocation.getArguments()));

		//appel de la méthode par proceed
		Object result = methodInvocation.proceed();
		
		//post-méthode
		System.out.println("Dans le invoke, après l'exécution de la méthode "+methodInvocation.getMethod().getName()+"() invoquée avec les paramètres "+Arrays.toString(methodInvocation.getArguments()));
		System.out.println("La valeur de retour est "+result.toString());
		
		
		return result;
		} catch (IllegalArgumentException ex){
			
			//tache a effectuer si exception
			System.out.println("Dans le invoke, après un throw de la méthode "+methodInvocation.getMethod().getName());
			throw ex;
		}
		
	}

}

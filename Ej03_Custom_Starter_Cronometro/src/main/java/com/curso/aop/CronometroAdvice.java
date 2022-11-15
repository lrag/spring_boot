package com.curso.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CronometroAdvice implements MethodInterceptor {

	@Autowired
	private Logger loggerCronometro;	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Method method = invocation.getMethod();         //metodo al que se está llamando
		Object[] Arguments = invocation.getArguments(); //parametros de la llamada
		Object target = invocation.getThis();           //target
		
		long inicio = System.currentTimeMillis();
		
		//Tomamos el control absoluto de la llamada al target
		//Si no invocamos proceed no se llama al target
		//Si el método del target devuelve algo es responsabilidad del interceptor el devolverlo a su vez al cliente
		Object retorno = invocation.proceed();
		
		long fin = System.currentTimeMillis();		
		loggerCronometro.escribir(LocalDateTime.now()+": Llamada al metodo "+method.getName()+" de "+target.getClass()+" procesada en "+(fin-inicio)+" milisegundos.");
		
		return retorno;
	}
	
}

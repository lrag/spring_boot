package com.curso.starter;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.aop.CronometroAdvice;

@Configuration
@EnableConfigurationProperties(CronometroProperties.class)
public class CronometroAutoConfiguration {
	
	@Autowired
	private CronometroProperties cronometroProperties;

	//POINTCUT: Sabe cuándo, no sabe qué y no sabe quién
	@Bean
	JdkRegexpMethodPointcut cronometroPointcut(){
		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();		
		//.*insertarCliente : El metodo 'insertarCliente' de cualquier clase y paquete
		//.*insertar.*      : Métodos cuyo nombre comience por 'insertar' de cualquier clase y paquete
		//com.curso.modelo.negocio.GestorClientes.*(..) : Cualquier método de la clase GestorClientes
		//com.curso.modelo.negocio.*.*(..): Cualquier metodo de cualquier clase del paquete negocio
		
		//pc.setPattern("com.curso.modelo.negocio.*.*(..)");
		pc.setPattern(cronometroProperties.getPattern());
		return pc;
	}
	
	//ADVISOR: Junta el QUÉ con el CUÁNDO 
	@Bean
	DefaultPointcutAdvisor cronometroAdvisor(CronometroAdvice cronometroAdvice, Pointcut cronometroPointcut) {
		DefaultPointcutAdvisor dpa = new DefaultPointcutAdvisor();
		dpa.setPointcut(cronometroPointcut);
		dpa.setAdvice(cronometroAdvice);
		return dpa;
	}		
	
	@Bean
	//Condicional puesto que seguramente la registrará otro starter
	@ConditionalOnMissingBean
	//Esta bean se encargará de cruzar los advisor con las beans para averiguar cuáles necesitan proxy	
	DefaultAdvisorAutoProxyCreator autoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

}




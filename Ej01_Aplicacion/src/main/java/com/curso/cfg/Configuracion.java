package com.curso.cfg;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.util.Saludador;

@Configuration
public class Configuracion {

	@Bean
	//No hace falta que el id sea distinto al de la bean definida en el starter
	Saludador saludador() {
		return new Saludador("Hola holita");
	}
	
}

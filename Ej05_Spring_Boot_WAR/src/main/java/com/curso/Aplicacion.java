package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Aplicacion extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("HOLA RADIOLA");
		SpringApplication.run(Aplicacion.class, args);
	}

}

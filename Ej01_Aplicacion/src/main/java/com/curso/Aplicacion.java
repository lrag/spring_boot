package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.curso.util.Saludador;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner {

	@Autowired
	private Saludador saludador;

	public static void main(String[] args) {
		//ApplicationContext appCtx = SpringApplication.run(Aplicacion.class, args);
		//Saludador s = (Saludador) appCtx.getBean("saludador");
		//System.out.println(s.saludar("Luis Ramón"));
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(saludador.saludar("Luis Ramón"));
	}

}

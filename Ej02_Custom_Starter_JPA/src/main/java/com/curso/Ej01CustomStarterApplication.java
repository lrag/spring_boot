package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Esta clase no es necesaria en un custom starter, la crea el asistente
@SpringBootApplication
public class Ej01CustomStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ej01CustomStarterApplication.class, args);
	}

}

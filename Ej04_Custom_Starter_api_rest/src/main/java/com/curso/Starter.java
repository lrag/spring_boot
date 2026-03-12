package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Starter {

	//Esta main no es necesario en un custom starter, lo crea el asistente
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

}

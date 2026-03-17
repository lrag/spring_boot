package com.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class _01_AplicacionConsola implements CommandLineRunner {
	
	@Autowired ChatConsola chatConsola;

	public static void main(String[] args) {
        SpringApplication.run(_01_AplicacionConsola.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		chatConsola.ejecutar();
	}	

}

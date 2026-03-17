package com.curso;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Pelicula;

@SpringBootApplication
public class _02_AplicacionPrompts implements CommandLineRunner{

    private final Configuracion configuracion;
	
	@Autowired Prompts prompts;
	@Autowired ChatClient chatClient;

    _02_AplicacionPrompts(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

	public static void main(String[] args) {
        SpringApplication.run(_02_AplicacionPrompts.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		/*
		System.out.println("============================================");
		Prompt prompt1 = prompts.prompt1();
		String resultado1 = chatClient
				.prompt(prompt1)
				.call()
				.content();
		System.out.println(resultado1);
		*/
		
		/*
		System.out.println("============================================");
		Prompt prompt2 = prompts.prompt2("listar los clientes de Chinchón");
		String resultado2 = chatClient
				.prompt(prompt2)
				.call()
				.content();
		System.out.println(resultado2);	
		*/	
		
		System.out.println("============================================");
		Pelicula p = prompts.extraerDatosPelicula("Harry el sucio es una película estadounidense de 1971 dirigida por Don Siegel e interpretada por Clint Eastwood. Con Andrew Robinson, Reni Santoni, John Vernon y Harry Guardino en los papeles principales.");
		System.out.println(p);
	}

}

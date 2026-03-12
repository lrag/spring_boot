package com.curso;

import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
        SpringApplication.run(Aplicacion.class, args);
    }

    @Bean
    CommandLineRunner run(ChatClient.Builder builder) {
        return args -> {
            // Creamos el cliente
            ChatClient chatClient = builder.build();

            System.out.println("====================================================");
            Scanner sc = new Scanner(System.in);
            System.out.println("Pregunte a groq lo que se le antoje:");
            String pregunta = "¿en qué se diferencian las IAs groq de grok?"; //sc.nextLine();            
            
            if(pregunta.trim().length() == 0) {
            	System.out.println("Escribe algo!");
            	System.exit(42);
            }
            
            //Síncrono
            String respuesta = chatClient.prompt()
                    .user(pregunta)
                    .call()
                    .content();

            System.out.println("----------------------------------------------------");
            System.out.println("RESPUESTA:");
            System.out.println(respuesta);
            System.out.println("----------------------------------------------------");
        };
    }

}

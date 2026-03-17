package com.curso;

import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class ChatConsola {

	private ChatClient chatClient;
	
	public ChatConsola(ChatClient chatClient) {
        this.chatClient = chatClient;
    }	
	
	public void ejecutar() {

        System.out.println("====================================================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Pregunte a groq lo que se le antoje:");
        String pregunta = sc.nextLine();            
        
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
		
	}
	
	
}

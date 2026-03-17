package com.curso;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.Pelicula;

@Component
public class Prompts {
	
	@Autowired private ChatModel chatModel;	
	
	public Prompt prompt1() {		
		String template = "Explícame el concepto de {concepto} como si yo fuera un {nivel}.";
		PromptTemplate promptTemplate = new PromptTemplate(template);

		return promptTemplate.create(Map.of(
		    "concepto", "Programación Reactiva",
		    "nivel", "principiante"
		));
	}
	
	public Prompt prompt2(String criterio) {
		SystemPromptTemplate systemMessageTemplate = new SystemPromptTemplate("""
			    Dada la siguiente tabla, genera SOLO el código SQL cuando te lo pidan: 
			    CREATE TABLE cliente (
			            ID INT PRIMARY KEY,
			            NOMBRE VARCHAR(100) NOT NULL,
			            DIRECCION VARCHAR(255),
			            TELEFONO VARCHAR(20),
			            FECHA_ALTA DATE DEFAULT (CURRENT_DATE),
			            ESTADO VARCHAR(20),
			            CREDITO DECIMAL(10, 2)
			        );
			    """);			    
	    Message systemMessage = systemMessageTemplate.createMessage();

	    PromptTemplate userMessageTemplate = new PromptTemplate("Crea una consulta SQL que haga lo siguiente: {criterio}");
	    Message userMessage = userMessageTemplate.createMessage(Map.of("criterio",criterio));
	    
	    return new Prompt(List.of(systemMessage, userMessage));
	}
	
	public Pelicula extraerDatosPelicula(String texto) {
	    BeanOutputConverter<Pelicula> converter = new BeanOutputConverter<>(Pelicula.class);

	    PromptTemplate userTemplate = new PromptTemplate("""
	        Extrae la información de esta reseña: {texto}
	        
	        Debes responder exclusivamente con este formato JSON:
	        {formato}
	        """);

	    Prompt prompt = userTemplate.create(Map.of(
	        "texto", texto,
	        "formato", converter.getFormat() 
	    ));

	    // 3. Enviamos y convertimos el resultado
	    String response = chatModel.call(prompt).getResult().getOutput().getContent();
	    return converter.convert(response);
	}	
	
}

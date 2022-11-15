package com.curso.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.curso.saludador")
public class SaludadorProperties {

	private String mensaje;
	
	public SaludadorProperties() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		System.out.println("SET MENSAJE");
		this.mensaje = mensaje;
	}

}
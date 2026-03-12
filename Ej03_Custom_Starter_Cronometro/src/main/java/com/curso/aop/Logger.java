package com.curso.aop;

import org.springframework.stereotype.Component;

@Component
public class Logger {

	public void escribir(String string) {
		System.out.println(string);		
	}

}

package com.curso.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.util.Saludador;

@Service
public class ServicioClientes {

	@Autowired
	private Saludador saludador;
	
	public void altacliente(String cliente) {
		//LN...
		System.out.println(saludador.saludar(cliente));
	}
	
}

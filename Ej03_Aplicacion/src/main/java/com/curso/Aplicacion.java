package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Empleado;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.negocio.GestorEmpleados;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appCtx = SpringApplication.run(Aplicacion.class, args);

		GestorClientes gc = appCtx.getBean("gestorClientes", GestorClientes.class);
		GestorEmpleados ge = appCtx.getBean(GestorEmpleados.class);

		Cliente c = new Cliente("Bud Spencer");
		gc.insertar(c);
		gc.borrar(c);

		Empleado e = new Empleado("Terence Hill");
		ge.insertar(e);
		ge.borrar(e);

		appCtx.close();
		
	}

}

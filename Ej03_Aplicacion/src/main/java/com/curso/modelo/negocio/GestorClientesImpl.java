package com.curso.modelo.negocio;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;

//@Service("gestorClientesTarget")
@Service("gestorClientes")
public class GestorClientesImpl implements GestorClientes {

	//@Autowired
	//private ClienteDao clienteDao;
	
	@Override
	public void insertar(Cliente cliente){
		
		System.out.println("Insertando en GestorClientesImpl:"+cliente);
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void borrar(Cliente cliente){

		System.out.println("Borrando en GestorClientesImpl:"+cliente);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
}

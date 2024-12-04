package com.curso;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.PedidoRepositorio;

@SpringBootTest
@AutoConfigureMockMvc
class PedidosRestTestUnitario {

	@MockBean
	PedidoRepositorio pedidoRepositorio; 
	
	@MockBean
	GestorPedidos gestorPedidos;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void listarPedidos() throws Exception {
		
		Cliente c1 = new Cliente(1,"cli1@correo.es", "Ringo Starr", "1234");
		Cliente c2 = new Cliente(2,"cli2@correo.es", "Harry Callahan", "4321");
		Producto pr1 = new Producto(1, "PROD-1", "Chisme", 10d);
		Producto pr2 = new Producto(2, "PROD-2", "Fleje", 20d);
		Producto pr3 = new Producto(3, "PROD-3", "Elemento disrruptor", 30d);
		
		List<DetallePedido> detalles1 = new ArrayList<>();
		Pedido p1 = new Pedido(1,"PED-10","FECHA 1", "PENDIENTE", 50d, c1, detalles1);
		detalles1.add(new DetallePedido(1, 10d, 1, p1, pr1));
		detalles1.add(new DetallePedido(2, 20d, 1, p1, pr2));
		detalles1.add(new DetallePedido(3, 30d, 1, p1, pr3));

		List<DetallePedido> detalles2 = new ArrayList<>();
		Pedido p2 = new Pedido(2,"PED-20","FECHA 2", "ACEPTADO", 40d, c2, detalles2);
		detalles1.add(new DetallePedido(1, 10d, 2, p2, pr1));
		detalles1.add(new DetallePedido(2, 20d, 1, p2, pr2));
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(p1);
		pedidos.add(p2);
		
		Mockito.when(pedidoRepositorio.findAll()).thenReturn(pedidos);
		
		mockMvc
			.perform(get("/pedidos"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(2))) //Hamcrest
			.andExpect(jsonPath("$[0].codigo", Matchers.is("PED-10")))	
			.andExpect(jsonPath("$[1].codigo", Matchers.is("PED-20")));			
	}
	
	@Test
	void buscarPedido() throws Exception {
		
		Cliente c1 = new Cliente(1,"cli1@correo.es", "Ringo Starr", "1234");
		Producto pr1 = new Producto(1, "PROD-1", "Chisme", 10d);
		Producto pr2 = new Producto(2, "PROD-2", "Fleje", 20d);
		Producto pr3 = new Producto(3, "PROD-3", "Elemento disrruptor", 30d);
		
		List<DetallePedido> detalles1 = new ArrayList<>();
		Pedido p1 = new Pedido(1,"PED-10","FECHA 1", "PENDIENTE", 50d, c1, detalles1);
		detalles1.add(new DetallePedido(1, 10d, 1, p1, pr1));
		detalles1.add(new DetallePedido(2, 20d, 1, p1, pr2));
		detalles1.add(new DetallePedido(3, 30d, 1, p1, pr3));
		
		Mockito.when(pedidoRepositorio.buscarPedidosConDetalles(Mockito.anyInt())).thenReturn(Optional.of(p1));
		
		mockMvc
			.perform(get("/pedidos/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.codigo", Matchers.is("PED-10")));			
	}	

}

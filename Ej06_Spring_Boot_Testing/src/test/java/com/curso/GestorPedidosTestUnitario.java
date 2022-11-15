package com.curso;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.PedidoRepositorio;
import com.curso.modelo.proxy.ClientesRestProxy;
import com.curso.modelo.proxy.ProductosRestProxy;

@SpringBootTest
class GestorPedidosTestUnitario {

	@MockBean PedidoRepositorio pedidoRepositorio;
	@MockBean ClientesRestProxy clientesRestProxy;
	@MockBean ProductosRestProxy productosRestProxy;	
	
	@Autowired
	GestorPedidos gestorPedidos;

	@Test
	void aceptarPedido() throws Exception {
		
		Cliente c1 = new Cliente();
		c1.setLogin("ringo@starr.com");
		
		Producto pr1 = new Producto();
		pr1.setCodigo("PROD-1");
		Producto pr2 = new Producto();
		pr2.setCodigo("PROD-2");
		
		List<DetallePedido> detalles1 = new ArrayList<>();
		Pedido pedidoRecibido = new Pedido(1,null,"FECHA", "PENDIENTE", 0d, c1, detalles1);
		detalles1.add(new DetallePedido(1, 10d, 1, pedidoRecibido, pr1));
		detalles1.add(new DetallePedido(2, 20d, 1, pedidoRecibido, pr2));

		//PedidoRepositorio es un STUB	
		
		Mockito
			.when(clientesRestProxy.buscar(c1.getLogin()))
			.thenReturn(new Cliente(1,"ringo@starr.com", "Ringo Starr", "1234"));
		
		Mockito
			.when(productosRestProxy.buscar(pr1.getCodigo()))
			.thenReturn(new Producto(1, "PROD-1", "Chisme", 10d));	
		Mockito
			.when(productosRestProxy.buscar(pr2.getCodigo()))
			.thenReturn(new Producto(2, "PROD-2", "Fleje", 20d));	
		
		Pedido pedidoAlta = gestorPedidos.altaPedido(pedidoRecibido);
		
		Assertions.assertAll(
				() -> Assertions.assertNotNull(pedidoAlta.getCodigo()),
				() -> Assertions.assertEquals(pedidoAlta.getTotal(), 30),
				() -> Assertions.assertEquals(pedidoAlta.getCliente().getNombre(), "Ringo Starr"),
				() -> Assertions.assertEquals(pedidoAlta.getDetalles().get(0).getProducto().getNombre(), "Chisme"),
				() -> Assertions.assertEquals(pedidoAlta.getDetalles().get(0).getProducto().getNombre(), "Fleje")
			);	
	}
}

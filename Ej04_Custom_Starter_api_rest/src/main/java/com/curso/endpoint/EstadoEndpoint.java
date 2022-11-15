package com.curso.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoEndpoint {

	@GetMapping(path="estado", produces = "application/json")
	ResponseEntity<Map<String, Object>> getEstado(){
		Map<String, Object> datos = new HashMap<>();
		datos.put("memoria total", Runtime.getRuntime().totalMemory());
		datos.put("memoria libre", Runtime.getRuntime().freeMemory());
		datos.put("memoria max",   Runtime.getRuntime().maxMemory());
		return new ResponseEntity<>(datos, HttpStatus.OK);
	}
	
}

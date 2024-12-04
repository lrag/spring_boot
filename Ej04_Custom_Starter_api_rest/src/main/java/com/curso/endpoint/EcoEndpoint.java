package com.curso.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoEndpoint {

	@GetMapping(path="eco")
	String getEstado(@RequestParam("texto") String texto){
		return texto;
	}
	
}

package com.curso.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Coche;

@RestController
public class CochesEndpoint {

	@GetMapping(path="coches", produces = "application/json")
	ResponseEntity<List<Coche>> listarCoches(){
		List<Coche> coches = new ArrayList<>();
		coches.add(new Coche("SEAT","600"));
		coches.add(new Coche("Renault","5"));
		coches.add(new Coche("Renault","9"));
		coches.add(new Coche("Citroën","Xsara"));
		coches.add(new Coche("Citroën","C5"));
		coches.add(new Coche("Peugeot","308"));
		return new ResponseEntity<>(coches, HttpStatus.OK);
	}
	
}

package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Configuracion {

	/*
	@Bean
	public DataSource dataSource2() {
		//Cuidado que este no tiene pool de conexiones
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:file:c:/h2/bbdd_spring_pruebas_2");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	*/
	
}

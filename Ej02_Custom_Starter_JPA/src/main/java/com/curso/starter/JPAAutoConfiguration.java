package com.curso.starter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@EnableTransactionManagement
@EnableJpaRepositories
public class JPAAutoConfiguration {
	
	//Para JPA necesitamos tres beans:
	//-el DataSource
	//-el EntityManagerFactory
	//-el JPATransactionManager
	
	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Bean
	@ConditionalOnMissingBean
	DataSource dataSource() {
		System.out.println("Configuracion.dataSource()");
		//Este datasource no tiene pool de conexiones
		DriverManagerDataSource ds = new DriverManagerDataSource();
		//Fijamos el driver a fuego
		ds.setDriverClassName("org.h2.Driver");
		//El resto se lee del fichero de cfg 'application' de la aplicación que utilice este starter
		ds.setUrl(dataSourceProperties.getUrl());
		ds.setUsername(dataSourceProperties.getUsername());
		ds.setPassword(dataSourceProperties.getPassword());		
		return ds;
	}
	
	//LocalContainerEntityManagerFactoryBean
	
	//JPATransactionManager
	
}






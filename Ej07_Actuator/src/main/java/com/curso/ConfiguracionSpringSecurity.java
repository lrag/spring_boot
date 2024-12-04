package com.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguracionSpringSecurity {

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    	
		
		http
	    .authorizeHttpRequests((authz) -> authz
    		.antMatchers("/actuator/**").permitAll() //Endpoints del actuator
	        .antMatchers("/**").permitAll()          //Endpoints de la aplicacion	        		
	    );
		
		return http.build();
		
	}	
	
}

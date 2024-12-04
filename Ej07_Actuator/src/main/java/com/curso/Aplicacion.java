package com.curso;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

/*

Prefijo: /actuator

/actuator/health

/auditevents 	lists security audit-related events such as user login/logout. Also, we can filter by principal or type among other fields.
/beans 			returns all available beans in our BeanFactory. Unlike /auditevents, it doesn’t support filtering.
/conditions		builds a report of conditions around autoconfiguration.
/configprops 	allows us to fetch all @ConfigurationProperties beans.
/env 			returns the current environment properties. Additionally, we can retrieve single properties.
/flyway 		provides details about our Flyway database migrations.
/health 		summarizes the health status of our application.
/heapdump 		builds and returns a heap dump from the JVM used by our application.
/info 			returns general information. It might be custom data, build information or details about the latest commit.
/liquibase 		behaves like /flyway but for Liquibase.
/logfile 		returns ordinary application logs.
/loggers 		enables us to query and modify the logging level of our application.
/metrics 		details metrics of our application. This might include generic metrics as well as custom ones.
 
  http://localhost:8090/actuator/metrics/jvm.gc.pause
  
/prometheus 	returns metrics like the previous one, but formatted to work with a Prometheus server.
/scheduledtasks provides details about every scheduled task within our application.
/sessions 		lists HTTP sessions, given we are using Spring Session.
/shutdown 		performs a graceful shutdown of the application.
/threaddump 	dumps the thread information of the underlying JVM.
*/

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	private GestorClientes gestorClientes;
	
	public Aplicacion(GestorClientes gestorClientes) {
		this.gestorClientes = gestorClientes;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Cliente> clientes = gestorClientes.listar();
		if(clientes.size() == 0) {
			Cliente c1 = new Cliente(null, "Bart", "C/Evergreen Terrace", "555", 0);
			Cliente c2 = new Cliente(null, "Ringo", "C/Su casa", "555", 0);
			Cliente c3 = new Cliente(null, "McClane", "C/Tale", "555", 0);
			gestorClientes.insertar(c1);
			gestorClientes.insertar(c2);
			gestorClientes.insertar(c3);
		}
		
	}

}

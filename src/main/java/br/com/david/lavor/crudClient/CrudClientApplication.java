package br.com.david.lavor.crudClient;

import br.com.david.lavor.crudClient.dto.Client;
import br.com.david.lavor.crudClient.repository.ClientRepository;
import br.com.david.lavor.crudClient.rest.RestControllerCrudClient;
import br.com.david.lavor.crudClient.security.SecurityConfig;
import br.com.david.lavor.crudClient.service.ServiceCrudClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudClientApplication.class, args);
	}

}

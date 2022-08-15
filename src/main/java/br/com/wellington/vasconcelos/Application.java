package br.com.wellington.vasconcelos;

import org.springframework.boot.SpringApplication;
/**
 * Projeto Sring Boot gerado via Spring Initializr
 * Os sequintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * 
 * @author WellingtonVasconcelos
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

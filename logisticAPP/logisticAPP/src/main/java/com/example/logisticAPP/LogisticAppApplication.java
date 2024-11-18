package com.example.logisticAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LogisticAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticAppApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  // Permite todas las rutas
						.allowedOrigins("http://127.0.0.1:5500")  // Reemplaza con tu origen en producción
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
						.allowedHeaders("*")  // Permite todos los encabezados
						.allowCredentials(true);  // Si necesitas enviar credenciales
			}
		};
	}
}

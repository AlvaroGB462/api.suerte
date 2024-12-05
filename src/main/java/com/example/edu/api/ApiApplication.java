package com.example.edu.api; // Define el paquete en el que se encuentra la clase ApiApplication

import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication para ejecutar la aplicación Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación para la configuración automática de Spring Boot

// Anotación que marca esta clase como una aplicación Spring Boot
@SpringBootApplication
public class ApiApplication {
    
    // Método principal que se ejecuta al iniciar la aplicación
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot, cargando el contexto de la aplicación
        SpringApplication.run(ApiApplication.class, args);
    }
}
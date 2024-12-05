package com.example.edu.api.controladores;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.edu.api.modelos.Usuarios;
import com.example.edu.api.servicios.UsuarioServicio;
	
// Anotación que define este controlador como un controlador REST
@RestController
@RequestMapping("/api/usuario") // Define la ruta base para las solicitudes relacionadas con clubes
public class UsuarioControlador {

	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);
	
 //Inyección de la dependencia del servicio ClubServicio
    @Autowired
    private UsuarioServicio usuarioServicios;

 //Para agregar un usuario nuevo
    @PostMapping
    public String agregarUsuario(@RequestBody Usuarios usuario) {
        usuarioServicios.agregarUsuario(usuario);
        return "Usuario añadido con éxito, ID: " + usuario.getIdUser();
    }

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios usuario) {
        logger.debug("Datos recibidos en el controlador: {}", usuario);

        if (usuario.getEmail() == null && usuario.getNickUser() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Se requiere email o nickUser"));
        }

        if (usuario.getPasswordUser() == null || usuario.getPasswordUser().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "La contraseña es obligatoria"));
        }

        try {
            return usuarioServicios.solicitudDatos(usuario.getNickUser(), usuario.getPasswordUser(), usuario.getEmail())
                    .map(u -> ResponseEntity.ok(Map.of(
                            "nickUser", u.getNickUser(),
                            "email", u.getEmail(),
                            "passwordUser", u.getPasswordUser(),
                            "admin", u.getAdmin() // Añadimos el campo admin a la respuesta
                    )))
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body(Map.of("mensaje", "Error de autenticación")));
        } catch (Exception ex) {
            // Manejar cualquier excepción inesperada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error procesando la solicitud", "detalles", ex.getMessage()));
        }
    }




}
    
    


    
   

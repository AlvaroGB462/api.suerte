package com.example.edu.api.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edu.api.modelos.Usuarios;
import com.example.edu.api.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

  //Esta línea crea un logger utilizando la clase LoggerFactory.
  //El logger se usa para registrar eventos y mensajes de depuración.
	private static final Logger logger = LoggerFactory.getLogger(UsuarioServicio.class);
	
	 @Autowired // Inyección de dependencias para el repositorio de usuarios
	    private UsuarioRepositorio usuarioRepositorio;

	    
	 //Método para agregar un nuevo usuario a la base de datos
	    public void agregarUsuario(Usuarios usuario) {
	        usuarioRepositorio.save(usuario);  // Guarda el usuario utilizando el repositorio
	    }
	    
	    
	    
	 //Obtener todos los usuarios
	    public List<Usuarios> obtenerTodosUsuarios() {
	        return usuarioRepositorio.findAll();
	    }
	    
	    

	    public Optional<Usuarios> solicitudDatos(String nickUser, String passwordUser, String email) {
	        logger.info("Iniciando autenticación. NickUser: {}, Password: {}, Email: {}", nickUser, passwordUser, email);

	        if ((nickUser == null || nickUser.isEmpty()) && (email == null || email.isEmpty())) {
	            logger.warn("NickUser y Email no proporcionados");
	            return Optional.empty();
	        }

	        if (passwordUser == null || passwordUser.isEmpty()) {
	            logger.warn("Password no proporcionado");
	            return Optional.empty();
	        }

	        // Obtiene todos los usuarios desde el repositorio 
	        List<Usuarios> usuarios = usuarioRepositorio.findAll();

	        return usuarios.stream()
	                .peek(usuarioBD -> logger.debug("Comparando con usuario: {}", usuarioBD))
	                .filter(usuarioBD ->
	                        ((nickUser != null && nickUser.equals(usuarioBD.getNickUser())) ||
	                                (email != null && email.equals(usuarioBD.getEmail()))) &&
	                                passwordUser.equals(usuarioBD.getPasswordUser()))
	                .findFirst();
	    }

	    
	    
}

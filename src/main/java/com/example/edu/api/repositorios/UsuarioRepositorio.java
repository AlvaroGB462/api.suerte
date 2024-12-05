package com.example.edu.api.repositorios; // Define el paquete en el que se encuentra la interfaz ClubRepositorio

import org.springframework.data.jpa.repository.JpaRepository; // Importa la interfaz JpaRepository de Spring Data JPA

import com.example.edu.api.modelos.Usuarios;

public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {
  
}

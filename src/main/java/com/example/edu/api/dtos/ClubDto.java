package com.example.edu.api.dtos; // Define el paquete en el que se encuentra la clase ClubDto

// Clase que representa un Data Transfer Object (DTO) para el modelo Club
public class ClubDto {
    // Atributo que representa el nombre del club
    private String nickClub;

    // Atributo que representa la contraseña del club
    private String passwordClub;

    // Getters y setters para acceder y modificar los atributos

    // Método que devuelve el nombre del club
    public String getNickClub() {
        return nickClub;
    }

    // Método que establece el nombre del club
    public void setNickClub(String nickClub) {
        this.nickClub = nickClub;
    }

    // Método que devuelve la contraseña del club
    public String getPasswordClub() {
        return passwordClub;
    }

    // Método que establece la contraseña del club
    public void setPasswordClub(String passwordClub) {
        this.passwordClub = passwordClub;
    }
}
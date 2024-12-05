package com.example.edu.api.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")  // Especifica el nombre de la tabla en la base de datos
public class Usuarios {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nick_user", nullable = true, unique = true, length = 50)
    private String nickUser;

    @Column(name = "name_user", nullable = false, length = 100)
    private String nameUser = "aaaa";

    @Column(name = "password_user", nullable = false, length = 255)
    private String passwordUser;

    @Column(name = "dni", nullable = false, unique = true, length = 15)
    private String dni;

    @Column(name = "email", nullable = true, unique = true, length = 100)
    private String email;

    @Column(name = "address", length = 255)
    private String address;
    
    @Column(name = "img_user", length = 2083)
    private String imgUser;

    @Column(name = "admin", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean admin;

    @Column(name = "idClub")
    private Long idClub;
    
    

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNickUser() {
        return nickUser;
    }

    public void setNickUser(String nickUser) {
        this.nickUser = nickUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Long getIdClub() {
        return idClub;
    }

    public void setIdClub(Long idClub) {
        this.idClub = idClub;
    }
    
    @Override
    public String toString() {
        return "Usuarios{" +
               "nickUser='" + nickUser + '\'' +
               ", passwordUser='" + passwordUser + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}

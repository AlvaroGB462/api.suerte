package com.example.edu.api.dtos;

public class UsuariosDto {
	
	 	private Long idUser; 
	    private String nickUser = ""; 
	    private String nameUser = ""; 
	    private String passwordUser = ""; 
	    private String dni = ""; 
	    private String email = ""; 
	    private String address = ""; 
	    private String imgUser = ""; 
	    private Boolean admin = false; 
	    private Long idClub = 0L;

	    // Getter y setter para idUser
	    public Long getIdUser() {
	        return idUser;
	    }

	    public void setIdUser(Long idUser) {
	        this.idUser = idUser;
	    }

	    // Getter y setter para nickUser
	    public String getNickUser() {
	        return nickUser;
	    }

	    public void setNickUser(String nickUser) {
	        this.nickUser = nickUser;
	    }

	    // Getter y setter para nameUser
	    public String getNameUser() {
	        return nameUser;
	    }

	    public void setNameUser(String nameUser) {
	        this.nameUser = nameUser;
	    }

	    // Getter y setter para passwordUser
	    public String getPasswordUser() {
	        return passwordUser;
	    }

	    public void setPasswordUser(String passwordUser) {
	        this.passwordUser = passwordUser;
	    }

	    // Getter y setter para dni
	    public String getDni() {
	        return dni;
	    }

	    public void setDni(String dni) {
	        this.dni = dni;
	    }

	    // Getter y setter para email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter y setter para address
	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    // Getter y setter para imgUser
	    public String getImgUser() {
	        return imgUser;
	    }

	    public void setImgUser(String imgUser) {
	        this.imgUser = imgUser;
	    }

	    // Getter y setter para admin
	    public Boolean getAdmin() {
	        return admin;
	    }

	    public void setAdmin(Boolean admin) {
	        this.admin = admin;
	    }

	    // Getter y setter para idClub
	    public Long getIdClub() {
	        return idClub;
	    }

	    public void setIdClub(Long idClub) {
	        this.idClub = idClub;
	    }
}

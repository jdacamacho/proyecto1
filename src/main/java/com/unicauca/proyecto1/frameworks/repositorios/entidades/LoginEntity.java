package com.unicauca.proyecto1.frameworks.repositorios.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class LoginEntity {
    @Column(name="loginusuario")
    private String userNameLogin;
    @Column(name = "contraseñausuario")
    private String contraseñaLogin;
    
    public LoginEntity(){
        
    }
}
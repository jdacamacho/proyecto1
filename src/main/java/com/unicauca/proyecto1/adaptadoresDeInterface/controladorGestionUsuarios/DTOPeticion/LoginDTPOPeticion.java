package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTPOPeticion {
    private String userNameLogin;
    private String contraseñaLogin;
    
    public LoginDTPOPeticion(){
        
    }
}

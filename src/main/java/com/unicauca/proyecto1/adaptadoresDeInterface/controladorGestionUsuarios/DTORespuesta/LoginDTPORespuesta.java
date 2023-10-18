package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTPORespuesta {
    private String userNameLogin;
    private String contraseñaLogin;
    
    public LoginDTPORespuesta(){
        
    }
}
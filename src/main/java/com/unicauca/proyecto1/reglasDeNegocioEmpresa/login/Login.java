package com.unicauca.proyecto1.reglasDeNegocioEmpresa.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Login {
    private String userNameLogin;
    private String contraseñalogin;
    
    public Login(){
        
    }
}

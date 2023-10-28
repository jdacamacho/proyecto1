package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.AdaptadoresAPI;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.LoginDTPOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExternalLoginDTO {
    public String username;
    public String password;

    public ExternalLoginDTO(){

    }

    public LoginDTPOPeticion adaptUserEntries(){
        
        LoginDTPOPeticion login = new LoginDTPOPeticion();
        login.setContraseñaLogin(this.password);
        login.setUserNameLogin(this.username);

        return login;
    }
}

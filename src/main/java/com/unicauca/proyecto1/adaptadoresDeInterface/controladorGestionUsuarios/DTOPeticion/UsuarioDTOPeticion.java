package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTOPeticion {
    private int identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private List<Rol> roles;
    private String emailUsuario;
    private Login loginUsuario;
    private int estadoUsuario;

    public UsuarioDTOPeticion(){

    }
}


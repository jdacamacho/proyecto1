package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    private int identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private Rol rolUsuario;
    private String emailUsuario;
    private Login loginUsuario;
    private boolean estadoUsuario;
    
    public UsuarioEntity(){

    }
}

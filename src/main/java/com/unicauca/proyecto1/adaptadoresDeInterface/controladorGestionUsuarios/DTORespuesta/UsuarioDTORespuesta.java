package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta;


import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTORespuesta {
    private int identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private Rol rolUsuario;
    private String emailUsuario;
    private Login loginUsuario;
    private boolean estadoUsuario;
}
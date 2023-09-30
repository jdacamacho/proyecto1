package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUser;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.roles.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuarios.Usuario;

public interface factoryUserInt {
    public Usuario crearUsuario(String identificacionUsuario,String nombreUsuario,
                                String apellidoUsuario,Rol rolUsuario,String emailUsuario,
                                Login loginUsuario);
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuarios.Usuario;

public interface factoryUsuarioInt {
    public Usuario crearUsuario(String identificacionUsuario,String nombreUsuario,
                                String apellidoUsuario,int identificacionRol,String tipoRol,
                                String emailUsuario,String userNameLogin,String contraseñaLogin);
}

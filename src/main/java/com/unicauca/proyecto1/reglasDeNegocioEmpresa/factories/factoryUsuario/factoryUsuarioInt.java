package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface factoryUsuarioInt {
    public Usuario crearUsuario(int identificacionUsuario,String nombreUsuario,
                                String apellidoUsuario,
                                String emailUsuario,String userNameLogin,String contraseñaLogin,int estado);
}

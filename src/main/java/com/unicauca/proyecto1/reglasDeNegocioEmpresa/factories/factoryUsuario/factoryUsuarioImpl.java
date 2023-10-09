package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario;

import java.util.ArrayList;


import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryUsuarioImpl implements factoryUsuarioInt {

    @Override
    public Usuario crearUsuario(int identificacionUsuario, String nombreUsuario,
                                String apellidoUsuario,
                                String emailUsuario, String userNameLogin,
                                String contraseñaLogin,boolean estado) {

        Login login = new Login(userNameLogin, contraseñaLogin);
        ArrayList<Rol> roles = new ArrayList<>();
        /* creo el nuevo usuario*/
        return new Usuario(identificacionUsuario, nombreUsuario,apellidoUsuario,roles,emailUsuario,login,estado);
    }
    
}

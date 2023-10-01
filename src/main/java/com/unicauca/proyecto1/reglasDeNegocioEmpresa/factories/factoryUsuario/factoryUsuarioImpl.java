package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryUsuarioImpl implements factoryUsuarioInt {

    @Override
    public Usuario crearUsuario(int identificacionUsuario, String nombreUsuario,
                                String apellidoUsuario,int codigoRol,
                                String tipoRol, String emailUsuario, String userNameLogin,
                                String contraseñaLogin,boolean estado) {

        Rol rol = new Rol(codigoRol, tipoRol);
        Login login = new Login(userNameLogin, contraseñaLogin);
        
        /* creo el nuevo usuario*/
        return new Usuario(identificacionUsuario, nombreUsuario,apellidoUsuario,rol,emailUsuario,login,estado);
    }
    
}

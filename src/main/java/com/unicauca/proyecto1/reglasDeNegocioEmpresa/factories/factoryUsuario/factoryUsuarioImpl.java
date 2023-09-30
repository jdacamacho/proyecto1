package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryLogin.factoryLoginImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRol.factoryRolImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRol.factoryRolInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.roles.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuarios.Usuario;

public class factoryUsuarioImpl implements factoryUsuarioInt {

    @Override
    public Usuario crearUsuario(String identificacionUsuario, String nombreUsuario,
                                String apellidoUsuario,int identificacionRol,
                                String tipoRol, String emailUsuario, String userNameLogin,
                                String contraseñaLogin) {

        /*Utilizo factories para crear el rol y el login*/
        factoryRolImpl factoryRol = new factoryRolImpl();
        factoryLoginImpl factoryLogin = new factoryLoginImpl();
        Rol rol = factoryRol.crearRol(identificacionRol, tipoRol);
        Login login = factoryLogin.crearLogin(userNameLogin, contraseñaLogin);
        
        /* creo el nuevo usuario*/
        return new Usuario(identificacionRol, userNameLogin,apellidoUsuario,rol,emailUsuario,login);
    }
    
}

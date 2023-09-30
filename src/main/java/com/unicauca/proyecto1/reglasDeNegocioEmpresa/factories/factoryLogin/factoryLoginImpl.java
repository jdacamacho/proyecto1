package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryLogin;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;

public class factoryLoginImpl implements factoryLoginInt{

    @Override
    public Login crearLogin(String userNameLogin, String contraseñaLogin) {
        return new Login(userNameLogin,contraseñaLogin);
    }
    
}

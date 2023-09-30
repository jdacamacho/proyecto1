package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryLogin;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;

public interface factoryLoginInt {
    public Login crearLogin(String userNameLogin, String contraseñaLogin);
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRol;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

public class factoryRolImpl implements factoryRolInt {

    @Override
    public Rol crearRol(int identificacionRol, String tipoRol) {
        return new Rol(identificacionRol,tipoRol);
    }
    
}

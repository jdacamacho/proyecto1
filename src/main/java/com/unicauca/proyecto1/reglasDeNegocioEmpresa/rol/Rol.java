package com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Rol {
    private int codigoRol;
    private String tipoRol;

    public Rol(){

    }
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.roles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Rol {
    private int identificacionRol;
    private String tipoRol;

    public Rol(){

    }
}

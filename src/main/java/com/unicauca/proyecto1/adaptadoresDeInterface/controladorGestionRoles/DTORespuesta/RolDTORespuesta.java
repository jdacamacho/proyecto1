package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RolDTORespuesta {
    private int codigoRol;
    private String tipoRol;

    public RolDTORespuesta(){

    }
}
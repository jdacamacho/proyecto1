package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RolDTOPeticion {
    private int codigoRol;
    private String tipoRol;

    public RolDTOPeticion(){

    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoPP_ADTOPeticion {
    private int identificacionDirectorPPA;
    private int identificacionEstudiantePPA;
    private int identificacionCodirectorPPA;
    private int identificacionAsesorPPA;
    private String tituloPropuestaTrabajoGrado;

    public PropuestaTrabajoGradoPP_ADTOPeticion(){

    }
}

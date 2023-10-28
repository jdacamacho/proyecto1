package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionComiteDTOPeticion {
    private int identificacionComitePrograma;
    private int idPropuestaTrabajoGrado;
    private String comentariosRevisionComite;
    private int estadoAvalRevisionComite;    

    public RevisionComiteDTOPeticion(){
        
    }
}

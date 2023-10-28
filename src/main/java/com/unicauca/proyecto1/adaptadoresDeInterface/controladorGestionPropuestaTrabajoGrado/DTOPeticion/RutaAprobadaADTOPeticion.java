package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RutaAprobadaADTOPeticion {
    private int idPropuestaTrabajoGrado;
    private String rutaRespuesta;

    public RutaAprobadaADTOPeticion(){
        
    }
}

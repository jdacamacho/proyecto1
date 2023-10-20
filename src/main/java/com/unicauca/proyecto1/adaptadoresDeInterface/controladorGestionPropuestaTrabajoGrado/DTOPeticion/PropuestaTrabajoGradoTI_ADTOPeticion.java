package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoTI_ADTOPeticion {
    //private int idPropuestaTrabajoGrado;
    private int identificacionDirectorTIA;
    private int identificacionEstudiante1TIA;
    private int identificacionCodirectorTIA;
    private int identificacionEstudiante2TIA;
    private String tituloPropuestaTrabajoGrado;
    private String rutaPropuestaTrabajoGradoOrigen;
    
    public PropuestaTrabajoGradoTI_ADTOPeticion(){

    }
}

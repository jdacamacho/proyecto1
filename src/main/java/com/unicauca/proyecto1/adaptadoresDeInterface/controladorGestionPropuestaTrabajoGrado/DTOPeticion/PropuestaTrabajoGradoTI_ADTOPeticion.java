package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoTI_ADTOPeticion {
    private int idPropuestaTrabajoGrado;
    private Usuario identificacionDirectorTIA;
    private Usuario identificacionEstudiante1TIA;
    private Usuario identificacionCodirectorTIA;
    private Usuario identificacionEstudiante2TIA;
    private String tituloPropuestaTrabajoGrado;
    private Date fechaSubidoPropuestaTrabajoGrado;
    private Date fechaRespuestaPropuestaTrabajoGrado;
    private String estadoPropuestaTrabajoGrado;
    private String rutaPropuestaTrabajoGrado;
    
    public PropuestaTrabajoGradoTI_ADTOPeticion(){

    }
}

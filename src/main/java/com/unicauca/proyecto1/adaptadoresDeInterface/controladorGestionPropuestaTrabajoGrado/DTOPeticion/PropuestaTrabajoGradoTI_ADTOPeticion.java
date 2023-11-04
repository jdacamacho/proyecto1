package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoTI_ADTOPeticion {
    private int identificacionDirectorTIA;
    private int identificacionEstudiante1TIA;
    private int identificacionCodirectorTIA;
    private int identificacionEstudiante2TIA;
    private String tituloPropuestaTrabajoGrado;
    
    public PropuestaTrabajoGradoTI_ADTOPeticion(){

    }
}

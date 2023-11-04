package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.AdaptadoresAPI;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ExternalPropuestaDTO {
    public String title;
    public Integer idDirector;
    public Integer estudiante1;
    public Integer estudiante2;
    public Integer idCodirector;
    public Integer idAsistente;

    public ExternalPropuestaDTO(){

    }

    public PropuestaTrabajoGradoTI_ADTOPeticion adaptPropuestaEntries(){
        PropuestaTrabajoGradoTI_ADTOPeticion propuesta = new PropuestaTrabajoGradoTI_ADTOPeticion();
        propuesta.setTituloPropuestaTrabajoGrado(this.title);
        propuesta.setIdentificacionDirectorTIA(this.idDirector);
        propuesta.setIdentificacionEstudiante1TIA(this.estudiante1);
        propuesta.setIdentificacionEstudiante2TIA(this.estudiante2);
        propuesta.setIdentificacionCodirectorTIA(this.idCodirector);

        return propuesta;
    }
}

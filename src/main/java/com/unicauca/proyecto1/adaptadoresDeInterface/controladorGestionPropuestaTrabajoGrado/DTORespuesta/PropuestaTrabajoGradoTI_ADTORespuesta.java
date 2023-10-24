package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RevisionComiteEntity;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoTI_ADTORespuesta {
    private int idPropuestaTrabajoGradoTIA;
    private Usuario identificacionDirectorTIA;
    private Usuario identificacionEstudiante1TIA;
    private Usuario identificacionCodirectorTIA;
    private Usuario identificacionEstudiante2TIA;
    private String tituloPropuestaTrabajoGrado;
    private Date fechaSubidoPropuestaTrabajoGrado;
    private String rutaPropuestaTrabajoGrado;
    private String rutaRespuestaPropuestaTrabajoGrado;
    private List<RevisionComite> revisiones;

    public PropuestaTrabajoGradoTI_ADTORespuesta(){
        this.revisiones =  new ArrayList<>();
    }
    
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoPP_ADTORespuesta {
    private int idPropuestaTrabajoGradoPPA;
    private Usuario identificacionDirectorPPA;
    private Usuario identificacionEstudiantePPA;
    private Usuario identificacionCodirectorPPA;
    private Usuario identificacionAsesorPPA;
    private String tituloPropuestaTrabajoGrado;
    private Date fechaSubidoPropuestaTrabajoGrado;
    private String rutaPropuestaTrabajoGrado;
    private String rutaRespuestaPropuestaTrabajoGrado;
    private List<RevisionComite> revisiones;

    public PropuestaTrabajoGradoPP_ADTORespuesta(){
        this.revisiones =  new ArrayList<>();
    }
}

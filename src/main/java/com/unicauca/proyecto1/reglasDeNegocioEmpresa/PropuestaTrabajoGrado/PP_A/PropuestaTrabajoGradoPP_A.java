package com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A;

import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoPP_A {
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
    private int estadoPropuestaTrabajoGradoPPA;

    public PropuestaTrabajoGradoPP_A(){

    }

    public PropuestaTrabajoGradoPP_A(
        Usuario identificacionDirectorPPA, 
        Usuario identificacionEstudiantePPA,
        Usuario identificacionCodirectorPPA, 
        Usuario identificacionAsesorPPA,
        String tituloPropuestaTrabajoGrado, 
        Date fechaSubidoPropuestaTrabajoGrado,
        String rutaPropuestaTrabajoGrado,
        List<RevisionComite> revisiones,
        int estadoPropuestaTrabajoGradoPPA
    ) {
        this.identificacionDirectorPPA = identificacionDirectorPPA;
        this.identificacionEstudiantePPA = identificacionEstudiantePPA;
        this.identificacionCodirectorPPA = identificacionCodirectorPPA;
        this.identificacionAsesorPPA = identificacionAsesorPPA;
        this.tituloPropuestaTrabajoGrado = tituloPropuestaTrabajoGrado;
        this.fechaSubidoPropuestaTrabajoGrado = fechaSubidoPropuestaTrabajoGrado;
        this.rutaPropuestaTrabajoGrado = rutaPropuestaTrabajoGrado;
        this.revisiones = revisiones;
        this.estadoPropuestaTrabajoGradoPPA = estadoPropuestaTrabajoGradoPPA;
    }
}

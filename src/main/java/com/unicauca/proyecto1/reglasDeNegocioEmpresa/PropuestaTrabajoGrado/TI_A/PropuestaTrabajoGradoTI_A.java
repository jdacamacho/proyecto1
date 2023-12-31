package com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A;

import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropuestaTrabajoGradoTI_A {
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
    private int estadoPropuestaTrabajoGradoTIA;

    public PropuestaTrabajoGradoTI_A(){

    }

    public PropuestaTrabajoGradoTI_A(
        Usuario identificacionDirectorTIA, 
        Usuario identificacionEstudiante1TIA,
        Usuario identificacionCodirectorTIA, 
        Usuario identificacionEstudiante2TIA,
        String tituloPropuestaTrabajoGrado, 
        Date fechaSubidoPropuestaTrabajoGrado,
        String rutaPropuestaTrabajoGrado,
        List<RevisionComite> revisiones, 
        int estadoPropuestaTrabajoGradoTIA
    ) {
        this.identificacionDirectorTIA = identificacionDirectorTIA;
        this.identificacionEstudiante1TIA = identificacionEstudiante1TIA;
        this.identificacionCodirectorTIA = identificacionCodirectorTIA;
        this.identificacionEstudiante2TIA = identificacionEstudiante2TIA;
        this.tituloPropuestaTrabajoGrado = tituloPropuestaTrabajoGrado;
        this.fechaSubidoPropuestaTrabajoGrado = fechaSubidoPropuestaTrabajoGrado;
        this.rutaPropuestaTrabajoGrado = rutaPropuestaTrabajoGrado;
        this.revisiones = revisiones;
        this.estadoPropuestaTrabajoGradoTIA = estadoPropuestaTrabajoGradoTIA;
    }
    
}

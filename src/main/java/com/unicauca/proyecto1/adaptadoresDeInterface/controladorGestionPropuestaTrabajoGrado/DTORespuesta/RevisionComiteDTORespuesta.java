package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionComiteDTORespuesta {
    private int idRevisionComite;
    private Usuario identificacionComitePrograma;
    private PropuestaTrabajoGradoTI_A idPropuestaTrabajoGradoTIA;
    private String comentariosRevisionComite;
    private int estadoAvalRevisionComite;
    private Date fechaRespuesta;
    private String rutaRespuestaPropuestaTrabajoGrado;

    public RevisionComiteDTORespuesta(){
        
    }
}

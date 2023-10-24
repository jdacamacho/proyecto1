package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionComiteDTORespuesta {
    private int idRevisionComite;
    private Usuario identificacionComitePrograma;
    private String comentariosRevisionComite;
    private int estadoAvalRevisionComite;
    private Date fechaRespuesta;


    public RevisionComiteDTORespuesta(){
        
    }
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionComite {

    private int idRevisionComite;
    private Usuario identificacionComitePrograma;
    private String comentariosRevisionComite;
    private int estadoAvalRevisionComite;
    private Date fechaRespuesta;
    public RevisionComite(){
        
    }

    public RevisionComite(Usuario identificacionComitePrograma,
                        String comentariosRevisionComite,int estadoAvalRevisionComite,
                        Date fechaRespuesta){
        this.identificacionComitePrograma = identificacionComitePrograma;
        this.comentariosRevisionComite = comentariosRevisionComite;
        this.estadoAvalRevisionComite = estadoAvalRevisionComite;
        this.fechaRespuesta = fechaRespuesta;

    }
}

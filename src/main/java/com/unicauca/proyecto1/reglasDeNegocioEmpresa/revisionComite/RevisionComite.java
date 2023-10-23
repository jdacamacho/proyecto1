package com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite;

import java.util.Date;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionComite {

    private int idRevisionComite;
    private Usuario identificacionComitePrograma;
    private PropuestaTrabajoGradoTI_A idPropuestaTrabajoGradoTIA;
    private String comentariosRevisionComite;
    private int estadoAvalRevisionComite;
    private Date fechaRespuesta;
    private String rutaRespuestaPropuestaTrabajoGrado;

    public RevisionComite(){
        
    }

    public RevisionComite(Usuario identificacionComitePrograma,PropuestaTrabajoGradoTI_A idPropuestaTrabajoGradoTI_A,
                        String comentariosRevisionComite,int estadoAvalRevisionComite,
                        Date fechaRespuesta,String rutaRespuestaPropuestaTrabajoGrado){
        this.identificacionComitePrograma = identificacionComitePrograma;
        this.idPropuestaTrabajoGradoTIA = idPropuestaTrabajoGradoTI_A;
        this.comentariosRevisionComite = comentariosRevisionComite;
        this.estadoAvalRevisionComite = estadoAvalRevisionComite;
        this.fechaRespuesta = fechaRespuesta;
        this.rutaRespuestaPropuestaTrabajoGrado = rutaRespuestaPropuestaTrabajoGrado;
    }
}

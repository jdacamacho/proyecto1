package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryRevisionComiteImpl implements factoryRevisionComiteInt{

    @Override
    public RevisionComite crearRevisionComite(Usuario identificacionComitePrograma,
            PropuestaTrabajoGradoTI_A idPropuestaTrabajoGradoTI_A, String comentariosRevisionComite,
            int estadoAvalRevisionComite,Date fechaRespuesta,String rutaRespuestaPropuestaTrabajoGrado) {
       return new RevisionComite(identificacionComitePrograma, idPropuestaTrabajoGradoTI_A, comentariosRevisionComite, estadoAvalRevisionComite,fechaRespuesta,rutaRespuestaPropuestaTrabajoGrado);
    }   
}

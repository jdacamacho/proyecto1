package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface factoryRevisionComiteInt {
    public RevisionComite crearRevisionComite(Usuario identificacionComitePrograma ,
                        String comentariosRevisionComite,int estadoAvalRevisionComite,Date fechaRespuesta);
}

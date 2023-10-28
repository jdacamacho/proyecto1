package com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.TI_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.RevisionComiteTI_AEntity;

@Repository
public class RespuestaComiteRepositoryImpl implements RespuestaComiteRepositoryInt{

    @Autowired
    RespuestaComiteRepositoryJPA respuestaComiteRepositorio;

    public RespuestaComiteRepositoryImpl(){

    }

    @Override
    public RevisionComiteTI_AEntity save(RevisionComiteTI_AEntity objRevision) {
        System.out.println("invocando a guardar revision comite");
        RevisionComiteTI_AEntity objRevisionR = null;
        objRevisionR = respuestaComiteRepositorio.save(objRevision);
        return objRevisionR;
    }
    
}

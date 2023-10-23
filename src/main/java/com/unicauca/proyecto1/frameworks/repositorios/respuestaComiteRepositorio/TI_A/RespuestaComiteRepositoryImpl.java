package com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.TI_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RevisionComiteEntity;

@Repository
public class RespuestaComiteRepositoryImpl implements RespuestaComiteRepositoryInt{

    @Autowired
    RespuestaComiteRepositoryJPA respuestaComiteRepositorio;

    public RespuestaComiteRepositoryImpl(){

    }

    @Override
    public RevisionComiteEntity save(RevisionComiteEntity objRevision) {
        System.out.println("invocando a guardar revision comite");
        RevisionComiteEntity objRevisionR = null;
        objRevisionR = respuestaComiteRepositorio.save(objRevision);
        return objRevisionR;
    }
    
}

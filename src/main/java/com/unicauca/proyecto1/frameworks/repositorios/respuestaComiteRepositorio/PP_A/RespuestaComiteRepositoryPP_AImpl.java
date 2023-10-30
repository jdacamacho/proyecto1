package com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.PP_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.RevisionComitePP_AEntity;

@Repository
public class RespuestaComiteRepositoryPP_AImpl implements RespuestaComiteRepositoryPP_AInt {
    @Autowired
    RespuestaComiteRepositoryPP_AJPA respuestaComiteRepositorio;

    public RespuestaComiteRepositoryPP_AImpl(){

    }

    @Override
    public RevisionComitePP_AEntity save(RevisionComitePP_AEntity objRevision) {
        System.out.println("invocando a guardar revision comite");
        RevisionComitePP_AEntity objRevisionR = null;
        objRevisionR = respuestaComiteRepositorio.save(objRevision);
        return objRevisionR;
    }
}

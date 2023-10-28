package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RevisionComiteEntity;
import com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.TI_A.RespuestaComiteRepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;

@Service
public class GestionarRevisionComiteGatewayImpl implements GestionarRevisionComiteGatewayInt{

    private final RespuestaComiteRepositoryInt revisionComiteRepositorio;
    private final ModelMapper  revisionComiteMapper;

    public GestionarRevisionComiteGatewayImpl(RespuestaComiteRepositoryInt revisionComiteRepositorio,
                        ModelMapper revisionComiteMapper){
        this.revisionComiteRepositorio = revisionComiteRepositorio;
        this.revisionComiteMapper = revisionComiteMapper;
    }

    @Override
    public RevisionComite guardar(RevisionComite revision) {
        RevisionComiteEntity objRevisionEntity = this.revisionComiteMapper.map(revision, RevisionComiteEntity.class);
        RevisionComiteEntity objRevisionEntityRegistrado = this.revisionComiteRepositorio.save(objRevisionEntity);
        RevisionComite objRevisionRespuesta = this.revisionComiteMapper.map(objRevisionEntityRegistrado, RevisionComite.class);
        return objRevisionRespuesta;
    }
    
}
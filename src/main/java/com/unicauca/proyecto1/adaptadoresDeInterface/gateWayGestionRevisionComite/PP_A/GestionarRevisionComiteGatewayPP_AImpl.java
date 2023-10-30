package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.PP_A;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.RevisionComitePP_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.PP_A.RespuestaComiteRepositoryPP_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;

@Service
public class GestionarRevisionComiteGatewayPP_AImpl implements GestionarRevisionComiteGatewayPP_AInt{
    private final RespuestaComiteRepositoryPP_AInt revisionComiteRepositorio;
    private final ModelMapper  revisionComiteMapper;

    public GestionarRevisionComiteGatewayPP_AImpl(RespuestaComiteRepositoryPP_AInt revisionComiteRepositorio,
                        ModelMapper revisionComiteMapper){
        this.revisionComiteRepositorio = revisionComiteRepositorio;
        this.revisionComiteMapper = revisionComiteMapper;
    }

    @Override
    public RevisionComite guardar(RevisionComite revision) {
        RevisionComitePP_AEntity objRevisionEntity = this.revisionComiteMapper.map(revision, RevisionComitePP_AEntity.class);
        RevisionComitePP_AEntity objRevisionEntityRegistrado = this.revisionComiteRepositorio.save(objRevisionEntity);
        RevisionComite objRevisionRespuesta = this.revisionComiteMapper.map(objRevisionEntityRegistrado, RevisionComite.class);
        return objRevisionRespuesta;
    }
}

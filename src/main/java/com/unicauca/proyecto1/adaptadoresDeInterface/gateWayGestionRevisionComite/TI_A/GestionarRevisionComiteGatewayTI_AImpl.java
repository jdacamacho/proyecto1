package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.TI_A;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.RevisionComiteTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.respuestaComiteRepositorio.TI_A.RespuestaComiteRepositoryTI_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;

@Service
public class GestionarRevisionComiteGatewayTI_AImpl implements GestionarRevisionComiteGatewayTI_AInt{

    private final RespuestaComiteRepositoryTI_AInt revisionComiteRepositorio;
    private final ModelMapper  revisionComiteMapper;

    public GestionarRevisionComiteGatewayTI_AImpl(RespuestaComiteRepositoryTI_AInt revisionComiteRepositorio,
                        ModelMapper revisionComiteMapper){
        this.revisionComiteRepositorio = revisionComiteRepositorio;
        this.revisionComiteMapper = revisionComiteMapper;
    }

    @Override
    public RevisionComite guardar(RevisionComite revision) {
        RevisionComiteTI_AEntity objRevisionEntity = this.revisionComiteMapper.map(revision, RevisionComiteTI_AEntity.class);
        RevisionComiteTI_AEntity objRevisionEntityRegistrado = this.revisionComiteRepositorio.save(objRevisionEntity);
        RevisionComite objRevisionRespuesta = this.revisionComiteMapper.map(objRevisionEntityRegistrado, RevisionComite.class);
        return objRevisionRespuesta;
    }
    
}

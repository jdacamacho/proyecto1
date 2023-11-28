package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.RevisionPP_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio.RevisionAnteproyectoPP_BJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionPP_B;


@Service
public class GestionarGatewayRevisionPP_BImpl implements GestionarGatewayRevisionPP_BInt{
    private final RevisionAnteproyectoPP_BJPA repositorioRevision;
    private final ModelMapper mapper;

    public GestionarGatewayRevisionPP_BImpl(RevisionAnteproyectoPP_BJPA repositorioRevision,
                                    ModelMapper mapper){
        this.repositorioRevision = repositorioRevision;
        this.mapper = mapper;
    }

    @Override
    public RevisionPP_B guardar(RevisionPP_B revisionAnteproyecto) {
        RevisionPP_BEntity revisionMapeada = this.mapper.map(revisionAnteproyecto, RevisionPP_BEntity.class);
        RevisionPP_BEntity revisionGuardada = this.repositorioRevision.save(revisionMapeada);
        RevisionPP_B revisionR = this.mapper.map(revisionGuardada, RevisionPP_B.class);
        return revisionR;
    }
}

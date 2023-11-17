package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionTI_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio.RevisionAnteproyectoJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;

@Service
public class GestionarGatewayRevisionTI_BImpl implements GestionarGatewayRevisionTI_BInt{
    private final RevisionAnteproyectoJPA repositorioRevision;
    private final ModelMapper mapper;

    public GestionarGatewayRevisionTI_BImpl(RevisionAnteproyectoJPA repositorioRevision,
                                    ModelMapper mapper){
        this.repositorioRevision = repositorioRevision;
        this.mapper = mapper;
    }

    @Override
    public RevisionTI_B guardar(RevisionTI_B revisionAnteproyecto) {
        RevisionTI_BEntity revisionMapeada = this.mapper.map(revisionAnteproyecto, RevisionTI_BEntity.class);
        RevisionTI_BEntity revisionGuardada = this.repositorioRevision.save(revisionMapeada);
        RevisionTI_B revisionR = this.mapper.map(revisionGuardada, RevisionTI_B.class);
        return revisionR;
    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.RevisionEvaluadorPP_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio.RevisionEvaluadorRepositoryPP_BJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;


@Service
public class GestionarGatewayRevisionEvaluadorPP_BImpl implements GestionarGatewayRevisionEvaluadorPP_BInt{
    private final RevisionEvaluadorRepositoryPP_BJPA repositorioRevisionEvaluador;
    private final ModelMapper mapper;

    public GestionarGatewayRevisionEvaluadorPP_BImpl(RevisionEvaluadorRepositoryPP_BJPA repositorioRevisionEvaluador,
                                            ModelMapper mapper){
        this.repositorioRevisionEvaluador = repositorioRevisionEvaluador;
        this.mapper = mapper;

    }

    @Override
    public RevisionEvaluadorPP_B guardar(RevisionEvaluadorPP_B revision) {
        RevisionEvaluadorPP_BEntity revisionMapeada = this.mapper.map(revision, RevisionEvaluadorPP_BEntity.class);
        RevisionEvaluadorPP_BEntity revisionGuardada = this.repositorioRevisionEvaluador.save(revisionMapeada);
        RevisionEvaluadorPP_B revisionR = this.mapper.map(revisionGuardada, RevisionEvaluadorPP_B.class);
        return revisionR;
    }

    @Override
    public RevisionEvaluadorPP_B consultarPorEvaluador(int idEvaluador) {
        RevisionEvaluadorPP_BEntity revisionConsultada = this.repositorioRevisionEvaluador.findById(idEvaluador).get();
        RevisionEvaluadorPP_B revisionR = this.mapper.map(revisionConsultada, RevisionEvaluadorPP_B.class);
        return revisionR;
    }

    @Override
    public boolean existeRevisionEvaluador(int idRevision) {
       return this.repositorioRevisionEvaluador.findById(idRevision).isPresent();
    }

    @Override
    public List<RevisionEvaluadorPP_B> listarAnteproyectoConcepto(String concepto) {
        List<RevisionEvaluadorPP_BEntity> lista = this.repositorioRevisionEvaluador.findByConceptoRevision(concepto);
        List<RevisionEvaluadorPP_B> listaObtenida = this.mapper.map(lista,
                new TypeToken<List<RevisionEvaluadorPP_B>>() {
                }.getType()); 
        return listaObtenida;
    }

    @Override
    public RevisionEvaluadorPP_B consultarRevisionEvaluador(int idRevision) {
        RevisionEvaluadorPP_BEntity revisionEntity = this.repositorioRevisionEvaluador.findById(idRevision).get();
        RevisionEvaluadorPP_B revisionR = this.mapper.map(revisionEntity, RevisionEvaluadorPP_B.class);
        return revisionR;
    }

}

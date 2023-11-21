package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionEvaluadorTI_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio.RevisionEvaluadorRepositoryJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;

@Service
public class GestionarGatewayRevisionEvaluadorTI_BImpl implements GestionarGatewayRevisionEvaluadorTI_BInt{
    private final RevisionEvaluadorRepositoryJPA repositorioRevisionEvaluador;
    private final ModelMapper mapper;

    public GestionarGatewayRevisionEvaluadorTI_BImpl(RevisionEvaluadorRepositoryJPA repositorioRevisionEvaluador,
                                            ModelMapper mapper){
        this.repositorioRevisionEvaluador = repositorioRevisionEvaluador;
        this.mapper = mapper;

    }

    @Override
    public RevisionEvaluadorTI_B guardar(RevisionEvaluadorTI_B revision) {
        RevisionEvaluadorTI_BEntity revisionMapeada = this.mapper.map(revision, RevisionEvaluadorTI_BEntity.class);
        RevisionEvaluadorTI_BEntity revisionGuardada = this.repositorioRevisionEvaluador.save(revisionMapeada);
        RevisionEvaluadorTI_B revisionR = this.mapper.map(revisionGuardada, RevisionEvaluadorTI_B.class);
        return revisionR;
    }

    @Override
    public RevisionEvaluadorTI_B consultarPorEvaluador(int idEvaluador) {
        RevisionEvaluadorTI_BEntity revisionConsultada = this.repositorioRevisionEvaluador.findById(idEvaluador).get();
        RevisionEvaluadorTI_B revisionR = this.mapper.map(revisionConsultada, RevisionEvaluadorTI_B.class);
        return revisionR;
    }

    @Override
    public boolean existeRevisionEvaluador(int idRevision) {
       return this.repositorioRevisionEvaluador.findById(idRevision).isPresent();
    }

    @Override
    public List<RevisionEvaluadorTI_B> listarAnteproyectoConcepto(String concepto) {
        List<RevisionEvaluadorTI_BEntity> lista = this.repositorioRevisionEvaluador.findByConceptoRevision(concepto);
        List<RevisionEvaluadorTI_B> listaObtenida = this.mapper.map(lista,
                new TypeToken<List<RevisionEvaluadorTI_B>>() {
                }.getType()); 
        return listaObtenida;
    }

    @Override
    public RevisionEvaluadorTI_B consultarRevisionEvaluador(int idRevision) {
        RevisionEvaluadorTI_BEntity revisionEntity = this.repositorioRevisionEvaluador.findById(idRevision).get();
        RevisionEvaluadorTI_B revisionR = this.mapper.map(revisionEntity, RevisionEvaluadorTI_B.class);
        return revisionR;
    }

}

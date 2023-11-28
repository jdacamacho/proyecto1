package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.RevisionEvaluadorPP_BEntity;

@Repository
public interface RevisionEvaluadorRepositoryPP_BJPA extends CrudRepository<RevisionEvaluadorPP_BEntity,Integer> {
    List<RevisionEvaluadorPP_BEntity> findByConceptoRevision(String concepto);
    RevisionEvaluadorPP_BEntity findByIdentificacionEvaluador(UsuarioEntity identificacionEvaluador);
}

package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.RevisionEvaluadorPP_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.RevisionPP_BEntity;

@Repository
public interface RevisionAnteproyectoPP_BJPA  extends CrudRepository<RevisionPP_BEntity,Integer>{
    RevisionPP_BEntity findByIdentificacionEvaluador1(RevisionEvaluadorPP_BEntity identificacionEvaluador1);
    RevisionPP_BEntity findByIdentificacionEvaluador2(RevisionEvaluadorPP_BEntity identificacionEvaluador2);
}
package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionEvaluadorTI_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionTI_BEntity;

@Repository
public interface RevisionAnteproyectoJPA  extends CrudRepository<RevisionTI_BEntity,Integer>{
    RevisionTI_BEntity findByIdentificacionEvaluador1(RevisionEvaluadorTI_BEntity identificacionEvaluador1);
    RevisionTI_BEntity findByIdentificacionEvaluador2(RevisionEvaluadorTI_BEntity identificacionEvaluador2);
}

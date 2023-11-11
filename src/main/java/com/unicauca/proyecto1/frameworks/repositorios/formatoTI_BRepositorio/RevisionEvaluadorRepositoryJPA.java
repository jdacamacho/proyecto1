package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;

@Repository
public interface RevisionEvaluadorRepositoryJPA extends CrudRepository<RevisionEvaluadorTI_B,Integer> {
    
}

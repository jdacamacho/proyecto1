package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;

@Repository
public interface FormatoTI_ARepositoryJPA extends CrudRepository<PropuestaTrabajoGradoTI_AEntity,Integer>{
   
}

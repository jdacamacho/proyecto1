package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public interface FormatoTI_ARepositoryJPA extends CrudRepository<PropuestaTrabajoGradoTI_AEntity,Integer>{
    public List<PropuestaTrabajoGradoTI_AEntity> findByIdentificacionDirectorTIA(UsuarioEntity identificacionDirector);
}

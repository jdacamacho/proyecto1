package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_ARepositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.PropuestaTrabajoGradoPP_AEntity;

@Repository
public interface FormatoPP_ARepositoryJPA extends CrudRepository<PropuestaTrabajoGradoPP_AEntity,Integer>{
    public List<PropuestaTrabajoGradoPP_AEntity> findByIdentificacionDirectorPPA (UsuarioEntity identificacionDirector);
}

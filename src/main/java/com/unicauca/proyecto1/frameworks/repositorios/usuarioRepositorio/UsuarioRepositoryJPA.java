package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public interface UsuarioRepositoryJPA  extends CrudRepository<UsuarioEntity,Integer>{

}

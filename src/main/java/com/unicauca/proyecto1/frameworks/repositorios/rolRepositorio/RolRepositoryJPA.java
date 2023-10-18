package com.unicauca.proyecto1.frameworks.repositorios.rolRepositorio;


import org.springframework.data.repository.CrudRepository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;

public interface RolRepositoryJPA extends CrudRepository<RolEntity,Integer>{

}

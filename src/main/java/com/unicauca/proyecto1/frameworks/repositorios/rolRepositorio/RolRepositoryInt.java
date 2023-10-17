package com.unicauca.proyecto1.frameworks.repositorios.rolRepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;

public interface RolRepositoryInt {
    public List<RolEntity> findAll();
}

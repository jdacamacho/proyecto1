package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

public interface UsuarioRepositoryInt {

    public List<UsuarioEntity> findAll();
    public UsuarioEntity findById(Integer id);
    public UsuarioEntity save(UsuarioEntity objUsuario);
    public UsuarioEntity update(Integer id, UsuarioEntity objUsuario);
}

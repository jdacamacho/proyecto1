package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.LoginEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

public interface UsuarioRepositoryInt {

    public List<UsuarioEntity> findAll();
    public List<UsuarioEntity> findByRole(String rol);
    public List<UsuarioEntity> buscarUsuariosPorFiltros(int id, String nombreUsuario, String loginUsuario, Integer userState);
    public UsuarioEntity findById(Integer id);
    public UsuarioEntity save(UsuarioEntity objUsuario);
    public UsuarioEntity update(Integer id, UsuarioEntity objUsuario);
    public boolean existeUsuario(int identificacionUsuario);
    public UsuarioEntity buscarPorLogin(LoginEntity loginEntity);
    public List<UsuarioEntity> buscarUsuariosPorRol(RolEntity rol);
}

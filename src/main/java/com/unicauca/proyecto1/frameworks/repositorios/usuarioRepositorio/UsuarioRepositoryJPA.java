package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;


@Repository
public interface UsuarioRepositoryJPA  extends CrudRepository<UsuarioEntity,Integer>{
    @Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.roles r WHERE u.loginUsuario.userNameLogin = :userName")
    UsuarioEntity findByUserNameWithRoles(@Param("userName") String userName);

    @Query("SELECT u FROM UsuarioEntity u JOIN u.roles r WHERE r = :rol")
    List<UsuarioEntity> findUserByRol(@Param("rol") RolEntity rol);
}

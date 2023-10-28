package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;


@Repository
public interface UsuarioRepositoryJPA  extends CrudRepository<UsuarioEntity,Integer>{
    @Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.roles r WHERE u.loginUsuario.userNameLogin = :userName")
    UsuarioEntity findByUserNameWithRoles(@Param("userName") String userName);

    @Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.roles r WHERE r.tipoRol = :tipoRol")
    List<UsuarioEntity> findByUserRoles(@Param("tipoRol") String tipoRol);

    @Query("SELECT DISTINCT u FROM UsuarioEntity u " +
       // "JOIN FETCH u.roles r " +
       "WHERE u.identificacionUsuario = :identificacionUsuario " +
       "OR u.nombresUsuario LIKE %:nombresUsuario% " +
       "OR u.loginUsuario.userNameLogin LIKE %:loginUsuario%")
    List<UsuarioEntity> findByFilters(
        @Param("identificacionUsuario") int identificacionUsuario,
        @Param("nombresUsuario") String nombresUsuario,
        @Param("loginUsuario") String loginUsuario
        // @Param("estadoUsuario") int estadoUsuario
    );
}

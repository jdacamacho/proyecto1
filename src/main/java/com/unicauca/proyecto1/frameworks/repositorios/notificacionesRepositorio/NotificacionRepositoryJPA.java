package com.unicauca.proyecto1.frameworks.repositorios.notificacionesRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.NotificacionEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

import java.util.List;


@Repository
public interface NotificacionRepositoryJPA  extends CrudRepository<NotificacionEntity,Integer>{
    List<NotificacionEntity> findByUsuarioReceptor(UsuarioEntity usuarioReceptor);
}

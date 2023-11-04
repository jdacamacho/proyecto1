package com.unicauca.proyecto1.frameworks.repositorios.notificacionesRepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.NotificacionEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

public interface NotificacionRepositoryInt {
    List<NotificacionEntity> findByReceptor(UsuarioEntity receptor);
    NotificacionEntity save(NotificacionEntity notificacion);
}

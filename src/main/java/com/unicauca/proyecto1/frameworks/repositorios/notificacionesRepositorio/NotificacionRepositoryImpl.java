package com.unicauca.proyecto1.frameworks.repositorios.notificacionesRepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.NotificacionEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public class NotificacionRepositoryImpl implements NotificacionRepositoryInt{

    @Autowired
    NotificacionRepositoryJPA repositorioNotificaciones;

    public NotificacionRepositoryImpl(){

    }

    @Override
    public List<NotificacionEntity> findByReceptor(UsuarioEntity receptor) {
        System.out.println("Invocando a listar mensajes");
        Iterable<NotificacionEntity> iterable = this.repositorioNotificaciones.findByUsuarioReceptor(receptor);
        List<NotificacionEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public NotificacionEntity save(NotificacionEntity notificacion) {
        System.out.println("Invocando a guardar notificacion");
        NotificacionEntity objNotificacionR = null;
        objNotificacionR = this.repositorioNotificaciones.save(notificacion);
        return objNotificacionR;
    }
    
}

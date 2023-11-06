package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Notificacion;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTORespuesta.NotificacionDTORespuesta;

public interface GestionarNotificacionCUInt {
    List<NotificacionDTORespuesta> listarPorUsuario(int idUsuario);
}

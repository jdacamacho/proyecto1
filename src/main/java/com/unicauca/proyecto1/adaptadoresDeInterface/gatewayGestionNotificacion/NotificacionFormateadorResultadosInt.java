package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTORespuesta.NotificacionDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;

public interface NotificacionFormateadorResultadosInt {
    public List<NotificacionDTORespuesta> prepararRespuestaSatisfactoriaListarNotificaciones(List<Notificacion> notificaciones);

}

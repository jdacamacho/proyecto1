package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTORespuesta.NotificacionDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;

@Service
public class NotificacionFormateadorResultadosImpl implements NotificacionFormateadorResultadosInt{

    private final ModelMapper notificacionMapper;

    public NotificacionFormateadorResultadosImpl(ModelMapper notificacionMapper){
        this.notificacionMapper = notificacionMapper;
    }

    @Override
    public List<NotificacionDTORespuesta> prepararRespuestaSatisfactoriaListarNotificaciones(
            List<Notificacion> notificaciones) {
        List<NotificacionDTORespuesta> listaObtenida = this.notificacionMapper.map(notificaciones,
        new TypeToken<List<NotificacionDTORespuesta>>() {
        }.getType());
        return listaObtenida;
    }
    
}

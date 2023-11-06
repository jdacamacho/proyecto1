package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTORespuesta.NotificacionDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Notificacion.GestionarNotificacionCUInt;

@RestController
@RequestMapping("/apiNotificaciones")
public class NotificacionRestController {
    
    private final GestionarNotificacionCUInt objGestionarNotificacionCU;

    public NotificacionRestController(GestionarNotificacionCUInt objGestionarNotificacionCUInt){
        this.objGestionarNotificacionCU = objGestionarNotificacionCUInt;
    }

    @GetMapping("/notificaciones/{identificacion}")
    public List<NotificacionDTORespuesta> listarPorUsuario(@PathVariable Integer identificacion){
        return this.objGestionarNotificacionCU.listarPorUsuario(identificacion);
    }

}

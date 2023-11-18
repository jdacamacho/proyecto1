package com.unicauca.proyecto1.SocketConfig;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;

@Controller
public class NotificadorController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Notificador enviarNotificacion(Notificacion notificacion) throws Exception {
        System.out.println("Notificación recibida: " + notificacion.getMensaje());
        return new Notificador("Nueva notificación\n" + notificacion.getMensaje());
    }
    
}

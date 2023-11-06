package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion;


import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarNotificacionGatewayInt {
    public Notificacion guardar(Notificacion notificacion);
    public List<Notificacion> listarPorUsuario(Usuario objUsuarioReceptor);
}

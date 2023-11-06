package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Notificacion;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTORespuesta.NotificacionDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.NotificacionFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarNotificacionCU implements GestionarNotificacionCUInt {
    
    private final GestionarNotificacionGatewayInt objGestionarNotificacionGateway;
    private final NotificacionFormateadorResultadosInt objFormateadorResultadosNotificacion;
    private final GestionarUsuarioGatewayInt objGestionarUsuarioGateway;
    
    public GestionarNotificacionCU(
        GestionarNotificacionGatewayInt objGestionarNotificacionGateway,
        NotificacionFormateadorResultadosInt objFormateadorResultados,
        GestionarUsuarioGatewayInt objGestionarUsuarioGateway
    ){
        this.objGestionarNotificacionGateway = objGestionarNotificacionGateway;
        this.objFormateadorResultadosNotificacion = objFormateadorResultados;
        this.objGestionarUsuarioGateway = objGestionarUsuarioGateway;
    }
    
    @Override
    public List<NotificacionDTORespuesta> listarPorUsuario(int idUsuario) {
        List<Notificacion> listaVacia = null;
        if(this.objGestionarUsuarioGateway.existeUsuario(idUsuario)){
            Usuario Usuario = this.objGestionarUsuarioGateway.consultarUsuario(idUsuario);
            List<Notificacion> listaRespuesta = this.objGestionarNotificacionGateway.listarPorUsuario(Usuario);
            return this.objFormateadorResultadosNotificacion.prepararRespuestaSatisfactoriaListarNotificaciones(listaRespuesta);
        }
        return this.objFormateadorResultadosNotificacion.prepararRespuestaSatisfactoriaListarNotificaciones(listaVacia);
    }
    
}

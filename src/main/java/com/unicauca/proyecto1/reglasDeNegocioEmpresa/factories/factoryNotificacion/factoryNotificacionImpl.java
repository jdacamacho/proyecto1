package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryNotificacionImpl implements factoryNotificacionInt {

    @Override
    public Notificacion crearNotificacion(Usuario usuarioEmisor, Usuario usuarioReceptor, String mensaje,
            Date fecha) {
        Notificacion notificacion = new Notificacion(usuarioEmisor,usuarioReceptor,mensaje,fecha);
        return notificacion;
    }
    
}

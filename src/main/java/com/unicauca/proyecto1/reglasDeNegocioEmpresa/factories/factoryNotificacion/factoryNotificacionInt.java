package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface factoryNotificacionInt {
    public Notificacion crearNotificacion(Usuario usuarioEmisor,Usuario usuarioReceptor,
                                        String mensaje,Date fecha);
}

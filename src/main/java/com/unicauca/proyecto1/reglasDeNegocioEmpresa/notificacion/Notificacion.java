package com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notificacion {
    private int idNotificaciones;
    private Usuario usuarioEmisor;
    private Usuario usuarioReceptor;
    private String mensaje;
    private Date fecha;

    public Notificacion(){
        
    }

    public Notificacion(Usuario usuarioEmisor,Usuario usuarioReceptor,String mensaje,Date fecha){
        this.usuarioEmisor = usuarioEmisor;
        this.usuarioReceptor = usuarioReceptor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }
}

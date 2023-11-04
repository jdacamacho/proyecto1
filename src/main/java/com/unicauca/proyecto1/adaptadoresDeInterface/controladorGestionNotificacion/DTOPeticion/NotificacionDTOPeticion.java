package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionNotificacion.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificacionDTOPeticion {
    private int usuarioEmisor;
    private int usuarioReceptor;
    private String mensaje;

    public NotificacionDTOPeticion(){
        
    }
}

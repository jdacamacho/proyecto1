package com.unicauca.proyecto1.SocketConfig;

import lombok.Data;

@Data
public class Notificador {
    private String message;

    public Notificador(String message) {
        this.message = message;
    }
}

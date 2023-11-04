package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "notificaciones")
public class NotificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotificaciones")
    private int idNotificaciones;

    @ManyToOne
    @JoinColumn(name = "identificacionemisor")
    private UsuarioEntity usuarioEmisor;

    @ManyToOne
    @JoinColumn(name = "identificacionreceptor")
    private UsuarioEntity usuarioReceptor;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha")
    private Date fecha;

    public NotificacionEntity(){
        
    }
}

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
@Table(name = "Notificaciones")
public class NotificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotificaciones")
    private int idNotificaciones;

    @ManyToOne
    @JoinColumn(name = "identificacionEmisor")
    private UsuarioEntity usuarioEmisor;

    @ManyToOne
    @JoinColumn(name = "identificacionReceptor")
    private UsuarioEntity usuarioReceptor;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha")
    private Date fecha;

    public NotificacionEntity(){
        
    }
}

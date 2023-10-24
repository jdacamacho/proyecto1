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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "revisioncomiteti_a")
public class RevisionComiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrevisioncomite")
    private int idRevisionComite;

    @ManyToOne
    @JoinColumn(name = "identificacioncomiteprograma")
    private UsuarioEntity identificacionComitePrograma;

    @ManyToOne
    @JoinColumn(name = "idpropuestatrabajogradotia",nullable = false)
    private PropuestaTrabajoGradoTI_AEntity idPropuestaTrabajoGradoTIA;

    @Column(name = "comentariosrevisioncomite")
    private String comentariosRevisionComite;

    @Column(name = "estadoavalrevisioncomite")
    private int estadoAvalRevisionComite;

    @Column(name = "fecharespuesta")
    private Date fechaRespuesta;

    @Column(name = "rutarespuestapropuestatrabajogrado")
    private String rutaRespuestaPropuestaTrabajoGrado;


    public RevisionComiteEntity(){

    }
}

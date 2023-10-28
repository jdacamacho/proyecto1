package com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A;

import java.util.Date;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

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
public class RevisionComiteTI_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrevisioncomite")
    private int idRevisionComite;

    @ManyToOne
    @JoinColumn(name = "identificacioncomiteprograma")
    private UsuarioEntity identificacionComitePrograma;

    @Column(name = "comentariosrevisioncomite")
    private String comentariosRevisionComite;

    @Column(name = "estadoavalrevisioncomite")
    private int estadoAvalRevisionComite;

    @Column(name = "fecharespuesta")
    private Date fechaRespuesta;

    public RevisionComiteTI_AEntity(){

    }
}

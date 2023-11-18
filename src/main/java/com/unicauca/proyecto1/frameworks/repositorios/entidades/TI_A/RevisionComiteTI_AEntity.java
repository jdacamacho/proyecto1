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
@Table(name = "RevisionesComiteTI_A")
public class RevisionComiteTI_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevisionComite")
    private int idRevisionComite;

    @ManyToOne
    @JoinColumn(name = "identificacionComitePrograma")
    private UsuarioEntity identificacionComitePrograma;

    @Column(name = "comentariosRevisionComite")
    private String comentariosRevisionComite;

    @Column(name = "estadoAvalRevisionComite")
    private int estadoAvalRevisionComite;

    @Column(name = "fechaRespuesta")
    private Date fechaRespuesta;

    public RevisionComiteTI_AEntity(){

    }
}

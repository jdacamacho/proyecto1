package com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A;

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
@Table(name = "RevisionesComitePP_A")
public class RevisionComitePP_AEntity {
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

    public RevisionComitePP_AEntity(){

    }
}

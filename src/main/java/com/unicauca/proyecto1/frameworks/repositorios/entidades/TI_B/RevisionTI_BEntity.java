package com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "revisionti_b")
@Data
@AllArgsConstructor
public class RevisionTI_BEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrevision")
    private int idRevision;

    @ManyToOne
    @JoinColumn(name = "idrevisionevaluador1")
    private RevisionEvaluadorTI_BEntity identificacionEvaluador1;

    @ManyToOne
    @JoinColumn(name = "idrevisionevaluador2")
    private RevisionEvaluadorTI_BEntity identificacionEvaluador2;

    @Column(name = "tipoformato")
    private String tipoFormato;

    public RevisionTI_BEntity(){

    }
}

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

@Entity(name = "RevisionesAnteproyectoTI_B")
@Data
@AllArgsConstructor
public class RevisionTI_BEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevision")
    private int idRevision;

    @ManyToOne
    @JoinColumn(name = "idRevisionEvaluador1")
    private RevisionEvaluadorTI_BEntity identificacionEvaluador1;

    @ManyToOne
    @JoinColumn(name = "idRevisionEvaluador2")
    private RevisionEvaluadorTI_BEntity identificacionEvaluador2;

    public RevisionTI_BEntity(){

    }
}

package com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B;

import java.util.Date;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "revisionevaluadorti_b")
@Data
@AllArgsConstructor
public class RevisionEvaluadorTI_BEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name = "idrevisionevaluadortib")
    private int idRevisionEvaluadorTIB;

    @ManyToOne
    @JoinColumn(name = "identificacionevaluador")
    private UsuarioEntity identificacionEvaluador;

    @Column(name = "fechaasignacionrevisionevaluador")
    private Date fechaAsignacion;

   @Column(name = "fechaconceptorevisionevaluador")
    private Date fechaConcepto;

    @Column(name = "conceptorevisionevaluador")
    private String conceptoRevision;

    @Column(name = "observacionesrevisionevaluador")
    private String observaciones;

    @Column(name = "rutarespuesta")
    private String rutaRespuesta;

    public RevisionEvaluadorTI_BEntity(){

    }

}

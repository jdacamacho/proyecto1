package com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B;

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

@Entity(name = "RevisionesEvaluadorPP_B")
@Data
@AllArgsConstructor
public class RevisionEvaluadorPP_BEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    @Column(name = "idRevisionEvaluadorPP_B")
    private int idRevisionEvaluadorPPB;

    @ManyToOne
    @JoinColumn(name = "identificacionEvaluador")
    private UsuarioEntity identificacionEvaluador;

    @Column(name = "fechaAsignacionRevisionEvaluador")
    private Date fechaAsignacion;

   @Column(name = "fechaConceptoRevisionEvaluador")
    private Date fechaConcepto;

    @Column(name = "conceptoRevisionEvaluador")
    private String conceptoRevision;

    @Column(name = "observacionesRevisionEvaluador")
    private String observaciones;

    @Column(name = "rutaRespuesta")
    private String rutaRespuesta;

    @Column(name = "rutaAnteproyectoRevisado")
    private String rutaAnteproyectoRevisado;

    public RevisionEvaluadorPP_BEntity(){

    }
}

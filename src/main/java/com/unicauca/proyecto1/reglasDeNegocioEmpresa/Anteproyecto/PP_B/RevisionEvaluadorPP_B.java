package com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionEvaluadorPP_B {
    private int idRevisionEvaluadorPPB;
    private Usuario identificacionEvaluador;
    private Date fechaAsignacion;
    private Date fechaConcepto;
    private String conceptoRevision;
    private String observaciones;
    private String rutaRespuesta;
    private String rutaAnteproyectoRevisado;

    public RevisionEvaluadorPP_B(){
        
    }
}

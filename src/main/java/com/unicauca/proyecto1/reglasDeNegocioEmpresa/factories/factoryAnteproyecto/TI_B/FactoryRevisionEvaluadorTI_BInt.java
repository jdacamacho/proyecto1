package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface FactoryRevisionEvaluadorTI_BInt {
    public RevisionEvaluadorTI_B crearRevisionEvaluador(int idRevisionEvaluadorTIB,Usuario identificacionEvaluador,
                                                       Date fechaConcepto,String conceptoRevision,
                                                       String observaciones,String rutaRespuesta,
                                                       String rutaAnteproyectoRevisado);
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface FactoryRevisionEvaluadorPP_BInt {
    public RevisionEvaluadorPP_B crearRevisionEvaluador(int idRevisionEvaluadorTIB,Usuario identificacionEvaluador,
                                                       Date fechaConcepto,String conceptoRevision,
                                                       String observaciones,String rutaRespuesta,
                                                       String rutaAnteproyectoRevisado);
}

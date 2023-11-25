package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class FactoryRevisionEvaluadorPP_BImpl implements FactoryRevisionEvaluadorPP_BInt {

    @Override
    public RevisionEvaluadorPP_B crearRevisionEvaluador(int idRevisionEvaluadorTIB, Usuario identificacionEvaluador,
            Date fechaConcepto, String conceptoRevision, String observaciones, String rutaRespuesta,String rutaAnteproyectoCorregido) {
        RevisionEvaluadorPP_B revisionEvaluador = new RevisionEvaluadorPP_B(idRevisionEvaluadorTIB,identificacionEvaluador,
                                                                            new Date(),fechaConcepto,conceptoRevision,
                                                                            observaciones,rutaRespuesta,rutaAnteproyectoCorregido);
        return revisionEvaluador;
    }
    
}

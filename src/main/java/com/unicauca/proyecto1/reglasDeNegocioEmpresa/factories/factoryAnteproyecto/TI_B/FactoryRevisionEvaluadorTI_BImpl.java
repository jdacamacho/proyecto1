package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class FactoryRevisionEvaluadorTI_BImpl implements FactoryRevisionEvaluadorTI_BInt {

    @Override
    public RevisionEvaluadorTI_B crearRevisionEvaluador(int idRevisionEvaluadorTIB, Usuario identificacionEvaluador,
            Date fechaConcepto, String conceptoRevision, String observaciones, String rutaRespuesta,String rutaAnteproyectoCorregido) {
        RevisionEvaluadorTI_B revisionEvaluador = new RevisionEvaluadorTI_B(idRevisionEvaluadorTIB,identificacionEvaluador,
                                                                            new Date(),fechaConcepto,conceptoRevision,
                                                                            observaciones,rutaRespuesta,rutaAnteproyectoCorregido);
        return revisionEvaluador;
    }
    
}

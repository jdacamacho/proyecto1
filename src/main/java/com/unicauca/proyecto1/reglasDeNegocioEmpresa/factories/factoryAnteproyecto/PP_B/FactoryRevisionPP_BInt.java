package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionPP_B;

public interface FactoryRevisionPP_BInt {
    public RevisionPP_B crearRevisionAnteproyecto(int idRevision,RevisionEvaluadorPP_B revision1,
                                                RevisionEvaluadorPP_B revision2);
}

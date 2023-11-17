package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;

public interface FactoryRevisionTI_BInt {
    public RevisionTI_B crearRevisionAnteproyecto(int idRevision,RevisionEvaluadorTI_B revision1,
                                                RevisionEvaluadorTI_B revision2);
}

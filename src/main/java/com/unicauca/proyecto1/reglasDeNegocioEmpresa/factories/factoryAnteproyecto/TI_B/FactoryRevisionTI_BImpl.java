package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;

public class FactoryRevisionTI_BImpl implements FactoryRevisionTI_BInt {

    @Override
    public RevisionTI_B crearRevisionAnteproyecto(int idRevision, RevisionEvaluadorTI_B revision1,
            RevisionEvaluadorTI_B revision2) {
        RevisionTI_B revisionAnteproyecto = new RevisionTI_B(idRevision,revision1,revision2);
        return revisionAnteproyecto;
    }
    
}

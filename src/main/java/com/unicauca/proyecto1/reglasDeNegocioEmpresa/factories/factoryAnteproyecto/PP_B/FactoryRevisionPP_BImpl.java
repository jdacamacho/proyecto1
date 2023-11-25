package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionPP_B;


public class FactoryRevisionPP_BImpl implements FactoryRevisionPP_BInt {

    @Override
    public RevisionPP_B crearRevisionAnteproyecto(int idRevision, RevisionEvaluadorPP_B revision1,
            RevisionEvaluadorPP_B revision2) {
        RevisionPP_B revisionAnteproyecto = new RevisionPP_B(idRevision,revision1,revision2);
        return revisionAnteproyecto;
    }
    
}

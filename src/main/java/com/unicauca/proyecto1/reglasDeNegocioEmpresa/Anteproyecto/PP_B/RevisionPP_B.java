package com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionPP_B {
    private int idRevision;
    private RevisionEvaluadorPP_B identificacionEvaluador1;
    private RevisionEvaluadorPP_B identificacionEvaluador2;

    public RevisionPP_B(){

    }
}

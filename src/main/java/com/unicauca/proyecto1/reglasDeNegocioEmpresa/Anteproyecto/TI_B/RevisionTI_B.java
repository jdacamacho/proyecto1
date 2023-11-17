package com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionTI_B {
    private int idRevision;
    private RevisionEvaluadorTI_B identificacionEvaluador1;
    private RevisionEvaluadorTI_B identificacionEvaluador2;

    public RevisionTI_B(){
        
    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionTI_BDTORespuesta {
    private int idRevision;
    private RevisionEvaluadorTI_BDTORespuesta identificacionEvaluador1;
    private RevisionEvaluadorTI_BDTORespuesta identificacionEvaluador2;
    private String tipoFormato;

    public RevisionTI_BDTORespuesta(){
        
    }
}

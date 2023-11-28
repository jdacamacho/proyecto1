package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionPP_BDTORespuesta {
    private int idRevision;
    private RevisionEvaluadorPP_BDTORespuesta identificacionEvaluador1;
    private RevisionEvaluadorPP_BDTORespuesta identificacionEvaluador2;

    public RevisionPP_BDTORespuesta(){

    }
}

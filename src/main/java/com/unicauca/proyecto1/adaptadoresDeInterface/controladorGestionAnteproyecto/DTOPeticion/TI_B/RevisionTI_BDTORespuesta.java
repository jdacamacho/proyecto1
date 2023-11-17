package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionTI_BDTORespuesta {
    private int idRevision;
    private RevisionEvaluadorTI_BDTORespuesta identificacionEvaluador1;
    private RevisionEvaluadorTI_BDTORespuesta identificacionEvaluador2;

    public RevisionTI_BDTORespuesta(){
        
    }
}

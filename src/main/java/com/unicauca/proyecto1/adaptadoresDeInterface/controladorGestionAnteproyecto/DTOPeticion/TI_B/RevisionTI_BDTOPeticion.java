package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionTI_BDTOPeticion {
    private int idRevision;
    private RevisionEvaluadorTI_BDTOPeticion identificacionEvaluador1;
    private RevisionEvaluadorTI_BDTOPeticion identificacionEvaluador2;

    public RevisionTI_BDTOPeticion(){
        
    }
}

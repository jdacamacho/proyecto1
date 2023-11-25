package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionPP_BDTOPeticion {
    private int idRevision;
    private RevisionEvaluadorPP_BDTOPeticion identificacionEvaluador1;
    private RevisionEvaluadorPP_BDTOPeticion identificacionEvaluador2;

    public RevisionPP_BDTOPeticion(){

    }
}

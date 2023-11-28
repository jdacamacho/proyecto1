package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionEvaluadorPP_BDTOPeticion {
    private int idRevisionEvaluadorPPB;
    private int identificacionEvaluador;
    private String idAnteproyecto;
    private String conceptoRevision;
    private String observaciones;

    public RevisionEvaluadorPP_BDTOPeticion(){

    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RevisionEvaluadorTI_BDTOPeticion {
    private int idRevisionEvaluadorTIB;
    private int identificacionEvaluador;
    private String idAnteproyecto;
    private String conceptoRevision;
    private String observaciones;

    public RevisionEvaluadorTI_BDTOPeticion(){
        
    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;

public interface RevisionEvaluadorTI_BFormateadorResultadosInt {
    public List<RevisionEvaluadorTI_BDTORespuesta> prepararRespuestaSatisfactoriaListar(List<RevisionEvaluadorTI_B> revisionesEvaluador);
}

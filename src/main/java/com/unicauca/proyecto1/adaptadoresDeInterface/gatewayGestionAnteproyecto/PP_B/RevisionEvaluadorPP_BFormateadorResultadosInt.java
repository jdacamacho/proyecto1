package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.RevisionEvaluadorPP_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;

public interface RevisionEvaluadorPP_BFormateadorResultadosInt {
    public List<RevisionEvaluadorPP_BDTORespuesta> prepararRespuestaSatisfactoriaListar(List<RevisionEvaluadorPP_B> revisionesEvaluador);
}

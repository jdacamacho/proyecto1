package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;

public interface PropuestaTrabajoGradoPP_AFormateadorResultadosInt {
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> prepararRespuestaSatisfactoriaListarPropuestas(List<PropuestaTrabajoGradoPP_A> objPropuestas);
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaCrearPropuesta(PropuestaTrabajoGradoPP_A objPropuesta);
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaConsultarPropuesta(PropuestaTrabajoGradoPP_A objPropuesta);
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaFallida(String error);
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaModificarPropuesta(PropuestaTrabajoGradoPP_A objPropuestaModificado);
}

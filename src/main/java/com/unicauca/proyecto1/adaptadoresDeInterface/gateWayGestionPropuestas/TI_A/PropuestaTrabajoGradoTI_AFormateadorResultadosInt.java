package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;

public interface PropuestaTrabajoGradoTI_AFormateadorResultadosInt {
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> prepararRespuestaSatisfactoriaListarPropuestas(List<PropuestaTrabajoGradoTI_A> objPropuestas);
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaCrearPropuesta(PropuestaTrabajoGradoTI_A objPropuesta);
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaConsultarPropuesta(PropuestaTrabajoGradoTI_A objPropuesta);
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaFallida(String error);
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaModificarPropuesta(PropuestaTrabajoGradoTI_A objPropuestaModificado);
            
}

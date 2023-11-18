package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;

public interface AnteproyectoTI_BFormateadorResultadosInt {
    public List<AnteproyectoTI_BDTORespuesta> prepararRespuestaSatisfactoriaListar(List<AnteproyectoTI_B> anteproyectos);
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaCrearAnteproyecto(AnteproyectoTI_B anteproyecto);
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaModificarAnteproyecto(AnteproyectoTI_B anteproyecto);
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaConsultarAnteproyecto(AnteproyectoTI_B anteproyecto);
    public AnteproyectoTI_BDTORespuesta prepararRespuestaFallida(String error);
}

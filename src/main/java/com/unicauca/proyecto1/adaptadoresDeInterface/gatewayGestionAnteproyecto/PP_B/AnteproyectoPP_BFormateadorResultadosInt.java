package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.AnteproyectoPP_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;

public interface AnteproyectoPP_BFormateadorResultadosInt {
    public List<AnteproyectoPP_BDTORespuesta> prepararRespuestaSatisfactoriaListar(List<AnteproyectoPP_B> anteproyectos);
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaCrearAnteproyecto(AnteproyectoPP_B anteproyecto);
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaModificarAnteproyecto(AnteproyectoPP_B anteproyecto);
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaConsultarAnteproyecto(AnteproyectoPP_B anteproyecto);
    public AnteproyectoPP_BDTORespuesta prepararRespuestaFallida(String error);
}

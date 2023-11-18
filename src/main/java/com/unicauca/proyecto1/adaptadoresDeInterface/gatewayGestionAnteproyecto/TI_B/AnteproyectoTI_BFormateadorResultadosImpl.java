package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;

@Service
public class AnteproyectoTI_BFormateadorResultadosImpl implements AnteproyectoTI_BFormateadorResultadosInt {
    
    private final ModelMapper mapper;

    public AnteproyectoTI_BFormateadorResultadosImpl(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<AnteproyectoTI_BDTORespuesta> prepararRespuestaSatisfactoriaListar(
            List<AnteproyectoTI_B> anteproyectos) {
        List<AnteproyectoTI_BDTORespuesta> listaObtenida = this.mapper.map(anteproyectos,
                new TypeToken<List<AnteproyectoTI_BDTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaCrearAnteproyecto(AnteproyectoTI_B anteproyecto) {
        AnteproyectoTI_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoTI_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaModificarAnteproyecto(
            AnteproyectoTI_B anteproyecto) {
        AnteproyectoTI_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoTI_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoTI_BDTORespuesta prepararRespuestaSatisfactoriaConsultarAnteproyecto(
            AnteproyectoTI_B anteproyecto) {
        AnteproyectoTI_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoTI_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoTI_BDTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

}

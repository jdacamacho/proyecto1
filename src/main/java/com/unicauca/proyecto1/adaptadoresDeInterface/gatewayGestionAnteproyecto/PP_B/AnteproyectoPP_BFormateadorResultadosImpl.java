package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.AnteproyectoPP_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;


@Service
public class AnteproyectoPP_BFormateadorResultadosImpl implements AnteproyectoPP_BFormateadorResultadosInt {
    
    private final ModelMapper mapper;

    public AnteproyectoPP_BFormateadorResultadosImpl(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<AnteproyectoPP_BDTORespuesta> prepararRespuestaSatisfactoriaListar(
            List<AnteproyectoPP_B> anteproyectos) {
        List<AnteproyectoPP_BDTORespuesta> listaObtenida = this.mapper.map(anteproyectos,
                new TypeToken<List<AnteproyectoPP_BDTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaCrearAnteproyecto(AnteproyectoPP_B anteproyecto) {
        AnteproyectoPP_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoPP_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaModificarAnteproyecto(
            AnteproyectoPP_B anteproyecto) {
        AnteproyectoPP_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoPP_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoPP_BDTORespuesta prepararRespuestaSatisfactoriaConsultarAnteproyecto(
            AnteproyectoPP_B anteproyecto) {
        AnteproyectoPP_BDTORespuesta anteproyectoR = this.mapper.map(anteproyecto, AnteproyectoPP_BDTORespuesta.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoPP_BDTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

}

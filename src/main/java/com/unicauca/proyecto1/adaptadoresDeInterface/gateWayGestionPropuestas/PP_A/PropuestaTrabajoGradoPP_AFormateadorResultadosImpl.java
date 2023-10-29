package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;

@Service
public class PropuestaTrabajoGradoPP_AFormateadorResultadosImpl implements PropuestaTrabajoGradoPP_AFormateadorResultadosInt{

    private final ModelMapper propuestaModelMapper;

    public PropuestaTrabajoGradoPP_AFormateadorResultadosImpl(ModelMapper propuestaModelMapper){
        this.propuestaModelMapper = propuestaModelMapper;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> prepararRespuestaSatisfactoriaListarPropuestas(
            List<PropuestaTrabajoGradoPP_A> objPropuestas) {
        List<PropuestaTrabajoGradoPP_ADTORespuesta> listaObtenida = this.propuestaModelMapper.map(objPropuestas,
                new TypeToken<List<PropuestaTrabajoGradoPP_ADTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaCrearPropuesta(
            PropuestaTrabajoGradoPP_A objPropuesta) {
        PropuestaTrabajoGradoPP_ADTORespuesta objPropuestaDTORespuesta = this.propuestaModelMapper.map(objPropuesta,
        PropuestaTrabajoGradoPP_ADTORespuesta.class);
        return objPropuestaDTORespuesta;
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaConsultarPropuesta(
            PropuestaTrabajoGradoPP_A objPropuesta) {
        PropuestaTrabajoGradoPP_ADTORespuesta objPropuestaDTORespuesta = this.propuestaModelMapper.map(objPropuesta,
        PropuestaTrabajoGradoPP_ADTORespuesta.class);
        return objPropuestaDTORespuesta;
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta prepararRespuestaSatisfactoriaModificarPropuesta(
            PropuestaTrabajoGradoPP_A objPropuestaModificado) {
        PropuestaTrabajoGradoPP_ADTORespuesta objDTORespuesta = this.propuestaModelMapper.map(objPropuestaModificado,
        PropuestaTrabajoGradoPP_ADTORespuesta.class);
        return objDTORespuesta;
    }
    
}

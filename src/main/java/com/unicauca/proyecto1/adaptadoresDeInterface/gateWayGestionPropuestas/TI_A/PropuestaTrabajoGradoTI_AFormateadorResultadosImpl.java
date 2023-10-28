package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;

@Service
public class PropuestaTrabajoGradoTI_AFormateadorResultadosImpl implements PropuestaTrabajoGradoTI_AFormateadorResultadosInt {

    private final ModelMapper propuestaModelMapper;

    public PropuestaTrabajoGradoTI_AFormateadorResultadosImpl(ModelMapper propuestaModelMapper){
        this.propuestaModelMapper = propuestaModelMapper;
    }
    
    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> prepararRespuestaSatisfactoriaListarPropuestas(
            List<PropuestaTrabajoGradoTI_A> objPropuestas) {
        List<PropuestaTrabajoGradoTI_ADTORespuesta> listaObtenida = this.propuestaModelMapper.map(objPropuestas,
                new TypeToken<List<PropuestaTrabajoGradoTI_ADTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaCrearPropuesta(
            PropuestaTrabajoGradoTI_A objPropuesta) {
        PropuestaTrabajoGradoTI_ADTORespuesta objPropuestaDTORespuesta = this.propuestaModelMapper.map(objPropuesta,
        PropuestaTrabajoGradoTI_ADTORespuesta.class);
        return objPropuestaDTORespuesta;
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaConsultarPropuesta(
            PropuestaTrabajoGradoTI_A objPropuesta) {
        PropuestaTrabajoGradoTI_ADTORespuesta objPropuestaDTORespuesta = this.propuestaModelMapper.map(objPropuesta,
        PropuestaTrabajoGradoTI_ADTORespuesta.class);
        return objPropuestaDTORespuesta;
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta prepararRespuestaSatisfactoriaModificarPropuesta(
            PropuestaTrabajoGradoTI_A objPropuestaModificado) {
            PropuestaTrabajoGradoTI_ADTORespuesta objDTORespuesta = this.propuestaModelMapper.map(objPropuestaModificado,
            PropuestaTrabajoGradoTI_ADTORespuesta.class);
            return objDTORespuesta;
    }
    
}

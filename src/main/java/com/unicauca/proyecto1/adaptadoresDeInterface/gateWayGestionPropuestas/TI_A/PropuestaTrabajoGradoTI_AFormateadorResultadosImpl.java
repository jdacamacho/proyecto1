package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;

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
    
}

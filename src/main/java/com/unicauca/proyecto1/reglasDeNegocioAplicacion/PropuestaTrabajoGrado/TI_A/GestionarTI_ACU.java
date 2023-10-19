package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;

public class GestionarTI_ACU implements GestionarTI_ACUInt{

    private final PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway;

    public GestionarTI_ACU(PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }
    
}

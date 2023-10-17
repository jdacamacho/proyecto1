package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Rol;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta.RolDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.GestionarRolGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.RolFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

public class GestionarRolCU implements GestionarRolCUInt{

    private final GestionarRolGatewayInt objGestionarRolGateway;
    private final RolFormateadorResultadosInt objRolFormateadorResultados;

    public GestionarRolCU(GestionarRolGatewayInt objGestionarRolGateway,
                        RolFormateadorResultadosInt objRolFormateadorResultados){
        this.objGestionarRolGateway = objGestionarRolGateway;
        this.objRolFormateadorResultados = objRolFormateadorResultados;
    }

    @Override
    public List<RolDTORespuesta> listarRoles() {
        List<Rol> listaObtenida = objGestionarRolGateway.listar();
        return this.objRolFormateadorResultados.prepararRespuestaSatisfactoriaListarRoles(listaObtenida);
    }
    
}

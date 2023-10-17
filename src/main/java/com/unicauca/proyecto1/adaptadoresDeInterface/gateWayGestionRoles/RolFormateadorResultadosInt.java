package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta.RolDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

public interface RolFormateadorResultadosInt {
    public List<RolDTORespuesta> prepararRespuestaSatisfactoriaListarRoles(List<Rol> objRoles);
}

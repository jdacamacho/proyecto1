package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Rol;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta.RolDTORespuesta;

public interface GestionarRolCUInt {
    public List<RolDTORespuesta> listarRoles();
}

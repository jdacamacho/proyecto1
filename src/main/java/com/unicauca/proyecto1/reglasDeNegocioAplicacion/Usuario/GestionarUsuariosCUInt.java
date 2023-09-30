package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;

public interface GestionarUsuariosCUInt {
    public UsuarioDTORespuesta crearUsuario(UsuarioDTOPeticion objDTOPeticion);
    public UsuarioDTORespuesta moficicarUsuario(UsuarioDTOPeticion objDtoPeticion);
    public List<UsuarioDTORespuesta> listarUsuarios();
}
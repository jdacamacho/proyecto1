package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;

public class GestionarUsuariosCU implements GestionarUsuariosCUInt{

    @Override
    public UsuarioDTORespuesta crearUsuario(UsuarioDTOPeticion objDTOPeticion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
    }

    @Override
    public UsuarioDTORespuesta moficicarUsuario(UsuarioDTOPeticion objDtoPeticion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moficicarUsuario'");
    }

    @Override
    public List<UsuarioDTORespuesta> listarUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarUsuarios'");
    }
    
}

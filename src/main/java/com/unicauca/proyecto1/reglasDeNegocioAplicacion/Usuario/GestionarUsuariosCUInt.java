package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.LoginDTPOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

public interface GestionarUsuariosCUInt {
    public UsuarioDTORespuesta crearUsuario(UsuarioDTOPeticion objDTOPeticion);
    public UsuarioDTORespuesta modificarUsuario(int identificacionUsuario,UsuarioDTOPeticion objDTOPeticion);
    public List<UsuarioDTORespuesta> listarUsuarios();
    public List<UsuarioDTORespuesta> listarUsuarios(int id, String nombreUsuario, String loginUsuario, int state);
    public List<UsuarioDTORespuesta> listarUsuariosPorRol(String rol);
    public UsuarioDTORespuesta consultarUsuario(int identificacionUsuario);
    public UsuarioDTORespuesta agregarRol(int identificacionUsuario,Rol rol);
    public UsuarioDTORespuesta eliminarRol(int identificacionUsuario,Rol rol);
    public UsuarioDTORespuesta buscarPorLogin(LoginDTPOPeticion objDtpoPeticion);
}

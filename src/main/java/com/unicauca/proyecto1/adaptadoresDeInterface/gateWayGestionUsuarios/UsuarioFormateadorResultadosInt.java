package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface UsuarioFormateadorResultadosInt {
    public UsuarioDTORespuesta prepararRespuestaSatisfactoriaCrearUsuario(Usuario objUsuarioCreado);
    public UsuarioDTORespuesta prepararRespuestaSatisfactoriaModificarUsuario(Usuario objUsuarioModificado);
    public List<UsuarioDTORespuesta> prepararRespuestaSatisfactoriaListarUsuarios(List<Usuario> objUsuarios);
    public UsuarioDTORespuesta prepararRespuestaFallida(String error);
    public UsuarioDTORespuesta prepararRespuestaSatisfactoriaConsultarUsuario(Usuario objUsuarioConsultado);
    public UsuarioDTORespuesta prepararRespuestaSatisfactorioConsultarLogin(Usuario usuario);
}

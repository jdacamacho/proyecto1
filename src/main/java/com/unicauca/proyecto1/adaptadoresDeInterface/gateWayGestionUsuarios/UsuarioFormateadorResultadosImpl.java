package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class UsuarioFormateadorResultadosImpl implements UsuarioFormateadorResultadosInt {

    private final ModelMapper usuarioModelMapper;

    public UsuarioFormateadorResultadosImpl(ModelMapper usuarioModelMapper) {
        this.usuarioModelMapper = usuarioModelMapper;
    }


    @Override
    public UsuarioDTORespuesta prepararRespuestaSatisfactoriaCrearUsuario(Usuario objUsuarioCreado) {
        UsuarioDTORespuesta objUsuarioDTORespuesta = this.usuarioModelMapper.map(objUsuarioCreado,
        UsuarioDTORespuesta.class);
        return objUsuarioDTORespuesta;
    }

    @Override
    public UsuarioDTORespuesta prepararRespuestaSatisfactoriaModificarUsuario(Usuario objProductoModificado) {
        UsuarioDTORespuesta objUsuarioDTORespuesta = this.usuarioModelMapper.map(objProductoModificado,
        UsuarioDTORespuesta.class);
        return objUsuarioDTORespuesta;
    }

    @Override
    public List<UsuarioDTORespuesta> prepararRespuestaSatisfactoriaListarUsuarios(List<Usuario> objUsuarios) {
        List<UsuarioDTORespuesta> listaObtenida = this.usuarioModelMapper.map(objUsuarios,
                new TypeToken<List<UsuarioDTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }

    @Override
    public UsuarioDTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
    
}

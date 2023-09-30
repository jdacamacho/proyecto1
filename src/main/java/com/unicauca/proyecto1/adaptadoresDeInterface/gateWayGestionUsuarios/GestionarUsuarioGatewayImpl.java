package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio.UsuarioRepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarUsuarioGatewayImpl implements GestionarUsuarioGatewayInt {
    private final UsuarioRepositoryInt objUsuarioRepository;
    private final ModelMapper usuarioModelMapper;

    public GestionarUsuarioGatewayImpl(UsuarioRepositoryInt objUsuarioRepository, ModelMapper usuarioModelMapper) {
        this.objUsuarioRepository = objUsuarioRepository;
        this.usuarioModelMapper = usuarioModelMapper;
    }

    @Override
    public Usuario guardar(Usuario objUsuario) {
        UsuarioEntity objUsuarioEntity = this.usuarioModelMapper.map(objUsuario, UsuarioEntity.class);
        UsuarioEntity objUsuarioEntityRegistrado = this.objUsuarioRepository.save(objUsuarioEntity);
        Usuario objUsuarioRespuesta = this.usuarioModelMapper.map(objUsuarioEntityRegistrado, Usuario.class);
        return objUsuarioRespuesta;
    }

    @Override
    public Usuario modificar(int identificacionUsuario,Usuario objUsuario) {
        UsuarioEntity objUsuarioEntity = this.usuarioModelMapper.map(objUsuario, UsuarioEntity.class);
        UsuarioEntity objUsuarioEntityRegistrado = this.objUsuarioRepository.update(identificacionUsuario,objUsuarioEntity);
        Usuario objUsuarioRespuesta = this.usuarioModelMapper.map(objUsuarioEntityRegistrado, Usuario.class);
        return objUsuarioRespuesta;
    }

    @Override
    public List<Usuario> listar() {
        List<UsuarioEntity> lista = this.objUsuarioRepository.findAll();
        List<Usuario> listaObtenida = this.usuarioModelMapper.map(lista, new TypeToken<List<Usuario>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeUsuario(int identificacionUsuario) {
        return this.objUsuarioRepository.existeUsuario(identificacionUsuario);
    }

    @Override
    public Usuario consultarUsuario(int identificacionUsuario, Usuario objUsuario) {
        UsuarioEntity objUsuarioEntity = this.objUsuarioRepository.findById(identificacionUsuario);
		Usuario clienteDTO=this.usuarioModelMapper.map(objUsuarioEntity, Usuario.class);
		return clienteDTO;
    }
}

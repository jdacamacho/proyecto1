package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.LoginEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio.UsuarioRepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarUsuarioGatewayImpl implements GestionarUsuarioGatewayInt {
    private final UsuarioRepositoryInt objUsuarioRepository;
    private final ModelMapper usuarioModelMapper;
    private final ModelMapper loginMapper;
    private final ModelMapper rolMapper;

    public GestionarUsuarioGatewayImpl(UsuarioRepositoryInt objUsuarioRepository, ModelMapper usuarioModelMapper,ModelMapper loginMapper,ModelMapper rolMapper) {
        this.objUsuarioRepository = objUsuarioRepository;
        this.usuarioModelMapper = usuarioModelMapper;
        this.loginMapper = loginMapper;
        this.rolMapper = rolMapper;
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
    public List<Usuario> listarPorRol(String rol) {
        List<UsuarioEntity> lista = this.objUsuarioRepository.findByRole(rol);
        List<Usuario> listaObtenida = this.usuarioModelMapper.map(lista, new TypeToken<List<Usuario>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<Usuario> listar(int id, String nombreUsuario, String loginUsuario, int state) {
        List<UsuarioEntity> lista = this.objUsuarioRepository.buscarUsuariosPorFiltros(id, nombreUsuario, loginUsuario, state);
        List<Usuario> listaObtenida = this.usuarioModelMapper.map(lista, new TypeToken<List<Usuario>>() {}.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeUsuario(int identificacionUsuario) {
        return this.objUsuarioRepository.existeUsuario(identificacionUsuario);
    }

    @Override
    public Usuario consultarUsuario(int identificacionUsuario) {
        UsuarioEntity objUsuarioEntity = this.objUsuarioRepository.findById(identificacionUsuario);
		Usuario objUsuarioEntityEncontrado=this.usuarioModelMapper.map(objUsuarioEntity, Usuario.class);
		return objUsuarioEntityEncontrado;
    }

    @Override
    public Usuario buscarPorLogin(Login login) {
        LoginEntity loginEntity = this.loginMapper.map(login,LoginEntity.class);
        UsuarioEntity objUsuarioEntity = this.objUsuarioRepository.buscarPorLogin(loginEntity);
        Usuario objUsuario = this.usuarioModelMapper.map(objUsuarioEntity,Usuario.class);
        return objUsuario;
    }

    @Override
    public List<Usuario> buscarUsuariosPorRol(Rol rol) {
        RolEntity rolEntity = this.rolMapper.map(rol,RolEntity.class);
        List<UsuarioEntity> listaUsuarioEntity = this.objUsuarioRepository.buscarUsuariosPorRol(rolEntity);
        List<Usuario> listaObtenida = this.usuarioModelMapper.map(listaUsuarioEntity, new TypeToken<List<Usuario>>() {
        }.getType());
        return listaObtenida;
    }

    
}

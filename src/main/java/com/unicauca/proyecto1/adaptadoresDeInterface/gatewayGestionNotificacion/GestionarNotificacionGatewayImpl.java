package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.NotificacionEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.notificacionesRepositorio.NotificacionRepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarNotificacionGatewayImpl implements GestionarNotificacionGatewayInt {

    private final NotificacionRepositoryInt objNotificacionRepositorio;
    private final ModelMapper notificacionMapper;
    private final ModelMapper usuarioMapper;

    public GestionarNotificacionGatewayImpl(NotificacionRepositoryInt objNotificacionRepositoryInt, ModelMapper notificacionMapper,ModelMapper usuarioMapper){
        this.objNotificacionRepositorio = objNotificacionRepositoryInt;
        this.notificacionMapper = notificacionMapper;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Notificacion guardar(Notificacion notificacion) {
        NotificacionEntity objNotificacionEntity = this.notificacionMapper.map(notificacion,NotificacionEntity.class);
        NotificacionEntity notificacionGuardada = this.objNotificacionRepositorio.save(objNotificacionEntity);
        Notificacion objNotificacionRespuesta = this.notificacionMapper.map(notificacionGuardada, Notificacion.class);
        return objNotificacionRespuesta;
    }

    @Override
    public List<Notificacion> listarPorUsuario(Usuario objUsuarioReceptor) {
        UsuarioEntity objUsuarioEntity = this.usuarioMapper.map(objUsuarioReceptor,UsuarioEntity.class);
        List<NotificacionEntity> lista = this.objNotificacionRepositorio.findByReceptor(objUsuarioEntity);
        List<Notificacion> listaObtenida = this.notificacionMapper.map(lista, new TypeToken<List<Notificacion>>() {
        }.getType());
        return listaObtenida; 
    }
    
}

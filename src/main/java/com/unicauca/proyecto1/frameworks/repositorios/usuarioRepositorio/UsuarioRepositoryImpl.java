package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.LoginEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryInt {
    
    @Autowired
    UsuarioRepositoryJPA repositorioUsuarios;

    public UsuarioRepositoryImpl(){

    }

    @Override
    public List<UsuarioEntity> findAll() {
        System.out.println("Invocando a listar usuarios");
        Iterable<UsuarioEntity> iterable = this.repositorioUsuarios.findAll();
        List<UsuarioEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public UsuarioEntity findById(Integer id) {
        System.out.println("Invocando a consultar un usuario");
        UsuarioEntity objUsuarioR = null;
        objUsuarioR = this.repositorioUsuarios.findById(id).get();
        return objUsuarioR;
    }

    @Override
    public UsuarioEntity save(UsuarioEntity objUsuario) {
        System.out.println("Invocando a guardar usuario");
        UsuarioEntity objUsuarioR = null;
        objUsuarioR = this.repositorioUsuarios.save(objUsuario);

        return objUsuarioR;
    }

    @Override
    public UsuarioEntity update(Integer id, UsuarioEntity objUsuario) {
        System.out.println("Invocando a actualizar un usuario");
        UsuarioEntity objUsuarioR = null;
        if(this.repositorioUsuarios.findById(id) != null){
            objUsuarioR = this.repositorioUsuarios.save(objUsuario);
        }
        return objUsuarioR;
    }

    @Override
    public boolean existeUsuario(int identificacionUsuario) {
        System.out.println("Invocando a buscar si existe un usuario");
        return this.repositorioUsuarios.findById(identificacionUsuario).isPresent();
    }

    @Override
    public UsuarioEntity buscarPorLogin(LoginEntity loginEntity) {
        System.out.println("Invocando a buscar por login");
        UsuarioEntity usuario = this.repositorioUsuarios.findByUserNameWithRoles(loginEntity.getUserNameLogin());
        System.out.println("login:" + loginEntity.getUserNameLogin());
        System.out.println(usuario.getNombresUsuario());
        return usuario;
    }
}

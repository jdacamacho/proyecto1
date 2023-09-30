package com.unicauca.proyecto1.frameworks.repositorios.usuarioRepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryInt {
    
    private ArrayList<UsuarioEntity> usuarios;

    public UsuarioRepositoryImpl(){
        this.usuarios = new ArrayList<UsuarioEntity>();
    }

    @Override
    public List<UsuarioEntity> findAll() {
        System.out.println("Invocando a listar usuarios");
        return this.usuarios;
    }

    @Override
    public UsuarioEntity findById(Integer id) {
        System.out.println("Invocando a consultar un usuario");
        UsuarioEntity objUsuarioR = null;

        for (UsuarioEntity objUsuarioE : this.usuarios) {
            if (objUsuarioE.getIdentificacionUsuario() == id) {
                objUsuarioR = objUsuarioE;
                break;
            }
        }

        return objUsuarioR;
    }

    @Override
    public UsuarioEntity save(UsuarioEntity objUsuario) {
        System.out.println("Invocando a guardar usuario");
        UsuarioEntity objUsuarioR = null;
        if (this.usuarios.add(objUsuario)) {
            objUsuarioR = objUsuario;
        }

        return objUsuarioR;
    }

    @Override
    public UsuarioEntity update(Integer id, UsuarioEntity objUsuario) {
        System.out.println("Invocando a actualizar un producto");
        UsuarioEntity objUsuarioR = null;

        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getIdentificacionUsuario() == id) {
                this.usuarios.set(i, objUsuario);
                objUsuarioR = objUsuario;
                break;
            }
        }
        return objUsuarioR;
    }
    
}

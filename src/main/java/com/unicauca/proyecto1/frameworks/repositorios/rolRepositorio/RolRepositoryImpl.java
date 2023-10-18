package com.unicauca.proyecto1.frameworks.repositorios.rolRepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;

@Repository
public class RolRepositoryImpl implements RolRepositoryInt{

    @Autowired
    RolRepositoryJPA repositoriRoles;

    @Override
    public List<RolEntity> findAll() {
        System.out.println("Invocando a listar roles");
        Iterable<RolEntity> iterable = this.repositoriRoles.findAll();
        List<RolEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }
    
}

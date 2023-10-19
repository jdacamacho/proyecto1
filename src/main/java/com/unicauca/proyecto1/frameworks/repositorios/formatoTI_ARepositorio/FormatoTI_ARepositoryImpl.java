package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;

@Repository
public class FormatoTI_ARepositoryImpl implements FormatoTI_ARepositoryInt{

    @Autowired
    FormatoTI_ARepositoryJPA repositorioFormatoTI_A;

    @Override
    public List<PropuestaTrabajoGradoTI_AEntity> findAll() {
        System.out.println("Invocando a listar propuestas ");
        Iterable<PropuestaTrabajoGradoTI_AEntity> iterable = this.repositorioFormatoTI_A.findAll();
        List<PropuestaTrabajoGradoTI_AEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }
    
}

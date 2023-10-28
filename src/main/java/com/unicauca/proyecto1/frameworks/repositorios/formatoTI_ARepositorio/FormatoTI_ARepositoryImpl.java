package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public class FormatoTI_ARepositoryImpl implements FormatoTI_ARepositoryInt{

    @Autowired
    FormatoTI_ARepositoryJPA repositorioFormatoTI_A;

    public FormatoTI_ARepositoryImpl(){

    }
    
    @Override
    public List<PropuestaTrabajoGradoTI_AEntity> findAll() {
        System.out.println("Invocando a listar propuestas ");
        Iterable<PropuestaTrabajoGradoTI_AEntity> iterable = this.repositorioFormatoTI_A.findAll();
        List<PropuestaTrabajoGradoTI_AEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public PropuestaTrabajoGradoTI_AEntity findById(Integer id) {
        System.out.println("Invocando a consultar una propuesta TI_A");
        PropuestaTrabajoGradoTI_AEntity objPropuestaR = null;
        objPropuestaR = this.repositorioFormatoTI_A.findById(id).get();
        return objPropuestaR;
    }

    @Override
    public PropuestaTrabajoGradoTI_AEntity save(PropuestaTrabajoGradoTI_AEntity propuestaTI_A) {
        System.out.println("Invocando a guardar propuesta TI_A");
        PropuestaTrabajoGradoTI_AEntity objPropuestaR = null;
        objPropuestaR = this.repositorioFormatoTI_A.save(propuestaTI_A);
        return objPropuestaR;
    }

    @Override
    public PropuestaTrabajoGradoTI_AEntity update(Integer id, PropuestaTrabajoGradoTI_AEntity propuestaTI_A) {
        System.out.println("Invocando a actualizar propuesta");
        PropuestaTrabajoGradoTI_AEntity objPropuestaR = null;
        if(this.repositorioFormatoTI_A.findById(id) != null){
            objPropuestaR = this.repositorioFormatoTI_A.save(propuestaTI_A);
        }
        return objPropuestaR;
    }

    @Override
    public boolean existePropuesta(int idPropuesta) {
        System.out.println("Invocando a buscar si existe un propuesta");
        return this.repositorioFormatoTI_A.findById(idPropuesta).isPresent();
    }

    @Override
    public List<PropuestaTrabajoGradoTI_AEntity> findByIdDirector(UsuarioEntity idDirector) {
        System.out.println("Invocando a buscar propuestas por directos");
        return this.repositorioFormatoTI_A.findByIdentificacionDirectorTIA(idDirector);
    }
    
}

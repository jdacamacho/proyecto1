package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_ARepositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.PropuestaTrabajoGradoPP_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;

@Repository
public class FormatoPP_ARepositoryImpl implements FormatoPP_ARepositoryInt{

    @Autowired
    FormatoPP_ARepositoryJPA repositorioFormatoPP_A;

    public FormatoPP_ARepositoryImpl(){

    }

    @Override
    public List<PropuestaTrabajoGradoPP_AEntity> findAll() {
        System.out.println("Invocando a listar propuestas ");
        Iterable<PropuestaTrabajoGradoPP_AEntity> iterable = this.repositorioFormatoPP_A.findAll();
        List<PropuestaTrabajoGradoPP_AEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }

    //#region
    @Override
    public List<PropuestaTrabajoGradoPP_AEntity> findByEstado(int estado) {
        System.out.println("Invocando a listar propuestas por estado");
        Iterable<PropuestaTrabajoGradoPP_AEntity> iterable = this.repositorioFormatoPP_A.findByEstadoPropuestaTrabajoGradoPPA(estado);
        List<PropuestaTrabajoGradoPP_AEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_AEntity> findAllByIdAndEstado(UsuarioEntity id, int estado) {
        System.out.println("Invocando a buscar propuestas por id y estado");
        return this.repositorioFormatoPP_A.findByIdentificacionDirectorPPAAndEstadoPropuestaTrabajoGradoPPA(id, estado);
    }
    //#endregion

    @Override
    public PropuestaTrabajoGradoPP_AEntity findById(Integer id) {
        System.out.println("Invocando a consultar una propuesta PP_A");
        PropuestaTrabajoGradoPP_AEntity objPropuestaR = null;
        objPropuestaR = this.repositorioFormatoPP_A.findById(id).get();
        return objPropuestaR;
    }

    @Override
    public PropuestaTrabajoGradoPP_AEntity save(PropuestaTrabajoGradoPP_AEntity propuestaPP_A) {
        System.out.println("Invocando a guardar propuesta PP_A");
        PropuestaTrabajoGradoPP_AEntity objPropuestaR = null;
        objPropuestaR = this.repositorioFormatoPP_A.save(propuestaPP_A);
        return objPropuestaR;
    }

    @Override
    public PropuestaTrabajoGradoPP_AEntity update(Integer id, PropuestaTrabajoGradoPP_AEntity propuestaPP_A) {
        System.out.println("Invocando a actualizar propuesta");
        PropuestaTrabajoGradoPP_AEntity objPropuestaR = null;
        if(this.repositorioFormatoPP_A.findById(id) != null){
            objPropuestaR = this.repositorioFormatoPP_A.save(propuestaPP_A);
        }
        return objPropuestaR;
    }

    @Override
    public boolean existePropuesta(int idPropuesta) {
        System.out.println("Invocando a buscar si existe un propuesta");
        return this.repositorioFormatoPP_A.findById(idPropuesta).isPresent();
    }

    @Override
    public List<PropuestaTrabajoGradoPP_AEntity> findByIdDirector(UsuarioEntity idDirector) {
        System.out.println("Invocando a buscar propuestas por director");
        return this.repositorioFormatoPP_A.findByIdentificacionDirectorPPA(idDirector);
    }
    
}

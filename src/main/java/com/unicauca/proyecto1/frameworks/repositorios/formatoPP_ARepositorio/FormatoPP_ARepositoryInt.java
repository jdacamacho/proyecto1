package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_ARepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.PropuestaTrabajoGradoPP_AEntity;

public interface FormatoPP_ARepositoryInt {
    public List<PropuestaTrabajoGradoPP_AEntity> findAll();
    public PropuestaTrabajoGradoPP_AEntity findById(Integer id);
    public PropuestaTrabajoGradoPP_AEntity save(PropuestaTrabajoGradoPP_AEntity propuestaPP_A);
    public PropuestaTrabajoGradoPP_AEntity update(Integer id,PropuestaTrabajoGradoPP_AEntity propuestaPP_A);
    public boolean existePropuesta(int idPropuesta);
    List<PropuestaTrabajoGradoPP_AEntity> findByIdDirector(UsuarioEntity idDirector);
}

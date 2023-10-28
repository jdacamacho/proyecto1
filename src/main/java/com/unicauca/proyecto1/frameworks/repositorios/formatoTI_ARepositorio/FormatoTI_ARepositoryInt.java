package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;

import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;

public interface FormatoTI_ARepositoryInt {
    public List<PropuestaTrabajoGradoTI_AEntity> findAll();
    public PropuestaTrabajoGradoTI_AEntity findById(Integer id);
    public PropuestaTrabajoGradoTI_AEntity save(PropuestaTrabajoGradoTI_AEntity propuestaTI_A);
    public PropuestaTrabajoGradoTI_AEntity update(Integer id,PropuestaTrabajoGradoTI_AEntity propuestaTI_A);
    public boolean existePropuesta(int idPropuesta);
    List<PropuestaTrabajoGradoTI_AEntity> findByIdDirector(UsuarioEntity idDirector);
}

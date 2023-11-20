package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;

@Repository
public interface FormatoTI_ARepositoryJPA extends CrudRepository<PropuestaTrabajoGradoTI_AEntity,Integer>{
    public List<PropuestaTrabajoGradoTI_AEntity> findByIdentificacionDirectorTIA(UsuarioEntity identificacionDirector);
    
    public List<PropuestaTrabajoGradoTI_AEntity> findByIdentificacionDirectorTIAAndEstadoPropuestaTrabajoGradoTIA(UsuarioEntity identificacionDirector, int estado);
    public List<PropuestaTrabajoGradoTI_AEntity> findByEstadoPropuestaTrabajoGradoTIA(int estado);
}

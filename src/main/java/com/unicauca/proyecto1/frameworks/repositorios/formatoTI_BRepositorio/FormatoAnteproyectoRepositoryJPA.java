package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.AnteproyectoTI_BEntity;
import java.util.List;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

@Repository
public interface FormatoAnteproyectoRepositoryJPA extends CrudRepository<AnteproyectoTI_BEntity,Integer>{
    List<AnteproyectoTI_BEntity> findByIdentificacionDirectorTIB(UsuarioEntity identificacionDirectorTIB);
}

package com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.AnteproyectoPP_BEntity;

@Repository
public interface FormatoAnteproyectoRepositoryPP_BJPA extends CrudRepository<AnteproyectoPP_BEntity,String>{
    List<AnteproyectoPP_BEntity> findByIdentificacionDirectorPPB(UsuarioEntity identificacionDirectorTIB);
    AnteproyectoPP_BEntity findByIdAnteproyectoPPB(String idAnteproyectoTIB);
    long countByIdAnteproyectoPPB(String idAnteproyecto);
}

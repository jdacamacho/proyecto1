package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;

@Repository
public interface FormatoAnteproyectoRepositoryJPA extends CrudRepository<AnteproyectoTI_B,Integer>{
    
}

package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionEvaluadorTI_BEntity;

@Repository
public interface RevisionEvaluadorRepositoryJPA extends CrudRepository<RevisionEvaluadorTI_BEntity,Integer> {
    /*@Query("SELECT COUNT(r) FROM revisionevaluadorti_b  r WHERE r.identificacionevaluador = :id")
    int existeRevisionParaEvaluador(@Param("id") int id);*/
    
    List<RevisionEvaluadorTI_BEntity> findByConceptoRevision(String concepto);
}

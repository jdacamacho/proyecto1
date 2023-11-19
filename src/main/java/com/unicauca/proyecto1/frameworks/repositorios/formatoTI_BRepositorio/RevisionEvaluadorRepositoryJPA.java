package com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.RevisionEvaluadorTI_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;


@Repository
public interface RevisionEvaluadorRepositoryJPA extends CrudRepository<RevisionEvaluadorTI_BEntity,Integer> {
    List<RevisionEvaluadorTI_BEntity> findByConceptoRevision(String concepto);
    RevisionEvaluadorTI_BEntity findByIdentificacionEvaluador(UsuarioEntity identificacionEvaluador);
}

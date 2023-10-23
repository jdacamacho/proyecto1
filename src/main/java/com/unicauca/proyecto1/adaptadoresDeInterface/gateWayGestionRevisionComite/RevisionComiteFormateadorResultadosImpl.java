package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;

@Service
public class RevisionComiteFormateadorResultadosImpl implements RevisionComiteFormateadorResultadosInt {
    
    private final ModelMapper revisionComiteMapeador;
    
    public RevisionComiteFormateadorResultadosImpl(ModelMapper revisionComiteMapeador){
        this.revisionComiteMapeador = revisionComiteMapeador;
    }
    
    @Override
    public RevisionComiteDTORespuesta prepararRespuestaSatisfactoriaCrearRevision(RevisionComite objRevisionCreado) {
        RevisionComiteDTORespuesta objRevisionDTORespuesta = this.revisionComiteMapeador.map(objRevisionCreado,
        RevisionComiteDTORespuesta.class);
        return objRevisionDTORespuesta;
    }

    @Override
    public RevisionComiteDTORespuesta prepararRespuestaFallida(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
    
}

package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;

@Service
public class RevisionEvaluadorTI_BFormateadorResultadosImpl implements RevisionEvaluadorTI_BFormateadorResultadosInt{
    
    private final ModelMapper mapper;

    public RevisionEvaluadorTI_BFormateadorResultadosImpl(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<RevisionEvaluadorTI_BDTORespuesta> prepararRespuestaSatisfactoriaListar(
            List<RevisionEvaluadorTI_B> revisionesEvaluador) {
        List<RevisionEvaluadorTI_BDTORespuesta> listaObtenida = this.mapper.map(revisionesEvaluador,
                new TypeToken<List<RevisionEvaluadorTI_BDTORespuesta>>() {
                }.getType()); 
        return listaObtenida;
    }
}

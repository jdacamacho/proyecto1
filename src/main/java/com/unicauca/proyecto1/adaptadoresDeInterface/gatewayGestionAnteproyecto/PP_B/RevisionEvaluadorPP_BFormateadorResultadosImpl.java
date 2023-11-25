package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.RevisionEvaluadorPP_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;

@Service
public class RevisionEvaluadorPP_BFormateadorResultadosImpl implements RevisionEvaluadorPP_BFormateadorResultadosInt{
    
    private final ModelMapper mapper;

    public RevisionEvaluadorPP_BFormateadorResultadosImpl(ModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<RevisionEvaluadorPP_BDTORespuesta> prepararRespuestaSatisfactoriaListar(
            List<RevisionEvaluadorPP_B> revisionesEvaluador) {
        List<RevisionEvaluadorPP_BDTORespuesta> listaObtenida = this.mapper.map(revisionesEvaluador,
                new TypeToken<List<RevisionEvaluadorPP_BDTORespuesta>>() {
                }.getType()); 
        return listaObtenida;
    }
}

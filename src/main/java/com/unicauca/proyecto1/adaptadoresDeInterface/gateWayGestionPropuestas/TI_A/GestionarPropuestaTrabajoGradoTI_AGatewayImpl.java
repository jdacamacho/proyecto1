package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio.FormatoTI_ARepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;

@Service
public class GestionarPropuestaTrabajoGradoTI_AGatewayImpl implements GestionarPropuestaTrabajoGradoTI_AGatewayInt {
    private final FormatoTI_ARepositoryInt objTI_ARepositorio;
    private final ModelMapper propuestaModelMapper;
    
    public GestionarPropuestaTrabajoGradoTI_AGatewayImpl(FormatoTI_ARepositoryInt objTI_ARepositorio,
                                                    ModelMapper propuestModelMapper){
        this.objTI_ARepositorio = objTI_ARepositorio;
        this.propuestaModelMapper = propuestModelMapper;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_A> listar() {
        List<PropuestaTrabajoGradoTI_AEntity> lista = this.objTI_ARepositorio.findAll();
        List<PropuestaTrabajoGradoTI_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoTI_A>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public PropuestaTrabajoGradoTI_A consultarPropuesta(int idPropuesta) {
        PropuestaTrabajoGradoTI_AEntity objPropuestaEntity = this.objTI_ARepositorio.findById(idPropuesta);
		PropuestaTrabajoGradoTI_A objPropuestaEntityEncontrado=this.propuestaModelMapper.map(objPropuestaEntity, PropuestaTrabajoGradoTI_A.class);
		return objPropuestaEntityEncontrado;
    }

    @Override
    public PropuestaTrabajoGradoTI_A guardar(PropuestaTrabajoGradoTI_A objPropuesta) {
        PropuestaTrabajoGradoTI_AEntity PropuestaTrabajoGradoTI_AEntity = this.propuestaModelMapper.map(objPropuesta, PropuestaTrabajoGradoTI_AEntity.class);
        PropuestaTrabajoGradoTI_AEntity objPropuestaEntityRegistrado = this.objTI_ARepositorio.save(PropuestaTrabajoGradoTI_AEntity);
        PropuestaTrabajoGradoTI_A objPropuestaRespuesta = this.propuestaModelMapper.map(objPropuestaEntityRegistrado, PropuestaTrabajoGradoTI_A.class);
        return objPropuestaRespuesta;
    }
}

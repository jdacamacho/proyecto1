package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.PropuestaTrabajoGradoPP_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoPP_ARepositorio.FormatoPP_ARepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarPropuestaTrabajoGradoPP_AGatewayImpl implements GestionarPropuestaTrabajoGradoPP_AGatewayInt{
    private final FormatoPP_ARepositoryInt objPP_ARepositorio;
    private final ModelMapper propuestaModelMapper;
    
    public GestionarPropuestaTrabajoGradoPP_AGatewayImpl(FormatoPP_ARepositoryInt objPP_ARepositorio,
                                                    ModelMapper propuestModelMapper){
        this.objPP_ARepositorio = objPP_ARepositorio;
        this.propuestaModelMapper = propuestModelMapper;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_A> listar() {
        List<PropuestaTrabajoGradoPP_AEntity> lista = this.objPP_ARepositorio.findAll();
        List<PropuestaTrabajoGradoPP_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoPP_A>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_A> listarPropuestasPorEstado(int estado) {
        List<PropuestaTrabajoGradoPP_AEntity> lista = this.objPP_ARepositorio.findByEstado(estado);
        List<PropuestaTrabajoGradoPP_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoPP_A>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_A> listarPorDirectorYestado(Usuario idDirector, int estado) {
        UsuarioEntity objUsuarioEntity = this.propuestaModelMapper.map(idDirector, UsuarioEntity.class);
        List<PropuestaTrabajoGradoPP_AEntity> lista = this.objPP_ARepositorio.findAllByIdAndEstado(objUsuarioEntity, estado);
        List<PropuestaTrabajoGradoPP_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoPP_A>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public PropuestaTrabajoGradoPP_A consultarPropuesta(int idPropuesta) {
        PropuestaTrabajoGradoPP_AEntity objPropuestaEntity = this.objPP_ARepositorio.findById(idPropuesta);
		PropuestaTrabajoGradoPP_A objPropuestaEntityEncontrado=this.propuestaModelMapper.map(objPropuestaEntity, PropuestaTrabajoGradoPP_A.class);
		return objPropuestaEntityEncontrado;
    }

    @Override
    public PropuestaTrabajoGradoPP_A guardar(PropuestaTrabajoGradoPP_A objPropuesta) {
        PropuestaTrabajoGradoPP_AEntity PropuestaTrabajoGradoPP_AEntity = this.propuestaModelMapper.map(objPropuesta, PropuestaTrabajoGradoPP_AEntity.class);
        PropuestaTrabajoGradoPP_AEntity objPropuestaEntityRegistrado = this.objPP_ARepositorio.save(PropuestaTrabajoGradoPP_AEntity);
        PropuestaTrabajoGradoPP_A objPropuestaRespuesta = this.propuestaModelMapper.map(objPropuestaEntityRegistrado, PropuestaTrabajoGradoPP_A.class);
        return objPropuestaRespuesta;
    }

    @Override
    public PropuestaTrabajoGradoPP_A modificar(int id, PropuestaTrabajoGradoPP_A objPropuesta) {
        PropuestaTrabajoGradoPP_AEntity objPropuestaEntity = this.propuestaModelMapper.map(objPropuesta, PropuestaTrabajoGradoPP_AEntity.class);
        PropuestaTrabajoGradoPP_AEntity objPropuestaEntityRegistrado = this.objPP_ARepositorio.update(id,objPropuestaEntity);
        PropuestaTrabajoGradoPP_A objPropuestaRespuesta = this.propuestaModelMapper.map(objPropuestaEntityRegistrado, PropuestaTrabajoGradoPP_A.class);
        return objPropuestaRespuesta;
    }

    @Override
    public boolean existePropuesta(int idPropuesta) {
        return this.objPP_ARepositorio.existePropuesta(idPropuesta);
    }

    @Override
    public List<PropuestaTrabajoGradoPP_A> listarPorDirector(Usuario idDirector) {
        UsuarioEntity objUsuarioEntity = this.propuestaModelMapper.map(idDirector, UsuarioEntity.class);
        List<PropuestaTrabajoGradoPP_AEntity> lista = this.objPP_ARepositorio.findByIdDirector(objUsuarioEntity);
        List<PropuestaTrabajoGradoPP_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoPP_A>>() {
        }.getType());
        return listaObtenida;
    }
    
}

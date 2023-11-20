package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio.FormatoTI_ARepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;


@Service
public class GestionarPropuestaTrabajoGradoTI_AGatewayImpl implements GestionarPropuestaTrabajoGradoTI_AGatewayInt {
    private final FormatoTI_ARepositoryInt objTI_ARepositorio;
    private final ModelMapper propuestaModelMapper;
    
    public GestionarPropuestaTrabajoGradoTI_AGatewayImpl(FormatoTI_ARepositoryInt objTI_ARepositorio, ModelMapper propuestModelMapper){
        this.objTI_ARepositorio = objTI_ARepositorio;
        this.propuestaModelMapper = propuestModelMapper;
    }

    //#region CONSULTAS POR ESTADO MESA
    @Override
    public List<PropuestaTrabajoGradoTI_A> listarPropuestasPorEstado(int estado) {
        List<PropuestaTrabajoGradoTI_AEntity> lista = this.objTI_ARepositorio.findAllByEstado(estado);
        List<PropuestaTrabajoGradoTI_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoTI_A>>() {}.getType());
        return listaObtenida;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_A> listarPorDirectorYestado(Usuario idDirector, int estado) {
        UsuarioEntity objUsuarioEntity = this.propuestaModelMapper.map(idDirector, UsuarioEntity.class);
        List<PropuestaTrabajoGradoTI_AEntity> lista = this.objTI_ARepositorio.findAllByIdAndEstado(objUsuarioEntity, estado);
        List<PropuestaTrabajoGradoTI_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoTI_A>>() {
        }.getType());
        return listaObtenida;
    }
    //#endregion

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

    @Override
    public PropuestaTrabajoGradoTI_A modificar(int id, PropuestaTrabajoGradoTI_A objPropuesta) {
        PropuestaTrabajoGradoTI_AEntity objPropuestaEntity = this.propuestaModelMapper.map(objPropuesta, PropuestaTrabajoGradoTI_AEntity.class);
        PropuestaTrabajoGradoTI_AEntity objPropuestaEntityRegistrado = this.objTI_ARepositorio.update(id,objPropuestaEntity);
        PropuestaTrabajoGradoTI_A objPropuestaRespuesta = this.propuestaModelMapper.map(objPropuestaEntityRegistrado, PropuestaTrabajoGradoTI_A.class);
        return objPropuestaRespuesta;
    }

    @Override
    public boolean existePropuesta(int idPropuesta) {
        return this.objTI_ARepositorio.existePropuesta(idPropuesta);
    }

    @Override
    public List<PropuestaTrabajoGradoTI_A> listarPorDirector(Usuario idDirector) {
        UsuarioEntity objUsuarioEntity = this.propuestaModelMapper.map(idDirector, UsuarioEntity.class);
        List<PropuestaTrabajoGradoTI_AEntity> lista = this.objTI_ARepositorio.findByIdDirector(objUsuarioEntity);
        List<PropuestaTrabajoGradoTI_A> listaObtenida = this.propuestaModelMapper.map(lista, new TypeToken<List<PropuestaTrabajoGradoTI_A>>() {
        }.getType());
        return listaObtenida;
    }
}

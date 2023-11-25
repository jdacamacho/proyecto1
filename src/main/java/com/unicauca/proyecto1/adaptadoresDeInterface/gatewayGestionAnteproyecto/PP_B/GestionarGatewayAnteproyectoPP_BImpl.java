package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B.AnteproyectoPP_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoPP_BRepositorio.FormatoAnteproyectoRepositoryPP_BJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarGatewayAnteproyectoPP_BImpl implements GestionarGatewayAnteproyectoPP_BInt{
    
    private final FormatoAnteproyectoRepositoryPP_BJPA repositorioAnteproyecto;
    private final ModelMapper mapper;

    public GestionarGatewayAnteproyectoPP_BImpl(ModelMapper mapper,
                        FormatoAnteproyectoRepositoryPP_BJPA repositorioAnteproyecto){
        this.mapper = mapper;
        this.repositorioAnteproyecto = repositorioAnteproyecto;
    }

    @Override
    public AnteproyectoPP_B guardar(AnteproyectoPP_B anteproyecto) {
        AnteproyectoPP_BEntity anteproyectoMapeado = this.mapper.map(anteproyecto, AnteproyectoPP_BEntity.class);
        AnteproyectoPP_BEntity anteproyectoGuardado = this.repositorioAnteproyecto.save(anteproyectoMapeado);
        AnteproyectoPP_B anteproyectoR = this.mapper.map(anteproyectoGuardado,AnteproyectoPP_B.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoPP_B consultarAnteproyecto(String idAnteproyecto) {
        AnteproyectoPP_BEntity anteproyectoConsultado = this.repositorioAnteproyecto.findByIdAnteproyectoPPB(idAnteproyecto);
        AnteproyectoPP_B anteproyectoR = this.mapper.map(anteproyectoConsultado,AnteproyectoPP_B.class);
        return anteproyectoR;
    }

    @Override
    public List<AnteproyectoPP_B> listarAnteproyectosDirector(Usuario objUsuarioReceptor) {
        UsuarioEntity usuario = this.mapper.map(objUsuarioReceptor,UsuarioEntity.class);
        List<AnteproyectoPP_BEntity> lista = this.repositorioAnteproyecto.findByIdentificacionDirectorPPB(usuario);
        List<AnteproyectoPP_B> listaObtenida = this.mapper.map(lista, new TypeToken<List<AnteproyectoPP_B>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeAnteproyecto(String anteproyecto) {
        return this.repositorioAnteproyecto.findById(anteproyecto).isPresent();
    }

    @Override
    public List<AnteproyectoPP_B> listarAnteproyectos() {
        Iterable<AnteproyectoPP_BEntity> iterable = this.repositorioAnteproyecto.findAll();
        List<AnteproyectoPP_BEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add); 
        List<AnteproyectoPP_B> listaObtenida = this.mapper.map(lista, new TypeToken<List<AnteproyectoPP_B>>() {
        }.getType());
        return listaObtenida;

    }

    @Override
    public long contarAnteproyectos(String idAnteproyecto) {
        return this.repositorioAnteproyecto.countByIdAnteproyectoPPB(idAnteproyecto);
    }

    
}

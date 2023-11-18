package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B.AnteproyectoTI_BEntity;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_BRepositorio.FormatoAnteproyectoRepositoryJPA;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Service
public class GestionarGatewayAnteproyectoTI_BImpl implements GestionarGatewayAnteproyectoTI_BInt{
    
    private final FormatoAnteproyectoRepositoryJPA repositorioAnteproyecto;
    private final ModelMapper mapper;

    public GestionarGatewayAnteproyectoTI_BImpl(ModelMapper mapper,
                        FormatoAnteproyectoRepositoryJPA repositorioAnteproyecto){
        this.mapper = mapper;
        this.repositorioAnteproyecto = repositorioAnteproyecto;
    }

    @Override
    public AnteproyectoTI_B guardar(AnteproyectoTI_B anteproyecto) {
        AnteproyectoTI_BEntity anteproyectoMapeado = this.mapper.map(anteproyecto, AnteproyectoTI_BEntity.class);
        AnteproyectoTI_BEntity anteproyectoGuardado = this.repositorioAnteproyecto.save(anteproyectoMapeado);
        AnteproyectoTI_B anteproyectoR = this.mapper.map(anteproyectoGuardado,AnteproyectoTI_B.class);
        return anteproyectoR;
    }

    @Override
    public AnteproyectoTI_B consultarAnteproyecto(String idAnteproyecto) {
        AnteproyectoTI_BEntity anteproyectoConsultado = this.repositorioAnteproyecto.findByIdAnteproyectoTIB(idAnteproyecto);
        AnteproyectoTI_B anteproyectoR = this.mapper.map(anteproyectoConsultado,AnteproyectoTI_B.class);
        return anteproyectoR;
    }

    @Override
    public List<AnteproyectoTI_B> listarAnteproyectosDirector(Usuario objUsuarioReceptor) {
        UsuarioEntity usuario = this.mapper.map(objUsuarioReceptor,UsuarioEntity.class);
        List<AnteproyectoTI_BEntity> lista = this.repositorioAnteproyecto.findByIdentificacionDirectorTIB(usuario);
        List<AnteproyectoTI_B> listaObtenida = this.mapper.map(lista, new TypeToken<List<AnteproyectoTI_B>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeAnteproyecto(int anteproyecto) {
        return this.repositorioAnteproyecto.findById(anteproyecto).isPresent();
    }

    @Override
    public List<AnteproyectoTI_B> listarAnteproyectos() {
        Iterable<AnteproyectoTI_BEntity> iterable = this.repositorioAnteproyecto.findAll();
        List<AnteproyectoTI_BEntity> lista = new ArrayList<>();
        iterable.forEach(lista::add); 
        List<AnteproyectoTI_B> listaObtenida = this.mapper.map(lista, new TypeToken<List<AnteproyectoTI_B>>() {
        }.getType());
        return listaObtenida;

    }

    @Override
    public long contarAnteproyectos(String idAnteproyecto) {
        return this.repositorioAnteproyecto.countByIdAnteproyectoTIB(idAnteproyecto);
    }

    
}

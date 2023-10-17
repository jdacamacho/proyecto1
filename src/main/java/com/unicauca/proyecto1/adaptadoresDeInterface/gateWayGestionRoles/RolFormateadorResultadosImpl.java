package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta.RolDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

@Service
public class RolFormateadorResultadosImpl implements RolFormateadorResultadosInt{

    private final ModelMapper rolModelMapper;

    public RolFormateadorResultadosImpl(ModelMapper rolModelMapper) {
        this.rolModelMapper = rolModelMapper;
    }

    @Override
    public List<RolDTORespuesta> prepararRespuestaSatisfactoriaListarRoles(List<Rol> objRoles) {
        List<RolDTORespuesta> listaObtenida = this.rolModelMapper.map(objRoles,
                new TypeToken<List<RolDTORespuesta>>() {
                }.getType());
        return listaObtenida;
    }
    
}

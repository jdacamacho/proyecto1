package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.RolEntity;
import com.unicauca.proyecto1.frameworks.repositorios.rolRepositorio.RolRepositoryInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

@Service
public class GestionarRolGatewayImpl implements GestionarRolGatewayInt{

    private final RolRepositoryInt objRolRepositorio;
    private final ModelMapper rolModelMapper;

    public GestionarRolGatewayImpl(RolRepositoryInt objRolRepositorio,ModelMapper rolModelMapper){
        this.objRolRepositorio = objRolRepositorio;
        this.rolModelMapper = rolModelMapper;
    }

    @Override
    public List<Rol> listar() {
        List<RolEntity> lista = this.objRolRepositorio.findAll();
        List<Rol> listaObtenida = this.rolModelMapper.map(lista, new TypeToken<List<Rol>>() {
        }.getType());
        return listaObtenida;
    }
    
}

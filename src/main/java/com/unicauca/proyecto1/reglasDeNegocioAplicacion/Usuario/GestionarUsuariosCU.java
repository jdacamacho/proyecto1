package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.UsuarioFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarUsuariosCU implements GestionarUsuariosCUInt{

    private final GestionarUsuarioGatewayInt objGestionarUsuarioGateway;
    private final UsuarioFormateadorResultadosInt objUsuarioFormateadorResultados;
    private final factoryUsuarioInt objUsuarioFactory;

    public GestionarUsuariosCU(GestionarUsuarioGatewayInt objGestionarUsuarioGateway,
            UsuarioFormateadorResultadosInt objUsuarioFormateadorResultados,
            factoryUsuarioInt objUsuarioFactory) {
        this.objGestionarUsuarioGateway = objGestionarUsuarioGateway;
        this.objUsuarioFormateadorResultados = objUsuarioFormateadorResultados;
        this.objUsuarioFactory = objUsuarioFactory;
    }


    @Override
    public UsuarioDTORespuesta crearUsuario(UsuarioDTOPeticion objDTOPeticion) {
        if (this.objGestionarUsuarioGateway.existeUsuario(objDTOPeticion.getIdentificacionUsuario())) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuario = this.objUsuarioFactory.crearUsuario(objDTOPeticion.getIdentificacionUsuario(),
                    objDTOPeticion.getNombresUsuario(), objDTOPeticion.getApellidosUsuario(),
                    objDTOPeticion.getRolUsuario().getIdentificacionRol(), objDTOPeticion.getRolUsuario().getTipoRol(),
                    objDTOPeticion.getEmailUsuario(),objDTOPeticion.getLoginUsuario().getUserNameLogin(),
                    objDTOPeticion.getLoginUsuario().getContraseñaLogin(),true);

            if (!objUsuario.tipoDeRolEsValido() ) {
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaFallida("Error, el rol ingresado no es valido");
            } else {

                Usuario objUsuarioCreado = this.objGestionarUsuarioGateway.guardar(objUsuario);
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaSatisfactoriaCrearUsuario(objUsuarioCreado);
            }
        }
    }

    @Override
    public UsuarioDTORespuesta modificarUsuario(int identificacionUsuario,UsuarioDTOPeticion objDTOPeticion) {
        if (this.objGestionarUsuarioGateway.existeUsuario(identificacionUsuario) == false) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, no se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuario = this.objUsuarioFactory.crearUsuario(objDTOPeticion.getIdentificacionUsuario(),
                    objDTOPeticion.getNombresUsuario(), objDTOPeticion.getApellidosUsuario(),
                    objDTOPeticion.getRolUsuario().getIdentificacionRol(), objDTOPeticion.getRolUsuario().getTipoRol(),
                    objDTOPeticion.getEmailUsuario(),objDTOPeticion.getLoginUsuario().getUserNameLogin(),
                    objDTOPeticion.getLoginUsuario().getContraseñaLogin(),true);

            if (!objUsuario.tipoDeRolEsValido() ) {
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaFallida("Error, el rol ingresado no es valido");
            } else {
                Usuario objUsuarioCreado = this.objGestionarUsuarioGateway.modificar(identificacionUsuario, objUsuario);
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaSatisfactoriaModificarUsuario(objUsuarioCreado);
            }
        }
    }

    @Override
    public List<UsuarioDTORespuesta> listarUsuarios() {
        List<Usuario> listaObtenida = objGestionarUsuarioGateway.listar();
        return this.objUsuarioFormateadorResultados.prepararRespuestaSatisfactoriaListarUsuarios(listaObtenida);
    }


    @Override
    public UsuarioDTORespuesta consultarUsuario(int identificacionUsuario, UsuarioDTOPeticion objDTOPeticion) {
        if (this.objGestionarUsuarioGateway.existeUsuario(identificacionUsuario) == false) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, no se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuario = this.objUsuarioFactory.crearUsuario(objDTOPeticion.getIdentificacionUsuario(),
                    objDTOPeticion.getNombresUsuario(), objDTOPeticion.getApellidosUsuario(),
                    objDTOPeticion.getRolUsuario().getIdentificacionRol(), objDTOPeticion.getRolUsuario().getTipoRol(),
                    objDTOPeticion.getEmailUsuario(),objDTOPeticion.getLoginUsuario().getUserNameLogin(),
                    objDTOPeticion.getLoginUsuario().getContraseñaLogin(),true);

            Usuario objUsuarioCreado = this.objGestionarUsuarioGateway.consultarUsuario(identificacionUsuario, objUsuario);
            return this.objUsuarioFormateadorResultados.prepararRespuestaSatisfactoriaModificarUsuario(objUsuarioCreado);
        }
    }
    
}

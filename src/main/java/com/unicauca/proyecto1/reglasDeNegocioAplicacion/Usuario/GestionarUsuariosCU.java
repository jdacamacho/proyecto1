package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.LoginDTPOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.UsuarioFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.encriptacion.PasswordEncoder;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
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
            PasswordEncoder encriptador = new PasswordEncoder();
            String contraseñaEncriptada = encriptador.obtenerContraseñaEncriptada(objDTOPeticion.getLoginUsuario().getContraseñaLogin());
            Usuario objUsuario = this.objUsuarioFactory.crearUsuario(objDTOPeticion.getIdentificacionUsuario(),
                    objDTOPeticion.getNombresUsuario(), objDTOPeticion.getApellidosUsuario(),
                    objDTOPeticion.getEmailUsuario(),objDTOPeticion.getLoginUsuario().getUserNameLogin(),
                    contraseñaEncriptada,1);
            objUsuario.setRoles(objDTOPeticion.getRoles());

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
                    objDTOPeticion.getEmailUsuario(),objDTOPeticion.getLoginUsuario().getUserNameLogin(),
                    objDTOPeticion.getLoginUsuario().getContraseñaLogin(),objDTOPeticion.getEstadoUsuario());
            objUsuario.setRoles(objDTOPeticion.getRoles());
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
    public UsuarioDTORespuesta consultarUsuario(int identificacionUsuario) {
        if (this.objGestionarUsuarioGateway.existeUsuario(identificacionUsuario) == false) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, no se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuarioConsultado = this.objGestionarUsuarioGateway.consultarUsuario(identificacionUsuario);
            return this.objUsuarioFormateadorResultados.prepararRespuestaSatisfactoriaConsultarUsuario(objUsuarioConsultado);
        }
    }

    @Override
    public UsuarioDTORespuesta agregarRol(int identificacionUsuario,Rol rol) {
        if (this.objGestionarUsuarioGateway.existeUsuario(identificacionUsuario) == false) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, no se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuario = this.objGestionarUsuarioGateway.consultarUsuario(identificacionUsuario);
            if (!objUsuario.tipoDeRolEsValidoParametrizado(rol)) {
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaFallida("Error, el rol ingresado no es valido");
            }else if(objUsuario.usuarioTieneRol(rol)){
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaFallida("Error, el rol ingresado ya existe para el usuario");
            }
             else {
                objUsuario.getRoles().add(rol);
                Usuario objUsuarioCreado = this.objGestionarUsuarioGateway.modificar(identificacionUsuario, objUsuario);
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaSatisfactoriaModificarUsuario(objUsuarioCreado);
            }
        }
    }

    @Override
    public UsuarioDTORespuesta eliminarRol(int identificacionUsuario,Rol rol) {
        if (this.objGestionarUsuarioGateway.existeUsuario(identificacionUsuario) == false) {
            return this.objUsuarioFormateadorResultados
                    .prepararRespuestaFallida("Error, no se encuentra en el sistema un usuario con la identificacion ingresada");
        } else {
            Usuario objUsuario = this.objGestionarUsuarioGateway.consultarUsuario(identificacionUsuario);
            if(!objUsuario.usuarioTieneRol(rol)){
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaFallida("Error, el rol ingresado a eliminar no pertenece al usuario");
            } else {
                objUsuario.eliminarRol(rol);
                Usuario objUsuarioCreado = this.objGestionarUsuarioGateway.modificar(identificacionUsuario, objUsuario);
                return this.objUsuarioFormateadorResultados
                        .prepararRespuestaSatisfactoriaModificarUsuario(objUsuarioCreado);
            }
        }
    }

    @Override
    public UsuarioDTORespuesta buscarPorLogin(LoginDTPOPeticion objDtpoPeticion) {
        PasswordEncoder encriptador = new PasswordEncoder();
        String contraseñaEncriptada = encriptador.obtenerContraseñaEncriptada(objDtpoPeticion.getContraseñaLogin());
        Login login = new Login(objDtpoPeticion.getUserNameLogin(), contraseñaEncriptada);
        Usuario usuario = this.objGestionarUsuarioGateway.buscarPorLogin(login);
        if( usuario == null){
            return this.objUsuarioFormateadorResultados.
                    prepararRespuestaFallida("No existe el usuario con el login ingresado");
        } else{
            return this.objUsuarioFormateadorResultados.
                    prepararRespuestaSatisfactorioConsultarLogin(usuario);
        }
    }
    
}

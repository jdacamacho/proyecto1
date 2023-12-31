package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.AdaptadoresAPI.ExternalLoginDTO;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.AdaptadoresAPI.ExternalUserDTOP;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.LoginDTPOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCUInt;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.encriptacion.PasswordEncoder;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/superUsuario")
public class UsuarioRestController {
    
    private final GestionarUsuariosCUInt objGestionarUsuariosCUInt;

    public UsuarioRestController(GestionarUsuariosCUInt objGestionarUsuariosCUInt) {
        this.objGestionarUsuariosCUInt = objGestionarUsuariosCUInt;
    }

    @PostMapping("/usuarios")
    public UsuarioDTORespuesta create(@RequestBody ExternalUserDTOP objUsuario,HttpSession httpSession ) {
        System.out.println("peticion a post usuarios" + objUsuario);
        ExternalUserDTOP objExterno = objUsuario;
        UsuarioDTOPeticion adapter = objExterno.adaptUserEntries();

        UsuarioDTORespuesta objUsuarioR = null;
        //List<String> rolObjUsuario = obtenerRolSession(httpSession);
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         objUsuarioR = objGestionarUsuariosCUInt.crearUsuario(adapter);
        //     }   
        // }
        objUsuarioR = objGestionarUsuariosCUInt.crearUsuario(adapter);
        return objUsuarioR;
    }

    @PutMapping("/usuarios/{identificacion}")
	public UsuarioDTORespuesta update(@RequestBody ExternalUserDTOP usuario, @PathVariable Integer identificacion,HttpSession httpSession) {
        ExternalUserDTOP objExterno = usuario;
        UsuarioDTOPeticion adapter = objExterno.adaptUserEntries();
		UsuarioDTORespuesta objUsuarioR = null;
        //List<String> rolObjUsuario = obtenerRolSession(httpSession);
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         objUsuarioR = objGestionarUsuariosCUInt.consultarUsuario(identificacion);
        //         if(objUsuarioR!=null){
		// 	        objUsuarioR =  objGestionarUsuariosCUInt.modificarUsuario(identificacion, adapter);
		//         }
        //     }
        // }
        objUsuarioR =  objGestionarUsuariosCUInt.modificarUsuario(identificacion, adapter);
		return objUsuarioR;
	}

    //#region METODOS PERSONALIZADOS

    @PatchMapping("/usuarios/state/{identificacion}")
	public UsuarioDTORespuesta changeUserState(@PathVariable Integer identificacion,HttpSession httpSession) {

        UsuarioDTORespuesta usuarioSeleccionado = this.getUsario(identificacion, httpSession);
        UsuarioDTOPeticion nuevoEstado = new UsuarioDTOPeticion();
        nuevoEstado.setIdentificacionUsuario(usuarioSeleccionado.getIdentificacionUsuario());
        nuevoEstado.setNombresUsuario(usuarioSeleccionado.getNombresUsuario());
        nuevoEstado.setApellidosUsuario(usuarioSeleccionado.getApellidosUsuario());
        nuevoEstado.setEmailUsuario(usuarioSeleccionado.getEmailUsuario());
        nuevoEstado.setEstadoUsuario( usuarioSeleccionado.getEstadoUsuario() == 1 ? 0 : 1 );
        nuevoEstado.setLoginUsuario(usuarioSeleccionado.getLoginUsuario());
        nuevoEstado.setRoles(usuarioSeleccionado.getRoles());

        //List<String> rolObjUsuario = obtenerRolSession(httpSession);
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         if(nuevoEstado!=null){
		// 	        usuarioSeleccionado =  objGestionarUsuariosCUInt.modificarUsuario(identificacion, nuevoEstado);
		//         }
        //     }
        // }
        usuarioSeleccionado =  objGestionarUsuariosCUInt.modificarUsuario(identificacion, nuevoEstado);

		return usuarioSeleccionado;
	}

    //#endregion

    @GetMapping("/usuarios/{identificacion}")
	public UsuarioDTORespuesta getUsario(@PathVariable Integer identificacion,HttpSession httpSession) {
		UsuarioDTORespuesta objUsuarioR = null;
        System.out.println("peticion a get usuarios");
        // List<String> rolObjUsuario = obtenerRolSession(httpSession);
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         objUsuarioR = objGestionarUsuariosCUInt.consultarUsuario(identificacion);
        //     }   
        // }
        objUsuarioR = objGestionarUsuariosCUInt.consultarUsuario(identificacion);
		return objUsuarioR;
	}

    @GetMapping("/usuarios")
    public List<UsuarioDTORespuesta> listar(
        @RequestParam(name = "rol", required = false) String rol, 
        HttpSession httpSession
    ) {
        List<UsuarioDTORespuesta> listaVacia = new ArrayList();
        //List<String> rolObjUsuario = obtenerRolSession(httpSession);

        if ( rol != null ) {
            System.out.println("peticion a get usuarios por rol " + rol);
            return this.objGestionarUsuariosCUInt.listarUsuariosPorRol(rol);
        }
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         return this.objGestionarUsuariosCUInt.listarUsuarios() ;
        //     }
        // }
        return this.objGestionarUsuariosCUInt.listarUsuarios() ;
        //return listaVacia;
    }

    @PatchMapping("/usuarios/{identificacion}")
    public UsuarioDTORespuesta addRol(@RequestBody Rol nuevoRol,@PathVariable Integer identificacion,HttpSession httpSession){
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.agregarRol(identificacion,nuevoRol);
        return objUsuarioR;
    }

    @DeleteMapping("/usuarios/{identificacion}")
    public UsuarioDTORespuesta deleteRol(@RequestBody Rol rolEliminar,@PathVariable Integer identificacion,HttpSession httpSession){
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.eliminarRol(identificacion, rolEliminar);
        return objUsuarioR;
    }

    @PostMapping("/login")
    public UsuarioDTORespuesta login(@RequestBody ExternalLoginDTO loginRequest,HttpSession httpSession){
        /**
         * Adaptar el DTO de entrada a un DTO de la capa de aplicación
         */
        LoginDTPOPeticion login = loginRequest.adaptUserEntries();

        /*
         * Buscar el usuario en la base de datos con el username del DTO de entrada
         */
        UsuarioDTORespuesta objUsuarioR = objGestionarUsuariosCUInt.buscarPorLogin(login);

        /**
         * Si el usuario no existe retornar null
         */
        if(objUsuarioR == null) return null;

        /**
         * Encriptar la contraseña del DTO de entrada
         */
        String encryptedUserPassword = new PasswordEncoder().encodePassword(login.getContraseñaLogin());
        String userPassword = objUsuarioR.getLoginUsuario().getContraseñaLogin();

        /**
         * Si la contraseña del DTO de entrada no coincide con la contraseña encriptada del usuario
         * retornar null
         */
        if(userPassword.equals(encryptedUserPassword) == false) return null;
        
        /**
         * Si el usuario existe y la contraseña coincide, almacenar el nombre de usuario en la sesión
         */
        httpSession.setAttribute("user",login.getUserNameLogin());
        //almacenarRolSession(httpSession, objUsuarioR);

        /**
         * Retornar el usuario sin la contraseña
         */
        objUsuarioR.getLoginUsuario().setContraseñaLogin(null);
        return objUsuarioR;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "Sesion terminada";
    }

    /*private void almacenarRolSession(HttpSession httpSession, UsuarioDTORespuesta objUsuarioR) {
        List<Rol> roles = objUsuarioR.getRoles();
        List<String> tiposDeRol = new ArrayList<>();
    
        for (Rol rol : roles) {
            tiposDeRol.add(rol.getTipoRol());
        }
    
        httpSession.setAttribute("rol", tiposDeRol);
    }

    private List<String> obtenerRolSession(HttpSession httpSession){
        List<String> rol = (List<String>) httpSession.getAttribute("rol");
        return rol;
    }*/
}

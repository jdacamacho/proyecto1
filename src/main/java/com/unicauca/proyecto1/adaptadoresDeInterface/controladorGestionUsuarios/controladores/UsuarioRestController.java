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
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.LoginDTPOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCUInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/apiSuperUsuario")
public class UsuarioRestController {
    
    private final GestionarUsuariosCUInt objGestionarUsuariosCUInt;

    public UsuarioRestController(GestionarUsuariosCUInt objGestionarUsuariosCUInt) {
        this.objGestionarUsuariosCUInt = objGestionarUsuariosCUInt;
    }

    @PostMapping("/usuarios")
    public UsuarioDTORespuesta create(@RequestBody UsuarioDTOPeticion objUsuario) {
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.crearUsuario(objUsuario);
        return objUsuarioR;
    }

    @PutMapping("/usuarios/{identificacion}")
	public UsuarioDTORespuesta update(@RequestBody UsuarioDTOPeticion usuario, @PathVariable Integer identificacion) {
		UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.consultarUsuario(identificacion);
		if(objUsuarioR!=null)	
		{
			objUsuarioR =  objGestionarUsuariosCUInt.modificarUsuario(identificacion, usuario);
		}
		return objUsuarioR;
	}

    @GetMapping("/usuarios/{identificacion}")
	public UsuarioDTORespuesta getUsario(@PathVariable Integer identificacion) {
		UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.consultarUsuario(identificacion);
		return objUsuarioR;
	}

    @GetMapping("/usuarios")
    public List<UsuarioDTORespuesta> listar(HttpSession httpSession) {
        List<UsuarioDTORespuesta> listaVacia = new ArrayList<>();
        if(httpSession.getAttribute("user") != null){
            return this.objGestionarUsuariosCUInt.listarUsuarios() ;
        }
        return listaVacia;
    }

    @PatchMapping("/usuarios/{identificacion}")
    public UsuarioDTORespuesta addRol(@RequestBody Rol nuevoRol,@PathVariable Integer identificacion){
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.agregarRol(identificacion,nuevoRol);
        return objUsuarioR;
    }

    @DeleteMapping("/usuarios/{identificacion}")
    public UsuarioDTORespuesta deleteRol(@RequestBody Rol rolEliminar,@PathVariable Integer identificacion){
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.eliminarRol(identificacion, rolEliminar);
        return objUsuarioR;
    }

    @PostMapping("/usuariosLogin")
    public UsuarioDTORespuesta login(@RequestBody LoginDTPOPeticion login,HttpSession session){
        UsuarioDTORespuesta objUsuarioR = null;
        objUsuarioR = objGestionarUsuariosCUInt.buscarPorLogin(login);
        if(objUsuarioR.getLoginUsuario().getContraseñaLogin().equals(login.getContraseñaLogin())){
            session.setAttribute("user",login.getUserNameLogin());
            session.setAttribute("roles",objUsuarioR.getRoles());
        }else{
            objUsuarioR = null;
        }
        return objUsuarioR;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "Sesion terminada";
    }
}

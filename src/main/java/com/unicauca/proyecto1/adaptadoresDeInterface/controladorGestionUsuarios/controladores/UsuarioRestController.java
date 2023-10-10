package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.controladores;

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

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTORespuesta.UsuarioDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCUInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

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
    public List<UsuarioDTORespuesta> listar() {
        return this.objGestionarUsuariosCUInt.listarUsuarios() ;
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
}

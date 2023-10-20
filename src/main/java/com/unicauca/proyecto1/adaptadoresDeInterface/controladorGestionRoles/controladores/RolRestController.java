package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionRoles.DTORespuesta.RolDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Rol.GestionarRolCUInt;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/SuperUsuarioRoles")
public class RolRestController {
    
    private final GestionarRolCUInt objGestionarRolCUInt;

    public RolRestController(GestionarRolCUInt objgGestionarRolCUInt){
        this.objGestionarRolCUInt = objgGestionarRolCUInt;
    }

    @GetMapping("/roles")
    public List<RolDTORespuesta> listar(HttpSession httpSession) {
        List<RolDTORespuesta> listaVacia = new ArrayList<>();
        List<String> rolObjUsuario = obtenerRolSession(httpSession);
        // if(httpSession.getAttribute("user") != null){
        //     if(rolObjUsuario.contains("Administrador")){
        //         listaVacia = this.objGestionarRolCUInt.listarRoles() ;
        //         return listaVacia;
        //     }
        // }
        listaVacia = this.objGestionarRolCUInt.listarRoles() ;
        return listaVacia;
    }

    private List<String> obtenerRolSession(HttpSession httpSession){
        List<String> rol = (List<String>) httpSession.getAttribute("rol");
        return rol;
    }
}

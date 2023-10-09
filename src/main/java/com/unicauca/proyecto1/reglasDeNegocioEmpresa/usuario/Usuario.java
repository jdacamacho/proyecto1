package com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario;


import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    /* Atributos del usuario */
    private int identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private List<Rol> roles;
    private String emailUsuario;
    private Login loginUsuario;
    private boolean estadoUsuario;

    public Usuario(){

    }

    public boolean tipoDeRolEsValido(){
        System.out.println("determinando si el rol de usuario es valido");
        boolean bandera = true;
        /*if(this.getRolUsuario().getCodigoRol() >= 2 && this.getRolUsuario().getCodigoRol() <=8){
            /* La bandera cambiara a verdadera si cumplimos con el rango de roles */
            //bandera = true;
        //}
        return bandera;
    }
}

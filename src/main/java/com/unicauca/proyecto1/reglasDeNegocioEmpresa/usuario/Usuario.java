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

    public boolean usuarioTieneRol(String tipoRol){
        System.out.println("determinando si el usuario tiene el rol");
        boolean bandera = false;
        for(int i = 0 ; i<this.roles.size();i++){
            if(this.roles.get(i).getTipoRol().equals(tipoRol)){
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    public boolean eliminarRol(String tipoRol){
        System.out.println("determinando si el usuario tiene el rol a eliminar");
        boolean bandera = false;
        for(int i = 0 ; i<this.roles.size();i++){
            if(this.roles.get(i).getTipoRol().equals(tipoRol)){
                this.roles.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }
}

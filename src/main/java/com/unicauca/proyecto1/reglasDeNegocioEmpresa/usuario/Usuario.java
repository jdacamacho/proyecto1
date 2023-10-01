package com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario;


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
    private Rol rolUsuario;
    private String emailUsuario;
    private Login loginUsuario;
    private boolean estadoUsuario;

    public Usuario(){

    }

    /**verificamos que el usuario a crear tiene un rol existente en el sistema*/
    public boolean tipoDeRolEsValido(){
        System.out.println("determinando si el rol de usuario es valido");
        boolean bandera = false;
        /*Retornamos verdadero siempre y cuando los roles esten en el rango permitido 2 - 6 */
        /* Roles*/
        /* 1: Administrador , 2:Director , 3:Miembro del comite del programa */
        /* 4: Jefe de departamento , 5: Miembro del jefe de departamento*/
        /* 6: evaluadores , 7: Consejo de facultad , 8: jurados*/
        if(this.getRolUsuario().getCodigoRol() >= 2 && this.getRolUsuario().getCodigoRol() <=8){
            /* La bandera cambiara a verdadera si cumplimos con el rango de roles */
            bandera = true;
        }
        return bandera;
    }
}

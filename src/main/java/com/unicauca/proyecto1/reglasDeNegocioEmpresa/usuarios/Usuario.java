package com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuarios;


import com.unicauca.proyecto1.reglasDeNegocioEmpresa.roles.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    private String identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private Rol rolUsuario;

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
        if(this.getRolUsuario().getIdentificacionRol() >= 2 && this.getRolUsuario().getIdentificacionRol() <=8){
            bandera = true;
        }
        return bandera;
    }
}

package com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario;


import java.util.ArrayList;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    
    private int identificacionUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
    private List<Rol> roles;
    private String emailUsuario;
    private Login loginUsuario;
    private int estadoUsuario;

    public Usuario(){
        
    }

    public boolean tipoDeRolEsValido(){
        System.out.println("determinando si el rol de usuario es valido");
        boolean bandera = false;
        List<Rol> rolesPermitidos = this.rolesPermitidos();
        for(int i = 0 ; i < this.roles.size() ; i++){
            for(int j = 0 ; j < rolesPermitidos.size() ; j++){
                if(this.roles.get(i).getCodigoRol() == rolesPermitidos.get(j).getCodigoRol()){
                    if(this.roles.get(i).getTipoRol().equals(rolesPermitidos.get(j).getTipoRol())){
                        bandera = true;
                    }
                    break;
                }
            }
        }
        return bandera;
    }

    public boolean tipoDeRolEsValidoParametrizado(Rol rol){
        System.out.println("determinando si el rol de usuario es valido");
        boolean bandera = false;
        List<Rol> rolesPermitidos = this.rolesPermitidos();
        for(int i = 0 ; i < rolesPermitidos.size() ; i++){
            if(rolesPermitidos.get(i).getCodigoRol() == rol.getCodigoRol()){
                if(rolesPermitidos.get(i).getTipoRol().equals(rol.getTipoRol())){
                    bandera = true;
                }
                break;
            }
        }
        return bandera;
    }

    public boolean usuarioTieneRol(Rol rol){
        System.out.println("determinando si el usuario tiene el rol");
        boolean bandera = false;
        for(int i = 0 ; i<this.roles.size();i++){
            if(this.roles.get(i).getCodigoRol() == rol.getCodigoRol()){
                if(this.roles.get(i).getTipoRol().equals(rol.getTipoRol())){
                    bandera = true;
                }
                break;
            }
        }
        return bandera;
    }

    public boolean eliminarRol(Rol rol){
        System.out.println("determinando si el usuario tiene el rol a eliminar");
        boolean bandera = false;
        for(int i = 0 ; i<this.roles.size();i++){
            if(this.roles.get(i).getCodigoRol() == rol.getCodigoRol()){
                if(this.roles.get(i).getTipoRol().equals(rol.getTipoRol())){
                    this.roles.remove(i);
                    bandera = true;
                }
                break;
            }
        }
        return bandera;
    }

    public List<Rol> rolesPermitidos(){
        List<Rol> rolesValidos = new ArrayList<>();
        /*Roles */
        Rol administrador = new Rol(1,"Administrador");
        Rol director = new Rol(2,"Director");
        Rol comite = new Rol(3,"Comite del programa");
        Rol jefeDepartamento = new Rol (4,"Jefe de departamento");
        Rol asistenteJefeDepartamento = new Rol(5,"Asistente del jefe de departamento");
        Rol estudiante = new Rol(6,"Estudiante");
        Rol evaluador = new Rol(7,"Evaluador");
        rolesValidos.add(administrador);
        rolesValidos.add(director);
        rolesValidos.add(comite);
        rolesValidos.add(jefeDepartamento);
        rolesValidos.add(asistenteJefeDepartamento);
        rolesValidos.add(estudiante);
        rolesValidos.add(evaluador);
        return rolesValidos;
    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.AdaptadoresAPI;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionUsuarios.DTOPeticion.UsuarioDTOPeticion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.login.Login;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ExternalUserDTOP {
    private Integer id;
    private String name;
    private String lastname;
    private List<ExternalRoleDTOP> roles;
    private String email;
    private String username;
    private String password;
    private boolean state;

    public ExternalUserDTOP(){

    }

    public UsuarioDTOPeticion adaptUserEntries(){
        

        UsuarioDTOPeticion user = new UsuarioDTOPeticion();

        Login login = new Login();
        login.setUserNameLogin(this.username);
        login.setContraseñaLogin(this.password);
        
        List<Rol> roles = new ArrayList<Rol>();
        for (ExternalRoleDTOP role : this.roles) {
            Rol rol = new Rol();
            rol.setCodigoRol(role.id);
            rol.setTipoRol(role.type);
            roles.add(rol);
        }

        user.setIdentificacionUsuario(this.id);
        user.setNombresUsuario(this.name);
        user.setApellidosUsuario(this.lastname);
        user.setRoles(roles);
        user.setEmailUsuario(this.email);
        user.setEstadoUsuario(this.state ? 1 : 0);
        user.setLoginUsuario(login);

        return user;
    }
}

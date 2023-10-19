package com.unicauca.proyecto1.frameworks.repositorios.entidades;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "identificacionusuario")
    private int identificacionUsuario;

    @Column(name = "nombresusuario")
    private String nombresUsuario;

    @Column(name = "apellidosusuario")
    private String apellidosUsuario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name="usuariorol",joinColumns = @JoinColumn(name="identificacionusuario", referencedColumnName="identificacionusuario"),
        inverseJoinColumns = @JoinColumn(name="codigorol", referencedColumnName="codigorol")
    )
    private List<RolEntity> roles;

    @Column(name = "emailusuario")
    private String emailUsuario;

    @Embedded
    private LoginEntity loginUsuario;

    @Column(name = "estadousuario")
    private int estadoUsuario;
    

    public UsuarioEntity(){
        this.roles = new ArrayList<>();
    }
}

package com.unicauca.proyecto1.frameworks.repositorios.entidades;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")
public class UsuarioEntity {
    @Id
    @Column(name = "identificacionUsuario")
    private int identificacionUsuario;

    @Column(name = "nombresUsuario")
    private String nombresUsuario;

    @Column(name = "apellidosUsuario")
    private String apellidosUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="usuario_roles",joinColumns = @JoinColumn(name="identificacionUsuario", referencedColumnName="identificacionUsuario"),
        inverseJoinColumns = @JoinColumn(name="codigoRol", referencedColumnName="codigoRol")
    )
    private List<RolEntity> roles;

    @Column(name = "emailUsuario")
    private String emailUsuario;

    @Embedded
    private LoginEntity loginUsuario;

    @Column(name = "estadoUsuario")
    private int estadoUsuario;

    public UsuarioEntity(){
        this.roles = new ArrayList<>();
    }
}

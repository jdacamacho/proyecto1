package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class RolEntity {
    @Id
    @Column(name="codigorol")
    private int codigoRol;
    @Column(name="tiporol")
    private String tipoRol;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UsuarioEntity> usuarios;

    public RolEntity(){

    }
}

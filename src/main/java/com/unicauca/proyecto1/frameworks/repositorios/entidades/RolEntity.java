package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class RolEntity {
    @Id
    @Column(name="codigoRol")
    private int codigoRol;
    @Column(name="tipoRol")
    private String tipoRol;

    public RolEntity(){

    }
}

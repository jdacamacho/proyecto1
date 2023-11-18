package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

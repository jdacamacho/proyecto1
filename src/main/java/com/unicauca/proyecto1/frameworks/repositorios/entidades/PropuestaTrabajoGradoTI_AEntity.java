package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "propuestastrabajogradoti_a")
public class PropuestaTrabajoGradoTI_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpropuestatrabajogradotia")
    private int idPropuestaTrabajoGradoTIA;

    @ManyToOne
    @JoinColumn(name = "identificaciondirectortia")
    private UsuarioEntity identificacionDirectorTIA;

    @ManyToOne
    @JoinColumn(name = "identificacionestudiante1tia")
    private UsuarioEntity identificacionEstudiante1TIA;

    @ManyToOne
    @JoinColumn(name = "identificacioncodirectortia")
    private UsuarioEntity identificacionCodirectorTIA;

    @ManyToOne
    @JoinColumn(name = "identificacionestudiante2tia")
    private UsuarioEntity identificacionEstudiante2TIA;

    @Column(name = "titulopropuestatrabajogradotia")
    private String tituloPropuestaTrabajoGradoTIA;

    @Column(name = "fechasubidopropuestatrabajogradotia")
    private Date fechaSubidoPropuestaTrabajoGradoTIA;

    @Column(name = "fecharespuestapropuestatrabajogradotia")
    private Date fechaRespuestaPropuestaTrabajoGradoTIA;

    @Column(name = "estadopropuestatrabajogradotia")
    private String estadoPropuestaTrabajoGradoTIA;

    @Column(name = "rutapropuestatrabajogradotia")
    private String rutaPropuestaTrabajoGradoTIA;

    public PropuestaTrabajoGradoTI_AEntity(){

    }
}

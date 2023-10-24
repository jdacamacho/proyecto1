package com.unicauca.proyecto1.frameworks.repositorios.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private String tituloPropuestaTrabajoGrado;

    @Column(name = "fechasubidopropuestatrabajogradotia")
    private Date fechaSubidoPropuestaTrabajoGrado;

    @Column(name = "rutapropuestatrabajogradotia")
    private String rutaPropuestaTrabajoGrado;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "idPropuestaTrabajoGradoTIA")
    private List<RevisionComiteEntity> revisioncomiteti_a;

    public PropuestaTrabajoGradoTI_AEntity(){
        this.revisioncomiteti_a = new ArrayList<RevisionComiteEntity>();
    }
}

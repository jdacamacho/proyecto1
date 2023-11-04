package com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "propuestastrabajogradopp_a")
public class PropuestaTrabajoGradoPP_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpropuestatrabajogradoppa")
    private int idPropuestaTrabajoGradoPPA;

    @ManyToOne
    @JoinColumn(name = "identificaciondirectorppa")
    private UsuarioEntity identificacionDirectorPPA;

    @ManyToOne
    @JoinColumn(name = "identificacionestudianteppa")
    private UsuarioEntity identificacionEstudiantePPA;

    @ManyToOne
    @JoinColumn(name = "identificacioncodirectorppa")
    private UsuarioEntity identificacionCodirectorPPA;

    @ManyToOne
    @JoinColumn(name = "identificacionasesorppa")
    private UsuarioEntity identificacionAsesorPPA;

    @Column(name = "titulopropuestatrabajogradoppa")
    private String tituloPropuestaTrabajoGrado;

    @Column(name = "fechasubidopropuestatrabajogradoppa")
    private Date fechaSubidoPropuestaTrabajoGrado;

    @Column(name = "rutapropuestatrabajogradoppa")
    private String rutaPropuestaTrabajoGrado;

    @Column(name = "rutarespuestatrabajogrado")
    private String rutaRespuestaPropuestaTrabajoGrado;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE )
    @JoinTable(
        name="historialpp_a",joinColumns = @JoinColumn(name="idpropuestatrabajogradoppa", referencedColumnName="idpropuestatrabajogradoppa"),
        inverseJoinColumns = @JoinColumn(name="idrevisioncomite", referencedColumnName="idrevisioncomite")
    )
    private List<RevisionComitePP_AEntity> revisiones;

    public PropuestaTrabajoGradoPP_AEntity(){
        this.revisiones = new ArrayList<>();
    }
}

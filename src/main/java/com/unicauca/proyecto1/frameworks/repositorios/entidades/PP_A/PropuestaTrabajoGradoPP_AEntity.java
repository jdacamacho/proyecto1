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
@Table(name = "PropuestasTrabajoGradoPP_A")
public class PropuestaTrabajoGradoPP_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPropuestaTrabajoGradoPP_A")
    private int idPropuestaTrabajoGradoPPA;

    @ManyToOne
    @JoinColumn(name = "identificacionDirectorPP_A")
    private UsuarioEntity identificacionDirectorPPA;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiantePP_A")
    private UsuarioEntity identificacionEstudiantePPA;

    @ManyToOne
    @JoinColumn(name = "identificacionCodirectorPP_A")
    private UsuarioEntity identificacionCodirectorPPA;

    @ManyToOne
    @JoinColumn(name = "identificacionAsesorPP_A")
    private UsuarioEntity identificacionAsesorPPA;

    @Column(name = "tituloPropuestaTrabajoGradoPP_A")
    private String tituloPropuestaTrabajoGrado;

    @Column(name = "fechaSubidoPropuestaTrabajoGradoPP_A")
    private Date fechaSubidoPropuestaTrabajoGrado;

    @Column(name = "rutaPropuestaTrabajoGradoPP_A")
    private String rutaPropuestaTrabajoGrado;

    @Column(name = "rutaRespuestaTrabajoGrado")
    private String rutaRespuestaPropuestaTrabajoGrado;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE )
    @JoinTable(
        name="historialPP_A",joinColumns = @JoinColumn(name="idPropuestaTrabajoGradoPP_A", referencedColumnName="idPropuestaTrabajoGradoPP_A"),
        inverseJoinColumns = @JoinColumn(name="idRevisionComite", referencedColumnName="idRevisionComite")
    )
    private List<RevisionComitePP_AEntity> revisiones;

    public PropuestaTrabajoGradoPP_AEntity(){
        this.revisiones = new ArrayList<>();
    }
}

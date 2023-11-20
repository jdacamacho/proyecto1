package com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A;

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
@Table(name = "PropuestasTrabajoGradoTI_A")
public class PropuestaTrabajoGradoTI_AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPropuestaTrabajoGradoTI_A")
    private int idPropuestaTrabajoGradoTIA;

    @ManyToOne
    @JoinColumn(name = "identificacionDirectorTI_A")
    private UsuarioEntity identificacionDirectorTIA;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiante1TI_A")
    private UsuarioEntity identificacionEstudiante1TIA;

    @ManyToOne
    @JoinColumn(name = "identificacionCodirectorTI_A")
    private UsuarioEntity identificacionCodirectorTIA;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiante2TI_A")
    private UsuarioEntity identificacionEstudiante2TIA;

    @Column(name = "tituloPropuestaTrabajoGradoTI_A")
    private String tituloPropuestaTrabajoGrado;

    @Column(name = "fechaSubidoPropuestaTrabajoGradoTI_A")
    private Date fechaSubidoPropuestaTrabajoGrado;

    @Column(name = "rutaPropuestaTrabajoGradoTI_A")
    private String rutaPropuestaTrabajoGrado;

    @Column(name = "rutaRespuestaPropuestaTrabajoGrado")
    private String rutaRespuestaPropuestaTrabajoGrado;

    @Column(name = "estadoPropuestaTrabajoGradoTI_A")
    private int estadoPropuestaTrabajoGradoTIA;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE )
    @JoinTable(
        name="historialTI_A",joinColumns = @JoinColumn(name="idPropuestaTrabajoGradotTI_A", referencedColumnName="idPropuestaTrabajoGradoTI_A"),
        inverseJoinColumns = @JoinColumn(name="idRevisionComite", referencedColumnName="idRevisionComite")
    )
    private List<RevisionComiteTI_AEntity> revisiones;

    public PropuestaTrabajoGradoTI_AEntity(){
        this.revisiones = new ArrayList<>();
    }
}

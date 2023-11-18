package com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_B;

import java.util.ArrayList;
import java.util.Date;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.TI_A.PropuestaTrabajoGradoTI_AEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Entity(name = "AnteproyectosTI_B")
@Data
@AllArgsConstructor
public class AnteproyectoTI_BEntity {
    @Id
    @Column(name = "idAnteproyectoTI_b")
    private int idAnteProyectoTIB;

    @ManyToOne
    @JoinColumn(name = "idPropuestaTI_B")
    private PropuestaTrabajoGradoTI_AEntity idPropuestaTIA;
    
    @ManyToOne
    @JoinColumn(name = "identificacionDirectorTI_B")
    private UsuarioEntity identificacionDirectorTIB;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiante1TI_B")
    private UsuarioEntity identificacionEstudiante1TIB;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiante2TI_B")
    private UsuarioEntity identificacionEstudiante2TIB;

    @ManyToOne
    @JoinColumn(name = "identificacionCodirectorTI_B")
    private UsuarioEntity identificacionCodirector;

    @Column(name = "tituloAnteproyectoTI_B")
    private String tituloAnteproyecto;

    @Column(name = "fechaRecepcionAnteproyectoTI_B")
    private Date fechaRecepcionAnteproyectoTIB;

    @Column(name = "rutaAnteproyecto")
    private String rutaAnteproyectoTIB;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name="versiones_anteproyecto_TI_B",
        joinColumns = @JoinColumn(name = "idAnteproyectoTI_B",referencedColumnName = "idAnteproyectoTI_b"),
        inverseJoinColumns = @JoinColumn(name = "idRevisionAteproyectoTI_B" ,referencedColumnName = "idRevision"))
    private List<RevisionTI_BEntity> revisiones; 

    public AnteproyectoTI_BEntity(){
        this.revisiones = new ArrayList<>();
    }


}
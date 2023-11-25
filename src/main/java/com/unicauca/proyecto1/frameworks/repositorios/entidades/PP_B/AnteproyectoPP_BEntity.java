package com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.frameworks.repositorios.entidades.UsuarioEntity;
import com.unicauca.proyecto1.frameworks.repositorios.entidades.PP_A.PropuestaTrabajoGradoPP_AEntity;

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

@Entity(name = "AnteproyectosPP_B")
@Data
@AllArgsConstructor
public class AnteproyectoPP_BEntity {
    @Id
    @Column(name = "idAnteproyectoPP_B")
    private String idAnteproyectoPPB;

    @ManyToOne
    @JoinColumn(name = "idPropuestaPP_A")
    private PropuestaTrabajoGradoPP_AEntity idPropuestaPPA;
    
    @ManyToOne
    @JoinColumn(name = "identificacionDirectorPP_B")
    private UsuarioEntity identificacionDirectorPPB;

    @ManyToOne
    @JoinColumn(name = "identificacionAsesorPP_B")
    private UsuarioEntity identificacionAsesorPPB;

    @ManyToOne
    @JoinColumn(name = "identificacionEstudiantePP_B")
    private UsuarioEntity identificacionEstudiantePPB;

    @ManyToOne
    @JoinColumn(name = "identificacionCodirectorPP_B")
    private UsuarioEntity identificacionCodirector;

    @Column(name = "tituloAnteproyectoPP_B")
    private String tituloAnteproyecto;

    @Column(name = "fechaRecepcionAnteproyectoPP_B")
    private Date fechaRecepcionAnteproyectoPPB;

    @Column(name = "rutaAnteproyectoV1")
    private String rutaAnteproyectoPPBV1;

    @Column(name = "rutaAnteproyectoV2")
    private String rutaAnteproyectoPPBV2;

    @Column(name = "rutaAnteproyectoV3")
    private String rutaAnteproyectoPPBV3;

    @Column(name = "rutaTI_C")
    private String rutaFormatoTI_C;

    @Column(name = "estado")
    private String estado;

    @Column(name = "version")
    private int nVersion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="versiones_anteproyecto_PP_B",
        joinColumns = @JoinColumn(name = "idAnteproyectoPP_B",referencedColumnName = "idAnteproyectoPP_B"),
        inverseJoinColumns = @JoinColumn(name = "idRevisionAteproyectoPP_B" ,referencedColumnName = "idRevision"))
    private List<RevisionPP_BEntity> revisiones; 

    public AnteproyectoPP_BEntity(){
        this.revisiones = new ArrayList<>();
    }

}

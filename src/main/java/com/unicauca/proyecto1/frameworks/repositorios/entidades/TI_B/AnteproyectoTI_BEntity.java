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

@Entity(name = "anteproyectoti_b")
@Data
@AllArgsConstructor
public class AnteproyectoTI_BEntity {
    @Id
    @Column(name = "idanteproyectotib")
    private int idAnteProyectoTIB;

    @ManyToOne
    @JoinColumn(name = "idpropuestatia")
    private PropuestaTrabajoGradoTI_AEntity idPropuestaTIA;
    
    @ManyToOne
    @JoinColumn(name = "identificaciondirectortib")
    private UsuarioEntity identificacionDirectorTIB;

    @ManyToOne
    @JoinColumn(name = "identificacionestudiante1tib")
    private UsuarioEntity identificacionEstudiante1TIB;

    @ManyToOne
    @JoinColumn(name = "identificacionestudiante2tib")
    private UsuarioEntity identificacionEstudiante2TIB;

    @ManyToOne
    @JoinColumn(name = "identificacioncodirector")
    private UsuarioEntity identificacionCodirector;

    @Column(name = "tituloanteproyectotib")
    private String tituloAnteproyecto;

    @Column(name = "fecharecepcionanteproyectotib")
    private Date fechaRecepcionAnteproyectoTIB;

    @Column(name = "rutaanteproyectotib")
    private String rutaAnteproyectoTIB;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(name="versiones_anteproyecto_tib",
        joinColumns = @JoinColumn(name = "idanteproyectotib",referencedColumnName = "idanteproyectotib"),
        inverseJoinColumns = @JoinColumn(name = "idrevisionevaluadortib" ,referencedColumnName = "idrevision"))
    private List<RevisionTI_BEntity> revisiones; 

    public AnteproyectoTI_BEntity(){
        this.revisiones = new ArrayList<>();
    }


}

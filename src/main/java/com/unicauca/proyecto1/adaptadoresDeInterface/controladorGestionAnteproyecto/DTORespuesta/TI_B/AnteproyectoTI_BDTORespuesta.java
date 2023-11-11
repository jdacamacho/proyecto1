package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B;

import java.util.ArrayList;
import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;


@Data
@AllArgsConstructor
public class AnteproyectoTI_BDTORespuesta {
    private int idAnteProyectoTIB;
    private Usuario identificacionDirectorTIB;
    private Usuario identificacionEstudiante1TIB;
    private Usuario identificacionEstudiante2TIB;
    private Usuario identificacionCodirector;
    private String tituloAnteproyecto;
    private Date fechaRecepcionAnteproyectoTIB;
    private String rutaAnteproyectoTIB;
    private List<RevisionTI_BDTORespuesta> revisiones; 

    public AnteproyectoTI_BDTORespuesta(){
        this.revisiones = new ArrayList<>();
    }


}

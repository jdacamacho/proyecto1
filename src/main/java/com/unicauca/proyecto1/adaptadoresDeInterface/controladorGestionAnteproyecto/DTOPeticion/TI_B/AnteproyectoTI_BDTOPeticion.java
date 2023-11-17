package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionTI_BDTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnteproyectoTI_BDTOPeticion {
    private int idAnteProyectoTIB;
    private int idPropuestaTIA;
    private int identificacionDirectorTIB;
    private int identificacionEstudiante1TIB;
    private int identificacionEstudiante2TIB;
    private int identificacionCodirector;
    private String tituloAnteproyecto;
    private Date fechaRecepcionAnteproyectoTIB;
    private String rutaAnteproyectoTIB;
    private List<RevisionTI_BDTORespuesta> revisiones; 

    public AnteproyectoTI_BDTOPeticion(){
        this.revisiones = new ArrayList<>();
    }
}

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnteproyectoPP_BDTOPeticion {
    private int idAnteProyectoPPB;
    private int idPropuestaPPA;
    private int identificacionDirectorPPB;
    private int identificacionEstudiantePPB;
    private int identificacionAsesorPPB;
    private int identificacionCodirector;
    private String tituloAnteproyecto;
    private List<RevisionPP_BDTOPeticion> revisiones; 

    public AnteproyectoPP_BDTOPeticion(){
        this.revisiones = new ArrayList<>();
    }

    public AnteproyectoPP_BDTOPeticion(int idAnteProyectoTIB,int idPropuestaTIA,
                                        int identificacionDirectorTIB,
                                        int identificacionEstudiante1TIB,
                                        int  identificacionEstudiante2TIB,
                                        int identificacionCodirector,
                                        String tituloAnteproyecto){
        this.idAnteProyectoPPB = idAnteProyectoTIB;
        this.idPropuestaPPA = idPropuestaTIA;
        this.identificacionDirectorPPB = identificacionDirectorTIB;
        this.identificacionEstudiantePPB = identificacionEstudiante1TIB;
        this.identificacionAsesorPPB = identificacionEstudiante2TIB;
        this.identificacionCodirector = identificacionCodirector;
        this.tituloAnteproyecto = tituloAnteproyecto;
        this.revisiones = new ArrayList<>();
    }
}

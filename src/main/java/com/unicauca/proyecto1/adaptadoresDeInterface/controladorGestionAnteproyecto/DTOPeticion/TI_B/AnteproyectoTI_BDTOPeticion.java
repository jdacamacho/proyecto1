package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B;
import java.util.ArrayList;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;

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
    private List<RevisionComiteDTOPeticion> revisiones; 

    public AnteproyectoTI_BDTOPeticion(){
        this.revisiones = new ArrayList<>();
    }

    public AnteproyectoTI_BDTOPeticion(int idAnteProyectoTIB,int idPropuestaTIA,
                                        int identificacionDirectorTIB,
                                        int identificacionEstudiante1TIB,
                                        int  identificacionEstudiante2TIB,
                                        int identificacionCodirector,
                                        String tituloAnteproyecto){
        this.idAnteProyectoTIB = idAnteProyectoTIB;
        this.idPropuestaTIA = idPropuestaTIA;
        this.identificacionDirectorTIB = identificacionDirectorTIB;
        this.identificacionEstudiante1TIB = identificacionEstudiante1TIB;
        this.identificacionEstudiante2TIB = identificacionEstudiante2TIB;
        this.identificacionCodirector = identificacionCodirector;
        this.tituloAnteproyecto = tituloAnteproyecto;
        this.revisiones = new ArrayList<>();

    }
}

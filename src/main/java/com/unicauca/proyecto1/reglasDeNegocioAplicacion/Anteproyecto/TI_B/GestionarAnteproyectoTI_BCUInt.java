package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;

public interface GestionarAnteproyectoTI_BCUInt {
    AnteproyectoTI_BDTORespuesta crearAnteproyecto(AnteproyectoTI_BDTOPeticion peticion,MultipartFile file);
}

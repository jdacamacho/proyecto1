package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;

public interface GestionarTI_ACUInt {
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas();
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoTI_ADTOPeticion objPeticion,MultipartFile file);
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(int idPropuesta);
    public RevisionComiteDTORespuesta realizarRevision (RevisionComiteDTOPeticion objPeticion);
    public PropuestaTrabajoGradoTI_ADTORespuesta anexarPropuestaAprobado(int idPropuesta,MultipartFile file);
    public boolean existePropuesta(int idPropuesta);
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestasDirector(int idDirector);
}   

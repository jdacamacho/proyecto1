package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;

public interface GestionarPP_ACUInt {
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestas();
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoPP_ADTOPeticion objPeticion,MultipartFile file);
    public PropuestaTrabajoGradoPP_ADTORespuesta consultarPropuesta(int idPropuesta);
    public RevisionComiteDTORespuesta realizarRevision (RevisionComiteDTOPeticion objPeticion);
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarPropuestaAprobado(int idComiteRevisa,int idPropuesta,MultipartFile file);
    public boolean existePropuesta(int idPropuesta);
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestasDirector(int idDirector);
    public void observadorNotificacionComite(PropuestaTrabajoGradoPP_A propuestaRegistrada);
}   

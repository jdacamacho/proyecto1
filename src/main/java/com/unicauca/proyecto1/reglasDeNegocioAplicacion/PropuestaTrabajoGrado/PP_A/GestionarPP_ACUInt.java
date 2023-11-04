package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;

public interface GestionarPP_ACUInt {
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestas();
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoPP_ADTOPeticion objPeticion);
    public PropuestaTrabajoGradoPP_ADTORespuesta consultarPropuesta(int idPropuesta);
    public RevisionComiteDTORespuesta realizarRevision (RevisionComiteDTOPeticion objPeticion);
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarPropuestaAprobado(RutaAprobadaADTOPeticion rutaAprobado);
    public boolean existePropuesta(int idPropuesta);
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestasDirector(int idDirector);
}

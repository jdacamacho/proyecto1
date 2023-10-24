package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;

public interface GestionarTI_ACUInt {
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas();
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoTI_ADTOPeticion objPeticion);
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(int idPropuesta);
    public RevisionComiteDTORespuesta realizarRevision (RevisionComiteDTOPeticion objPeticion);
    public PropuestaTrabajoGradoTI_ADTORespuesta anexarPropuestaAprobado(RutaAprobadaADTOPeticion rutaAprobado);
    public boolean existePropuesta(int idPropuesta);
}   

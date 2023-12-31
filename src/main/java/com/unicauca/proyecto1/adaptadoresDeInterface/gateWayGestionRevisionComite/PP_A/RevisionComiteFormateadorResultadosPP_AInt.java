package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.PP_A;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;

public interface RevisionComiteFormateadorResultadosPP_AInt {
    public RevisionComiteDTORespuesta prepararRespuestaSatisfactoriaCrearRevision(RevisionComite objRevisionCreado);
    public RevisionComiteDTORespuesta prepararRespuestaFallida(String error);
}

package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarPropuestaTrabajoGradoPP_AGatewayInt {
    public List<PropuestaTrabajoGradoPP_A> listar();
    public PropuestaTrabajoGradoPP_A consultarPropuesta(int idPropuesta);
    public PropuestaTrabajoGradoPP_A guardar(PropuestaTrabajoGradoPP_A objPropuesta);
    public PropuestaTrabajoGradoPP_A modificar(int id,PropuestaTrabajoGradoPP_A objPropuesta);
    public boolean existePropuesta(int idPropuesta);
    public List<PropuestaTrabajoGradoPP_A> listarPorDirector(Usuario idDirector);
    
    public List<PropuestaTrabajoGradoPP_A> listarPropuestasPorEstado(int estado);
    public List<PropuestaTrabajoGradoPP_A> listarPorDirectorYestado(Usuario idDirector, int estado);
}

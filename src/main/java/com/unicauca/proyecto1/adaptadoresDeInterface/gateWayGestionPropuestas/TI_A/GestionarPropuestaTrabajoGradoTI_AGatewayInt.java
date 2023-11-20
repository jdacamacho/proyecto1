package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarPropuestaTrabajoGradoTI_AGatewayInt {
    public List<PropuestaTrabajoGradoTI_A> listar();
    public PropuestaTrabajoGradoTI_A consultarPropuesta(int idPropuesta);
    public PropuestaTrabajoGradoTI_A guardar(PropuestaTrabajoGradoTI_A objPropuesta);
    public PropuestaTrabajoGradoTI_A modificar(int id,PropuestaTrabajoGradoTI_A objPropuesta);
    public boolean existePropuesta(int idPropuesta);
    public List<PropuestaTrabajoGradoTI_A> listarPorDirector(Usuario idDirector);

    /** METODOS PARA CONSULTA POR ESTADO: MESA */
    public List<PropuestaTrabajoGradoTI_A> listarPropuestasPorEstado(int estado);
    public List<PropuestaTrabajoGradoTI_A> listarPorDirectorYestado(Usuario idDirector, int estado);
}

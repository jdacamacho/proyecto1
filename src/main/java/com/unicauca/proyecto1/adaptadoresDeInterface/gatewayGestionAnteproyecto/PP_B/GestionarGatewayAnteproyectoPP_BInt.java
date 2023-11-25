package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarGatewayAnteproyectoPP_BInt {
    public AnteproyectoPP_B guardar(AnteproyectoPP_B anteproyecto);
    public AnteproyectoPP_B consultarAnteproyecto(String idAnteproyecto);
    List<AnteproyectoPP_B> listarAnteproyectosDirector (Usuario objUsuarioReceptor);
    List<AnteproyectoPP_B> listarAnteproyectos();
    public boolean existeAnteproyecto(String anteproyecto);
    public long contarAnteproyectos(String idAnteproyecto);

}

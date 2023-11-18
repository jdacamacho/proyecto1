package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarGatewayAnteproyectoTI_BInt {
    public AnteproyectoTI_B guardar(AnteproyectoTI_B anteproyecto);
    public AnteproyectoTI_B consultarAnteproyecto(String idAnteproyecto);
    List<AnteproyectoTI_B> listarAnteproyectosDirector (Usuario objUsuarioReceptor);
    List<AnteproyectoTI_B> listarAnteproyectos();
    public boolean existeAnteproyecto(int anteproyecto);
    public long contarAnteproyectos(String idAnteproyecto);

}

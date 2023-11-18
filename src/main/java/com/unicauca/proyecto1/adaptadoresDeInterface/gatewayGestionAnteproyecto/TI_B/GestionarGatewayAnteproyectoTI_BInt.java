package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface GestionarGatewayAnteproyectoTI_BInt {
    public AnteproyectoTI_B guardar(AnteproyectoTI_B anteproyecto);
    public AnteproyectoTI_B consultarAnteproyecto(int idAnteproyecto);
    List<AnteproyectoTI_B> listarAnteproyecto (Usuario objUsuarioReceptor);
    public boolean existeAnteproyecto(int anteproyecto);
}

package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;

public interface GestionarGatewayRevisionEvaluadorPP_BInt {
    public RevisionEvaluadorPP_B guardar(RevisionEvaluadorPP_B revision);
    public RevisionEvaluadorPP_B consultarPorEvaluador(int idEvaluador);
    public RevisionEvaluadorPP_B consultarRevisionEvaluador(int idRevision);
    public boolean existeRevisionEvaluador(int idRevision);
    List<RevisionEvaluadorPP_B> listarAnteproyectoConcepto(String concepto);
}

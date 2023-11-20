package com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B;

import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;

public interface GestionarGatewayRevisionEvaluadorTI_BInt {
    public RevisionEvaluadorTI_B guardar(RevisionEvaluadorTI_B revision);
    public RevisionEvaluadorTI_B consultarPorEvaluador(int idEvaluador);
    public RevisionEvaluadorTI_B consultarRevisionEvaluador(int idRevision);
    public boolean existeRevisionEvaluador(int idRevision);
    List<RevisionEvaluadorTI_B> listarAnteproyectoConcepto(String concepto);
}

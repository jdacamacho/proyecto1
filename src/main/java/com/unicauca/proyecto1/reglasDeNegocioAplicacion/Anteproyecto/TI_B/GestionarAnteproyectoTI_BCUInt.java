package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.RevisionEvaluadorTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;

public interface GestionarAnteproyectoTI_BCUInt {
    AnteproyectoTI_BDTORespuesta crearAnteproyecto(AnteproyectoTI_BDTOPeticion peticion,MultipartFile file);
    AnteproyectoTI_BDTORespuesta asignarEvaluador(int idJefeDepartamento,int idEvaluador1,int idEvaluador2,String idAnteproyecto );
    public void observerNotificacionJefatura(AnteproyectoTI_B anteproyectoRegistrado);
    public AnteproyectoTI_BDTORespuesta consultarAnteproyecto(String idAnteproyecto);
    List<AnteproyectoTI_BDTORespuesta> listarAnteproyectos();
    List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosDirector(int idDirector);
    AnteproyectoTI_BDTORespuesta realizarRevisionAnteproyecto(RevisionEvaluadorTI_BDTOPeticion peticion,MultipartFile file);
    List<AnteproyectoTI_BDTORespuesta>  listarAnteproyectosEvaluadores(int idEvaluador);
    List<RevisionEvaluadorTI_BDTORespuesta> listarRevisionesAnteproyectoParaEvaluador(int idEvaluador,String idAnteproyecto);
    List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosConcepto(String concepto);
    AnteproyectoTI_BDTORespuesta anexarFormatoTI_C(String idAnteproyecto,MultipartFile file);
    AnteproyectoTI_BDTORespuesta modificarArchivoAnteproyecto(String idAnteproyecto,MultipartFile file);
}

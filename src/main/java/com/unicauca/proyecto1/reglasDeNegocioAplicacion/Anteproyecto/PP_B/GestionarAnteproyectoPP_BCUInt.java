package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.PP_B;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.AnteproyectoPP_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.RevisionEvaluadorPP_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.AnteproyectoPP_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.RevisionEvaluadorPP_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;

public interface GestionarAnteproyectoPP_BCUInt {
    AnteproyectoPP_BDTORespuesta crearAnteproyecto(AnteproyectoPP_BDTOPeticion peticion,MultipartFile file);
    AnteproyectoPP_BDTORespuesta asignarEvaluador(int idJefeDepartamento,int idEvaluador1,int idEvaluador2,String idAnteproyecto );
    public void observerNotificacionJefatura(AnteproyectoPP_B anteproyectoRegistrado);
    public AnteproyectoPP_BDTORespuesta consultarAnteproyecto(String idAnteproyecto);
    List<AnteproyectoPP_BDTORespuesta> listarAnteproyectos();
    List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosDirector(int idDirector);
    AnteproyectoPP_BDTORespuesta realizarRevisionAnteproyecto(RevisionEvaluadorPP_BDTOPeticion peticion,MultipartFile filePP_B,MultipartFile fileAnteproyectoCorreciones);
    List<AnteproyectoPP_BDTORespuesta>  listarAnteproyectosEvaluadores(int idEvaluador);
    List<RevisionEvaluadorPP_BDTORespuesta> listarRevisionesAnteproyectoParaEvaluador(int idEvaluador,String idAnteproyecto);
    List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosConcepto(String concepto);
    AnteproyectoPP_BDTORespuesta anexarFormatoTI_C(String idAnteproyecto,MultipartFile file);
    AnteproyectoPP_BDTORespuesta agregarNuevaVersionAnteproyecto(String idAnteproyecto,MultipartFile file);
    boolean existeAnteproyecto(String idAnteproyecto);
}

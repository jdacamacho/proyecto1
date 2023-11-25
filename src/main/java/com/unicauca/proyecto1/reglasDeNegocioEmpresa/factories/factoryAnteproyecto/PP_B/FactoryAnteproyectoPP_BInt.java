package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface FactoryAnteproyectoPP_BInt {
    public AnteproyectoPP_B crearAnteproyecto(String idAnteProyectoTIB,PropuestaTrabajoGradoPP_A idPropuestaTIA,
                                        Usuario identificacionDirectorTIB,Usuario identificacionEstudiante1TIB,
                                        Usuario identificacionEstudiante2TIB,Usuario identificacionCodirector,
                                        String tituloAnteproyecto,String rutaAnteproyectoTIB);

}

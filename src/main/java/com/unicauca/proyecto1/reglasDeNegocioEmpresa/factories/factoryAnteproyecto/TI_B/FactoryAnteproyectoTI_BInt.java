package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface FactoryAnteproyectoTI_BInt {
    public AnteproyectoTI_B crearAnteproyecto(String idAnteProyectoTIB,PropuestaTrabajoGradoTI_A idPropuestaTIA,
                                        Usuario identificacionDirectorTIB,Usuario identificacionEstudiante1TIB,
                                        Usuario identificacionEstudiante2TIB,Usuario identificacionCodirector,
                                        String tituloAnteproyecto,String rutaAnteproyectoTIB);

}

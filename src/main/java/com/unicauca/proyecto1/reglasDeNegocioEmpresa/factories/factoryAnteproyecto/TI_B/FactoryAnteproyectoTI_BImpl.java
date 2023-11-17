package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class FactoryAnteproyectoTI_BImpl implements FactoryAnteproyectoTI_BInt{

    @Override
    public AnteproyectoTI_B crearAnteproyecto(int idAnteProyectoTIB, PropuestaTrabajoGradoTI_A idPropuestaTIA,
            Usuario identificacionDirectorTIB, Usuario identificacionEstudiante1TIB,
            Usuario identificacionEstudiante2TIB, Usuario identificacionCodirector, String tituloAnteproyecto,
            String rutaAnteproyectoTIB) {
        List<RevisionTI_B> revisiones = new ArrayList<>();
        AnteproyectoTI_B anteproyecto = new AnteproyectoTI_B(idAnteProyectoTIB,idPropuestaTIA,
                                                        identificacionDirectorTIB,identificacionEstudiante1TIB,
                                                        identificacionEstudiante2TIB,identificacionCodirector,
                                                        tituloAnteproyecto,new Date(), rutaAnteproyectoTIB,
                                                        revisiones);                                            
        return anteproyecto;
    }
    
}

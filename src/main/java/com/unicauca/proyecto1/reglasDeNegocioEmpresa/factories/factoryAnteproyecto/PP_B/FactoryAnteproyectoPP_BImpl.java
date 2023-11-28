package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class FactoryAnteproyectoPP_BImpl implements FactoryAnteproyectoPP_BInt{

    @Override
    public AnteproyectoPP_B crearAnteproyecto(String idAnteProyectoTIB, PropuestaTrabajoGradoPP_A idPropuestaTIA,
            Usuario identificacionDirectorTIB, Usuario identificacionEstudiante1TIB,
            Usuario identificacionEstudiante2TIB, Usuario identificacionCodirector, String tituloAnteproyecto,
            String rutaAnteproyectoTIB) {
        List<RevisionPP_B> revisiones = new ArrayList<>();
        AnteproyectoPP_B anteproyecto = new AnteproyectoPP_B(idAnteProyectoTIB,idPropuestaTIA,
                                                        identificacionDirectorTIB,identificacionEstudiante1TIB,
                                                        identificacionEstudiante2TIB,identificacionCodirector,
                                                        tituloAnteproyecto,new Date(), rutaAnteproyectoTIB,"","",
                                                        revisiones,"","En revision",1);                                            
        return anteproyecto;
    }
    
}
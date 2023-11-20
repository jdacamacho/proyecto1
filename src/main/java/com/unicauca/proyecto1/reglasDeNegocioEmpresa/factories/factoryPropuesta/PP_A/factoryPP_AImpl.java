package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A;

import java.util.ArrayList;
import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryPP_AImpl implements factoryPP_AInt {

    @Override
    public PropuestaTrabajoGradoPP_A crearPP_A(
        Usuario director, 
        Usuario estudiante, 
        Usuario codirector,
        Usuario asesor, 
        String titulo, 
        Date subido, 
        String rutaPropuesta,
        int estado
    ) {
        ArrayList<RevisionComite> revisioncomitepp_a = new ArrayList<>();
        PropuestaTrabajoGradoPP_A propuesta = new PropuestaTrabajoGradoPP_A(
            director, 
            estudiante,
            codirector,
            asesor,
            titulo,
            subido,
            rutaPropuesta,
            revisioncomitepp_a,
            estado
        );
        return propuesta;
    }
    
}

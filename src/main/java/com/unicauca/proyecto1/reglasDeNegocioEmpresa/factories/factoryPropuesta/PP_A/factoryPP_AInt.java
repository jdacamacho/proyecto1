package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A;

import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public interface factoryPP_AInt {
    public PropuestaTrabajoGradoPP_A crearPP_A(
        Usuario director,
        Usuario estudiante,
        Usuario codirector,   
        Usuario asesor,
        String titulo,
        Date subido,
        String rutaPropuesta,
        int estado
    );
}
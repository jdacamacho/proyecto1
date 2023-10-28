package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A;

import java.util.ArrayList;
import java.util.Date;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryTI_AImpl implements factoryTI_AInt{

    @Override
    public PropuestaTrabajoGradoTI_A crearTI_A(Usuario director, Usuario estudiante1, Usuario codirector,
            Usuario estudiante2, String titulo, Date subido, String rutaPropuesta) {
        ArrayList<RevisionComite> revisioncomiteti_a = new ArrayList<>();
        PropuestaTrabajoGradoTI_A propuesta = new PropuestaTrabajoGradoTI_A(director, estudiante1,codirector, estudiante2, titulo, subido,rutaPropuesta,revisioncomiteti_a);
        return propuesta;
    }
    
}

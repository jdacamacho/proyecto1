package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class factoryTI_AImpl implements factoryTI_AInt{

    @Override
    public PropuestaTrabajoGradoTI_A crearTI_A(Usuario director, Usuario estudiante1, Usuario codirector,
            Usuario estudiante2, String titulo, Date subido, String rutaPropuesta) {
        List<RevisionComite> revisionesComite = new ArrayList<>();
        PropuestaTrabajoGradoTI_A propuesta = new PropuestaTrabajoGradoTI_A(director, estudiante1,codirector, estudiante2, titulo, subido,rutaPropuesta,revisionesComite);
        return propuesta;
    }
    
}

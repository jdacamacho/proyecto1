package com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;
import java.util.Date;
public interface factoryTI_AInt {
    public PropuestaTrabajoGradoTI_A crearTI_A(Usuario director,Usuario estudiante1,Usuario codirectorUsuario,   
                                    Usuario estudiante2,String titulo,Date subido,Date respuesta,
                                    String estado,String rutaPropuesta );
}

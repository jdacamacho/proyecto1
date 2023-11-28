package com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnteproyectoPP_B {
    private String idAnteproyectoPPB;
    private PropuestaTrabajoGradoPP_A idPropuestaPPA;
    private Usuario identificacionDirectorPPB;
    private Usuario identificacionEstudiantePPB;
    private Usuario identificacionAsesorPPB;
    private Usuario identificacionCodirector;
    private String tituloAnteproyecto;
    private Date fechaRecepcionAnteproyectoPPB;
    private String rutaAnteproyectoPPBV1;
    private String rutaAnteproyectoPPBV2;
    private String rutaAnteproyectoPPBV3;
    private List<RevisionPP_B> revisiones; 
    private String rutaFormatoTI_C;
    private String estado;
    private int nVersion;

    public AnteproyectoPP_B(){
        this.revisiones = new ArrayList<>();
    }

    public boolean controlMaximoDeVersiones(){
        if(this.revisiones.size() < 3){
            return true;
        }
        return false;
    }
}

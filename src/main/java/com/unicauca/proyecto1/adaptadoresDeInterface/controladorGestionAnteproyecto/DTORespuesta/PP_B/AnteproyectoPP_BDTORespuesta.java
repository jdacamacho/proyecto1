package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnteproyectoPP_BDTORespuesta {
    private String idAnteProyectoPPB;
    private PropuestaTrabajoGradoTI_A idPropuestaPPA;
    private Usuario identificacionDirectorPPB;
    private Usuario identificacionEstudiantePPB;
    private Usuario identificacionAsesorPPB;
    private Usuario identificacionCodirector;
    private String tituloAnteproyecto;
    private Date fechaRecepcionAnteproyectoPPB;
    private String rutaAnteproyectoPPBV1;
    private String rutaAnteproyectoPPBV2;
    private String rutaAnteproyectoPPBV3;
    private List<RevisionPP_BDTORespuesta> revisiones; 
    private String rutaFormatoTI_C;
    private String estado;
    private int nVersion;

    public AnteproyectoPP_BDTORespuesta(){
        this.revisiones = new ArrayList<>();
    }
}

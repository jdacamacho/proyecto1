package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.TI_B;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B.GestionarAnteproyectoTI_BCUInt;

@RestController
@RequestMapping("/apiAnteproyectoTI_B")
public class TI_BRestController {
    private final GestionarAnteproyectoTI_BCUInt anteproyectoCU;

    public TI_BRestController(GestionarAnteproyectoTI_BCUInt anteproyectoCU){
        this.anteproyectoCU = anteproyectoCU;
    }

    @PostMapping("/anteproyectos")
    public AnteproyectoTI_BDTORespuesta crearAnteproyecto(
        @RequestParam("file") MultipartFile file,
        @RequestParam("idAnteproyecto") int idAnteproyecto,
        @RequestParam("idPropuesta") int idPropuesta,
        @RequestParam(name = "idDirector") int idDirector,
        @RequestParam(name = "idEstudiante1") int idEstudiante1,
        @RequestParam(name = "idEstudiante2",required = false)  Integer idEstudiante2,
        @RequestParam(name = "idCodirector",required = false) Integer idCodirector,
        @RequestParam(name = "titulo") String titulo
    ){
        if(idEstudiante2 == null){
            idEstudiante2 = -1;
        }
        if(idCodirector == null){
            idCodirector = -1;
        }
        AnteproyectoTI_BDTOPeticion peticion = new AnteproyectoTI_BDTOPeticion(idAnteproyecto,idPropuesta,idDirector,idEstudiante1,idEstudiante2,idCodirector,titulo);
        
        return anteproyectoCU.crearAnteproyecto(peticion, file);
    }

    @PatchMapping("/anteproyectos")
    public AnteproyectoTI_BDTORespuesta asignarEvaluadores(
        @RequestParam("evaluador1") int idEvaluador1,
        @RequestParam("evaluador2") int idEvaluador2,
        @RequestParam("anteproyecto") int idAnteproyecto
    ){
        return this.anteproyectoCU.asignarEvaluador(idEvaluador1, idEvaluador2, idAnteproyecto);
    }
    
}

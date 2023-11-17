package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.TI_B;

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
        @RequestParam(name = "idEstudiante2")  Integer idEstudiante2,
        @RequestParam(name = "idCodirector") Integer idCodirector,
        @RequestParam(name = "titulo") String titulo
    ){
        AnteproyectoTI_BDTOPeticion peticion = new AnteproyectoTI_BDTOPeticion(idAnteproyecto,idPropuesta,idDirector,idEstudiante1,idEstudiante2,idCodirector,titulo);
        if(idEstudiante2 == null){
            peticion.setIdentificacionEstudiante2TIB(-1);
        }
        if(idCodirector == null){
            peticion.setIdentificacionCodirector(-1);
        }
        return anteproyectoCU.crearAnteproyecto(peticion, file);
    }

    /*@PostMapping("/propuestas")
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuestas(
        @RequestParam("file") MultipartFile file,
        @RequestParam("titulo") String titulo,
        @RequestParam("idDirector") Integer idDirector,
        @RequestParam(name = "idEstudiante1", required = false) Integer idEstudiante1,
        @RequestParam(name = "idEstudiante2", required = false) Integer idEstudiante2,
        @RequestParam(name = "idCodirector", required = false) Integer idCodirector
    ){
        PropuestaTrabajoGradoTI_ADTOPeticion objPeticion = new PropuestaTrabajoGradoTI_ADTOPeticion();
        objPeticion.setTituloPropuestaTrabajoGrado(titulo);
        objPeticion.setIdentificacionDirectorTIA(idDirector);
        objPeticion.setIdentificacionEstudiante1TIA(idEstudiante1);
        if(idCodirector == null){
            objPeticion.setIdentificacionCodirectorTIA(-1);
        }else{
            objPeticion.setIdentificacionCodirectorTIA(idCodirector);
        }
        if(idEstudiante2 == null){
            objPeticion.setIdentificacionEstudiante2TIA(-1);
        }else{
            objPeticion.setIdentificacionEstudiante2TIA(idEstudiante2);
        }
        return this.gestionarPropuestaTI_ACU.crearPropuesta(objPeticion, file);
    } */
}

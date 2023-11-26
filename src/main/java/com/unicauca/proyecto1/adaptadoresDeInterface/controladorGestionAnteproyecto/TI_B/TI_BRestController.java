package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.TI_B;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.RevisionEvaluadorTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;
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
        @RequestParam("jefeDepartamento") int idJefe,
        @RequestParam("evaluador1") int idEvaluador1,
        @RequestParam("evaluador2") int idEvaluador2,
        @RequestParam("anteproyecto") String idAnteproyecto
    ){
        return this.anteproyectoCU.asignarEvaluador(idJefe,idEvaluador1, idEvaluador2, idAnteproyecto);
    }

    @PutMapping("/anteproyectos")
    public AnteproyectoTI_BDTORespuesta revisionEvaluador(
        @RequestParam("idRevision") int idRevision,
        @RequestParam("idEvaluador") int idEvaluador,
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("conceptoRevision") String concepto,
        @RequestParam("observaciones") String observaciones,
        @RequestParam("fileTI_B") MultipartFile fileTI_B,
        @RequestParam("fileAnteproyectoRevisado") MultipartFile fileAnteproyectoRevisado
    ){
        RevisionEvaluadorTI_BDTOPeticion peticion = new RevisionEvaluadorTI_BDTOPeticion();
        peticion.setIdRevisionEvaluadorTIB(idRevision);
        peticion.setIdentificacionEvaluador(idEvaluador);
        peticion.setIdAnteproyecto(idAnteproyecto);
        peticion.setConceptoRevision(concepto);
        peticion.setObservaciones(observaciones);
        return this.anteproyectoCU.realizarRevisionAnteproyecto(peticion,fileTI_B,fileAnteproyectoRevisado);
    }

    @GetMapping("/anteproyectos")
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectos(){
        return this.anteproyectoCU.listarAnteproyectos();
    }

    @GetMapping("/anteproyectosEvaluador/{idEvaluador}")
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosEvaluador(@PathVariable int idEvaluador){
        return this.anteproyectoCU.listarAnteproyectosEvaluadores(idEvaluador);
    }

    @GetMapping("/anteproyectosDirector")
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosDirector(@RequestParam("idDirector") int idDirector){
        return this.anteproyectoCU.listarAnteproyectosDirector(idDirector);
    }

    @GetMapping("/anteproyectos/{idAnteproyecto}")
    public AnteproyectoTI_BDTORespuesta consultarAnteproyecto(@PathVariable String idAnteproyecto){
        return this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
    }

    @GetMapping("/anteproyectosRevisiones")
    public List<RevisionEvaluadorTI_BDTORespuesta> listarRevisionesAnteproyectoEvaluador(
        @RequestParam("idEvaluador") int idEvaluador,
        @RequestParam("idAnteproyecto") String idAnteproyecto
    ){
        /*Para listarle al evaluador las revisiones que puede realizar respecto a un anteproyecto */
        return this.anteproyectoCU.listarRevisionesAnteproyectoParaEvaluador(idEvaluador, idAnteproyecto);
    }

    @GetMapping("/anteproyectosConcepto")
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosConcepto(
        @RequestParam("concepto") String concepto
    ){
        return this.anteproyectoCU.listarAnteproyectosConcepto(concepto);
    }

    @PatchMapping("/anteproyectosTI_C")
    public AnteproyectoTI_BDTORespuesta anexarTI_C(
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("file") MultipartFile file
    ){
        return this.anteproyectoCU.anexarFormatoTI_C(idAnteproyecto, file);
    }

    @PatchMapping("/anteproyectosNuevo")
    public AnteproyectoTI_BDTORespuesta modificarArchivo(
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("file") MultipartFile file
    ){
        return this.anteproyectoCU.agregarNuevaVersionAnteproyecto(idAnteproyecto, file);
    }

    @GetMapping("/anteproyectosSubidos/{idAnteproyecto}/{version}")
    public ResponseEntity<Resource> descargarPropuesta(@PathVariable String idAnteproyecto, @PathVariable int version) throws IOException {       
        if(this.anteproyectoCU.existeAnteproyecto(idAnteproyecto) && version > 0 && version <4){
            AnteproyectoTI_BDTORespuesta anteproyecto = this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
            String rutaCompleta;
            if(version == 1){
                rutaCompleta = anteproyecto.getRutaAnteproyectoTIBV1();
            }else if(version == 2){
                rutaCompleta = anteproyecto.getRutaAnteproyectoTIBV2();
            }else{
                rutaCompleta = anteproyecto.getRutaAnteproyectoTIBV3();
            }

            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Anteproyecto_TI_B.docx"); 

            MediaType mediaType = MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

            return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(mediaType)
                .body(resource);
        }else{
            byte[] emptyContent = new byte[0];
            Resource emptyResource = new ByteArrayResource(emptyContent);
            
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=empty.docx");

            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(emptyResource);
        }
    } 

    @GetMapping("/anteproyectosTI_B/{idAnteproyecto}/{version}/{evaluador}")
    public ResponseEntity<Resource> descargarTI_B(@PathVariable String idAnteproyecto, @PathVariable int version,@PathVariable int evaluador) throws IOException {       
        /*Las versiones serian 3 y la recibicion de evaluador seria la del evaluador 1 o 2 */
        if(this.anteproyectoCU.existeAnteproyecto(idAnteproyecto) && version > 0 && version <4 && evaluador > 0 && evaluador < 3){
            AnteproyectoTI_BDTORespuesta anteproyecto = this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
            String rutaCompleta = "";
            if(evaluador == 1 && anteproyecto.getRevisiones().size() >= version){
                rutaCompleta = anteproyecto.getRevisiones().get(version-1).getIdentificacionEvaluador1().getRutaRespuesta();
            }
            if(evaluador == 2 && anteproyecto.getRevisiones().size() >= version){
                rutaCompleta = anteproyecto.getRevisiones().get(version-1).getIdentificacionEvaluador2().getRutaRespuesta();
            }
        
            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Anteproyecto_subido.docx"); 

            MediaType mediaType = MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

            return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(mediaType)
                .body(resource);
        }else{
            byte[] emptyContent = new byte[0];
            Resource emptyResource = new ByteArrayResource(emptyContent);
            
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=empty.docx");

            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(emptyResource);
        }
    } 
    
    
}

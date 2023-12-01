package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.PP_B;
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

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.AnteproyectoPP_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.RevisionEvaluadorPP_BDTOPeticion;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.AnteproyectoPP_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.RevisionEvaluadorPP_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.PP_B.GestionarAnteproyectoPP_BCUInt;


@RestController
@RequestMapping("/apiAnteproyectoPP_B")
public class PP_BRestController {
    private final GestionarAnteproyectoPP_BCUInt anteproyectoCU;

    public PP_BRestController(GestionarAnteproyectoPP_BCUInt anteproyectoCU){
        this.anteproyectoCU = anteproyectoCU;
    }

    @PostMapping("/anteproyectos")
    public AnteproyectoPP_BDTORespuesta crearAnteproyecto(
        @RequestParam("file") MultipartFile file,
        @RequestParam("idAnteproyecto") int idAnteproyecto,
        @RequestParam("idPropuesta") int idPropuesta,
        @RequestParam(name = "idDirector") int idDirector,
        @RequestParam(name = "idEstudiante") int idEstudiante,
        @RequestParam(name = "idAsesor",required = false)  Integer idAsesor,
        @RequestParam(name = "idCodirector",required = false) Integer idCodirector,
        @RequestParam(name = "titulo") String titulo
    ){
        if(idCodirector == null){
            idCodirector = -1;
        }
        AnteproyectoPP_BDTOPeticion peticion = new AnteproyectoPP_BDTOPeticion(idAnteproyecto,idPropuesta,idDirector,idEstudiante,idAsesor,idCodirector,titulo);
        
        return anteproyectoCU.crearAnteproyecto(peticion, file);
    }

    @PatchMapping("/anteproyectos")
    public AnteproyectoPP_BDTORespuesta asignarEvaluadores(
        @RequestParam("jefeDepartamento") int idJefe,
        @RequestParam("evaluador1") int idEvaluador1,
        @RequestParam("evaluador2") int idEvaluador2,
        @RequestParam("anteproyecto") String idAnteproyecto
    ){
        return this.anteproyectoCU.asignarEvaluador(idJefe,idEvaluador1, idEvaluador2, idAnteproyecto);
    }

    @PutMapping("/anteproyectos")
    public AnteproyectoPP_BDTORespuesta revisionEvaluador(
        @RequestParam("idRevision") int idRevision,
        @RequestParam("idEvaluador") int idEvaluador,
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("conceptoRevision") String concepto,
        @RequestParam("observaciones") String observaciones,
        @RequestParam("filePP_B") MultipartFile filePP_B,
        @RequestParam("fileAnteproyectoRevisado") MultipartFile fileAnteproyectoRevisado
    ){
        RevisionEvaluadorPP_BDTOPeticion peticion = new RevisionEvaluadorPP_BDTOPeticion();
        peticion.setIdRevisionEvaluadorPPB(idRevision);
        peticion.setIdentificacionEvaluador(idEvaluador);
        peticion.setIdAnteproyecto(idAnteproyecto);
        peticion.setConceptoRevision(concepto);
        peticion.setObservaciones(observaciones);
        return this.anteproyectoCU.realizarRevisionAnteproyecto(peticion,filePP_B,fileAnteproyectoRevisado);
    }

    @GetMapping("/anteproyectos")
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectos(){
        return this.anteproyectoCU.listarAnteproyectos();
    }

    @GetMapping("/anteproyectosEvaluador/{idEvaluador}")
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosEvaluador(@PathVariable int idEvaluador){
        return this.anteproyectoCU.listarAnteproyectosEvaluadores(idEvaluador);
    }

    @GetMapping("/anteproyectosDirector")
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosDirector(@RequestParam("idDirector") int idDirector){
        return this.anteproyectoCU.listarAnteproyectosDirector(idDirector);
    }

    @GetMapping("/anteproyectos/{idAnteproyecto}")
    public AnteproyectoPP_BDTORespuesta consultarAnteproyecto(@PathVariable String idAnteproyecto){
        return this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
    }

    @GetMapping("/anteproyectosRevisiones")
    public List<RevisionEvaluadorPP_BDTORespuesta> listarRevisionesAnteproyectoEvaluador(
        @RequestParam("idEvaluador") int idEvaluador,
        @RequestParam("idAnteproyecto") String idAnteproyecto
    ){
        /*Para listarle al evaluador las revisiones que puede realizar respecto a un anteproyecto */
        return this.anteproyectoCU.listarRevisionesAnteproyectoParaEvaluador(idEvaluador, idAnteproyecto);
    }

    @GetMapping("/anteproyectosConcepto")
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosConcepto(
        @RequestParam("concepto") String concepto
    ){
        return this.anteproyectoCU.listarAnteproyectosConcepto(concepto);
    }

    @PatchMapping("/anteproyectosTI_C")
    public AnteproyectoPP_BDTORespuesta anexarTI_C(
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("file") MultipartFile file
    ){
        return this.anteproyectoCU.anexarFormatoTI_C(idAnteproyecto, file);
    }

    @PatchMapping("/anteproyectosNuevo")
    public AnteproyectoPP_BDTORespuesta agregarNuevaVersionAnteproyecto(
        @RequestParam("idAnteproyecto") String idAnteproyecto,
        @RequestParam("file") MultipartFile file
    ){
        return this.anteproyectoCU.agregarNuevaVersionAnteproyecto(idAnteproyecto, file);
    }

    @GetMapping("/anteproyectosSubidos/{idAnteproyecto}/{version}")
    public ResponseEntity<Resource> descargarAnteproyecto(@PathVariable String idAnteproyecto, @PathVariable int version) throws IOException {       
        if(this.anteproyectoCU.existeAnteproyecto(idAnteproyecto) && version > 0 && version <4){
            AnteproyectoPP_BDTORespuesta anteproyecto = this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
            String rutaCompleta;
            if(version == 1){
                rutaCompleta = anteproyecto.getRutaAnteproyectoPPBV1();
            }else if(version == 2){
                rutaCompleta = anteproyecto.getRutaAnteproyectoPPBV2();
            }else{
                rutaCompleta = anteproyecto.getRutaAnteproyectoPPBV3();
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

    @GetMapping("/anteproyectosPP_B/{idAnteproyecto}/{version}/{evaluador}")
    public ResponseEntity<Resource> descargarPP_B(@PathVariable String idAnteproyecto, @PathVariable int version,@PathVariable int evaluador) throws IOException {       
        /*Las versiones serian 3 y la recibicion de evaluador seria la del evaluador 1 o 2 */
        if(this.anteproyectoCU.existeAnteproyecto(idAnteproyecto) && version > 0 && version <4 && evaluador > 0 && evaluador < 3){
            AnteproyectoPP_BDTORespuesta anteproyecto = this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
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
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoTI_B.docx"); 

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

    @GetMapping("/anteproyectosTI_C/{idAnteproyecto}")
    public ResponseEntity<Resource> descargarTI_C(@PathVariable String idAnteproyecto) throws IOException {       
        if(this.anteproyectoCU.existeAnteproyecto(idAnteproyecto)){
            AnteproyectoPP_BDTORespuesta anteproyecto = this.anteproyectoCU.consultarAnteproyecto(idAnteproyecto);
            String rutaCompleta = "";
            rutaCompleta = anteproyecto.getRutaFormatoTI_C();
        
            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoTI_C.docx"); 

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

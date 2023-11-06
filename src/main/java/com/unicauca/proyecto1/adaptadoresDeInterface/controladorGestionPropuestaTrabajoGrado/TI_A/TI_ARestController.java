package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.TI_A;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A.GestionarTI_ACUInt;

@RestController
@RequestMapping("/apiPropuestasTI_A")
public class TI_ARestController {
    
    private final GestionarTI_ACUInt gestionarPropuestaTI_ACU;

    public TI_ARestController(GestionarTI_ACUInt gestionarPropuestaTI_ACU){
        this.gestionarPropuestaTI_ACU = gestionarPropuestaTI_ACU;
    }

    @GetMapping("/propuestas")
    public Iterable<PropuestaTrabajoGradoTI_ADTORespuesta> listar(){
        return this.gestionarPropuestaTI_ACU.listarPropuestas();
    }

    @GetMapping("/propuestasDirector")
    public Iterable<PropuestaTrabajoGradoTI_ADTORespuesta> listarDirector(@RequestParam(name = "idDirector",required = false) Integer idDirector){
        return this.gestionarPropuestaTI_ACU.listarPropuestasDirector(idDirector);
    }

    @GetMapping("/propuestas/{id}")
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(@PathVariable int id ){
       return this.gestionarPropuestaTI_ACU.consultarPropuesta(id);
    }

    @PostMapping("/propuestas")
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
    }
    
    @PostMapping("/propuestasRevisionComite")
    public RevisionComiteDTORespuesta realizarRevision(@RequestBody RevisionComiteDTOPeticion objPeticion){
        return this.gestionarPropuestaTI_ACU.realizarRevision(objPeticion);
    }

    @PutMapping("/propuestas")
    public PropuestaTrabajoGradoTI_ADTORespuesta anexarDocumentoAprobado(
        @RequestParam("file") MultipartFile file,
        @RequestParam("idPropuesta") Integer idPropuesta,
        @RequestParam("idComite") Integer idComite
    ){
        return this.gestionarPropuestaTI_ACU.anexarPropuestaAprobado(idComite,idPropuesta,file);
    }

    @GetMapping("/propuestasSubidas/{idPropuesta}")
    public ResponseEntity<Resource> descargarPropuesta(@PathVariable int idPropuesta) throws IOException {       
        if(this.gestionarPropuestaTI_ACU.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoTI_ADTORespuesta propuesta =  this.gestionarPropuestaTI_ACU.consultarPropuesta(idPropuesta);
            String rutaCompleta = propuesta.getRutaPropuestaTrabajoGrado(); 

            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoTI-A_Subido.docx"); 

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

    @GetMapping("/propuestasAprobadas/{idPropuesta}")
    public ResponseEntity<Resource> descargarPropuestaAprobada(@PathVariable int idPropuesta) throws IOException {       
        if(this.gestionarPropuestaTI_ACU.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoTI_ADTORespuesta propuesta =  this.gestionarPropuestaTI_ACU.consultarPropuesta(idPropuesta);
            String rutaCompleta = propuesta.getRutaRespuestaPropuestaTrabajoGrado(); 

            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoTI-A_Aprobado.docx"); 

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

package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.PP_A;

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

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A.GestionarPP_ACUInt;

@RestController
@RequestMapping("/api/PropuestasPP_A")
public class PP_ARestController {
    private final GestionarPP_ACUInt gestionarPropuestaPP_ACU;

    public PP_ARestController(GestionarPP_ACUInt gestionarPropuestaPP_ACU){
        this.gestionarPropuestaPP_ACU = gestionarPropuestaPP_ACU;
    }

    @GetMapping("/propuestas")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listar(){
        return this.gestionarPropuestaPP_ACU.listarPropuestas();
    }

    @GetMapping("/propuestas/estado/{estado}")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listar(@PathVariable int estado){
        return this.gestionarPropuestaPP_ACU.listarPropuestasPorEstado(estado);
    }

    @GetMapping("/propuestasDirector")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listarDirector(@RequestParam(name = "idDirector",required = false) Integer idDirector){
        return this.gestionarPropuestaPP_ACU.listarPropuestasDirector(idDirector);
    }

    @GetMapping("/propuestasDirector/estado/{estado}")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listarDirectorYestado(
        @RequestParam(name = "idDirector",required = false) Integer idDirector,
        @PathVariable int estado
    ){
        return this.gestionarPropuestaPP_ACU.listarPropuestasDirectorPorEstado(idDirector, estado);
    }

    @GetMapping("/propuestas/{id}")
    public PropuestaTrabajoGradoPP_ADTORespuesta consultarPropuesta(@PathVariable int id ){
       return this.gestionarPropuestaPP_ACU.consultarPropuesta(id);
    }

    @PostMapping("/propuestas")
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuestas(
        @RequestParam("file") MultipartFile file,
        @RequestParam("titulo") String titulo,
        @RequestParam("idDirector") Integer idDirector,
        @RequestParam(name = "idEstudiante") Integer idEstudiante,
        @RequestParam(name = "idAsesor", required = false) Integer idAsesor,
        @RequestParam(name = "idCodirector", required = false) Integer idCodirector
    ){
        PropuestaTrabajoGradoPP_ADTOPeticion objPeticion = new PropuestaTrabajoGradoPP_ADTOPeticion();
        objPeticion.setTituloPropuestaTrabajoGrado(titulo);
        objPeticion.setIdentificacionDirectorPPA(idDirector);
        objPeticion.setIdentificacionEstudiantePPA(idEstudiante);
        objPeticion.setIdentificacionAsesorPPA(idAsesor);
        if(idCodirector == null){
            objPeticion.setIdentificacionCodirectorPPA(-1);
        }else{
            objPeticion.setIdentificacionCodirectorPPA(idCodirector);
        }
        return this.gestionarPropuestaPP_ACU.crearPropuesta(objPeticion,file);
    }

    @PostMapping("/propuestasRevisionComite")
    public RevisionComiteDTORespuesta realizarRevision(@RequestBody RevisionComiteDTOPeticion objPeticion){
        return this.gestionarPropuestaPP_ACU.realizarRevision(objPeticion);
    }

    @PutMapping("/propuestas")
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarDocumentoAprobado(
        @RequestParam("file") MultipartFile file,
        @RequestParam("idPropuesta") Integer idPropuesta,
        @RequestParam("idComite") Integer idComite
    ){
        return this.gestionarPropuestaPP_ACU.anexarPropuestaAprobado(idComite,idPropuesta,file);
    }

    @GetMapping("/propuestasSubidas/{idPropuesta}")
    public ResponseEntity<Resource> descargarPropuesta(@PathVariable int idPropuesta) throws IOException {       
        if(this.gestionarPropuestaPP_ACU.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoPP_ADTORespuesta propuesta =  this.gestionarPropuestaPP_ACU.consultarPropuesta(idPropuesta);
            String rutaCompleta = propuesta.getRutaPropuestaTrabajoGrado() ; 

            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoPP-A_Subido.docx"); 

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
        if(this.gestionarPropuestaPP_ACU.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoPP_ADTORespuesta propuesta =  this.gestionarPropuestaPP_ACU.consultarPropuesta(idPropuesta);
            String rutaCompleta = propuesta.getRutaRespuestaPropuestaTrabajoGrado(); 

            Path path = Paths.get(rutaCompleta);
            Resource resource = new UrlResource(path.toUri());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoPP-A_Aprobado.docx"); 

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

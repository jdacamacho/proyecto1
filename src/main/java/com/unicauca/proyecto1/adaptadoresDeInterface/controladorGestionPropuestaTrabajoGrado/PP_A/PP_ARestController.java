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

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A.GestionarPP_ACUInt;

@RestController
@RequestMapping("/apiPropuestasPP_A")
public class PP_ARestController {
    private final GestionarPP_ACUInt gestionarPropuestaPP_ACU;

    public PP_ARestController(GestionarPP_ACUInt gestionarPropuestaPP_ACU){
        this.gestionarPropuestaPP_ACU = gestionarPropuestaPP_ACU;
    }

    @GetMapping("/propuestas")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listar(){
        return this.gestionarPropuestaPP_ACU.listarPropuestas();
    }

    @GetMapping("/propuestasDirector")
    public Iterable<PropuestaTrabajoGradoPP_ADTORespuesta> listarDirector(@RequestParam(name = "idDirector",required = false) Integer idDirector){
        return this.gestionarPropuestaPP_ACU.listarPropuestasDirector(idDirector);
    }

    @GetMapping("/propuestas/{id}")
    public PropuestaTrabajoGradoPP_ADTORespuesta consultarPropuesta(@PathVariable int id ){
       return this.gestionarPropuestaPP_ACU.consultarPropuesta(id);
    }

    @PostMapping("/propuestas")
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuestas(@RequestBody PropuestaTrabajoGradoPP_ADTOPeticion objPeticion){
        return this.gestionarPropuestaPP_ACU.crearPropuesta(objPeticion);
    }

    @PostMapping("/propuestasRevisionComite")
    public RevisionComiteDTORespuesta realizarRevision(@RequestBody RevisionComiteDTOPeticion objPeticion){
        return this.gestionarPropuestaPP_ACU.realizarRevision(objPeticion);
    }

    @PutMapping("/propuestas")
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarDocumentoAprobado(@RequestBody RutaAprobadaADTOPeticion objPeticion){
        return this.gestionarPropuestaPP_ACU.anexarPropuestaAprobado(objPeticion);
    }

    @GetMapping("/propuestasSubidas/{idPropuesta}")
    public ResponseEntity<Resource> descargarPropuesta(@PathVariable int idPropuesta) throws IOException {       
        if(this.gestionarPropuestaPP_ACU.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoPP_ADTORespuesta propuesta =  this.gestionarPropuestaPP_ACU.consultarPropuesta(idPropuesta);
            String rutaCompleta = propuesta.getRutaRespuestaPropuestaTrabajoGrado(); 

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

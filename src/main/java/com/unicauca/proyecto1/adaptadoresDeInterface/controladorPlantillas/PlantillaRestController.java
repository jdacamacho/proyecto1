package com.unicauca.proyecto1.adaptadoresDeInterface.controladorPlantillas;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/apiPlantilla")
public class PlantillaRestController {

    @GetMapping("/plantillasTI_A")
    public ResponseEntity<Resource> descargarPlantillaTI_A() throws IOException {

        String rutaCompleta = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/plantillas/formatoTI-A.docx"; 

        Path path = Paths.get(rutaCompleta);
        Resource resource = new UrlResource(path.toUri());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoTI-A.docx"); 

        MediaType mediaType = MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(resource.contentLength())
            .contentType(mediaType)
            .body(resource);
    }

    @GetMapping("/plantillasPP_A")
    public ResponseEntity<Resource> descargarPlantillaPP_A() throws IOException {

        String rutaCompleta = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/plantillas/formatoPP_A.docx"; 

        Path path = Paths.get(rutaCompleta);
        Resource resource = new UrlResource(path.toUri());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formatoPP_A.docx"); 

        MediaType mediaType = MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(resource.contentLength())
            .contentType(mediaType)
            .body(resource);
    }
}

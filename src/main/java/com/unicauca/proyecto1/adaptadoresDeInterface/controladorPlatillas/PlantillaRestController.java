package com.unicauca.proyecto1.adaptadoresDeInterface.controladorPlatillas;

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

    @GetMapping("/plantillasTI-A")
    public ResponseEntity<Resource> descargarPlantilla() throws IOException {

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


    /* 
    public static boolean fileExists() {
        String filePath = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/plantillas/formatoTI-A.docx";
        Path path = Paths.get(filePath);
        System.out.println(path.getFileName().toString());
        return Files.exists(path) && !Files.isDirectory(path);
    }*/
}

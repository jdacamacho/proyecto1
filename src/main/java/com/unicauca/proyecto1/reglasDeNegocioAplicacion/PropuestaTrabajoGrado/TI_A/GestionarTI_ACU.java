package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.AdaptadoresAPI.ExternalPropuestaDTO;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.GestionarRevisionComiteGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.RevisionComiteFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarTI_ACU implements GestionarTI_ACUInt{

    private final PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway;
    private final factoryTI_AInt objFactoryPropuesta;
    private final GestionarUsuarioGatewayInt objUsuarioGateway;
    private final GestionarRevisionComiteGatewayInt objRevisionComiteGateway;
    private final factoryRevisionComiteInt objFactoryRevsionComite;
    private final RevisionComiteFormateadorResultadosInt objFormateadorResultadosRevision;

    public GestionarTI_ACU(PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway,
                        factoryTI_AInt objFactoryTI_A,
                        GestionarUsuarioGatewayInt objUsuarioGateway,
                        GestionarRevisionComiteGatewayInt objRevisionComiteGateway,
                        factoryRevisionComiteInt objFactoryRevisionComite,
                        RevisionComiteFormateadorResultadosInt objFormateadorResultadosRevision ){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
        this.objRevisionComiteGateway = objRevisionComiteGateway;
        this.objFactoryRevsionComite = objFactoryRevisionComite;
        this.objFormateadorResultadosRevision = objFormateadorResultadosRevision;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(ExternalPropuestaDTO objPeticion, MultipartFile file){
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(objPeticion);
        System.out.println(file);

        PropuestaTrabajoGradoTI_ADTOPeticion propuesta = objPeticion.adaptPropuestaEntries();
        /**
         * Se valida el usuario, si no existe se usuario es null
         * de lo contrario se guarda la informcacion del usuario
         */
        Usuario director = this.validarUsuario(propuesta.getIdentificacionDirectorTIA());
        Usuario estudiante1 = this.validarUsuario(propuesta.getIdentificacionEstudiante1TIA());

        // La existencia de estos campos no es relevante para las validaciones
        Usuario estudiante2 = this.validarUsuario(propuesta.getIdentificacionEstudiante2TIA());
        Usuario codirector = this.validarUsuario(propuesta.getIdentificacionCodirectorTIA());

        /*
         * Si no existe el director o el estudiante, se retorna un mensaje de error
        */
        if(director == null || estudiante1 == null) return this.objFormateadorResultados.prepararRespuestaFallida("Error en director o usuario");

        /**
         * Cargamos el archivo en el servidor
         */
        String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();    
        String rutaDestino = "";   
        try{
            rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
        }  catch(IOException exception){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error al cargar el archivo");
        } 
        
        /**
         * Procedemos a crear la propuesta
        */
        PropuestaTrabajoGradoTI_A objPropuetaCreada = this.objFactoryPropuesta.crearTI_A(
            director, 
            estudiante1, 
            codirector, 
            estudiante2, 
            propuesta.getTituloPropuestaTrabajoGrado(),
            new Date(), 
            rutaDestino
        );

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(objPropuetaCreada);
        this.objPropuestaGateway.guardar(objPropuetaCreada);    

        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuetaCreada);
    }

    //#region METODOS DE VALIDACCION DE USUARIO
    private Usuario validarUsuario(Integer identificacionUsuario){
        try{
            if(this.objUsuarioGateway.existeUsuario(identificacionUsuario)){
                return this.objUsuarioGateway.consultarUsuario(identificacionUsuario);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
    //#endregion

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoTI_A objPropuesta = this.objPropuestaGateway.consultarPropuesta(idPropuesta);
            return this.objFormateadorResultados
                        .prepararRespuestaSatisfactoriaConsultarPropuesta(objPropuesta); 
        }else{
            return this.objFormateadorResultados
            .prepararRespuestaFallida("Error, no se encontro la propuesta TI_A buscada");
        }
    }

    @Override
    public RevisionComiteDTORespuesta realizarRevision(RevisionComiteDTOPeticion objPeticion) {
        if(this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionComitePrograma()) == false && this.objPropuestaGateway.existePropuesta(objPeticion.getIdPropuestaTrabajoGrado()) == false){
            return this.objFormateadorResultadosRevision.prepararRespuestaFallida("no existe el usuario o la propuesta");
        }else{
            Usuario comitePrograma = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionComitePrograma());
            PropuestaTrabajoGradoTI_A propuesta = this.objPropuestaGateway.consultarPropuesta(objPeticion.getIdPropuestaTrabajoGrado());
            RevisionComite revisionCreada = this.objFactoryRevsionComite.crearRevisionComite(comitePrograma, objPeticion.getComentariosRevisionComite(), objPeticion.getEstadoAvalRevisionComite(), new Date());
            propuesta.getRevisiones().add(revisionCreada);
            this.objPropuestaGateway.modificar(objPeticion.getIdPropuestaTrabajoGrado(), propuesta);
            return this.objFormateadorResultadosRevision.prepararRespuestaSatisfactoriaCrearRevision(revisionCreada);
        }
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta anexarPropuestaAprobado(RutaAprobadaADTOPeticion rutaAprobado) {
        if(this.objPropuestaGateway.existePropuesta(rutaAprobado.getIdPropuestaTrabajoGrado())){
            if(fileExists(rutaAprobado.getRutaRespuesta())){
                PropuestaTrabajoGradoTI_A propuesta = this.objPropuestaGateway.consultarPropuesta(rutaAprobado.getIdPropuestaTrabajoGrado());
                String rutaDestino = cargarArchivoAprobado(rutaAprobado.getRutaRespuesta(),propuesta.getIdentificacionEstudiante1TIA().getLoginUsuario().getUserNameLogin());
                propuesta.setRutaRespuestaPropuestaTrabajoGrado(rutaDestino);
                this.objPropuestaGateway.modificar(rutaAprobado.getIdPropuestaTrabajoGrado(), propuesta);
                return this.objFormateadorResultados.prepararRespuestaSatisfactoriaModificarPropuesta(propuesta);
            }else{
                return this.objFormateadorResultados.
                prepararRespuestaFallida("no existe el archivo");
            }
        }else{
            return this.objFormateadorResultados.
                prepararRespuestaFallida("no existe la propuesta buscada");
        }
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestasDirector(int idDirector) {
        if(this.objUsuarioGateway.existeUsuario(idDirector)){
            Usuario director = this.objUsuarioGateway.consultarUsuario(idDirector);
            List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listarPorDirector(director);
            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
        }
        return null;
    }

    private boolean fileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path);
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException{
        String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Recibidos/" + fileName + ".docx";
        File file = new File(fileDirectory);
        System.out.println(fileDirectory);
        System.out.println(file);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            int bytesRead;
            byte[] buffer = new byte[4096];

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        return file.getAbsolutePath();
    }

    @Override
    public boolean existePropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta)){
            return true;
        }
        return false;
    }

    private String cargarArchivoAprobado(String filePath, String nombreEstudiantes) {
        try {
            Path sourcePath = Paths.get(filePath);
            String baseFileName = nombreEstudiantes + "aprobado";
            int counter = 1;
            Path destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Aprobados", baseFileName + ".docx");
    
            while (Files.exists(destinoPath)) {
                baseFileName = nombreEstudiantes + "(" + counter + ")";
                destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Aprobados", baseFileName + ".docx");
                counter++;
            }
    
            Files.copy(sourcePath, destinoPath);
            return destinoPath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

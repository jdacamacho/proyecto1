package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.TI_A.GestionarRevisionComiteGatewayTI_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.TI_A.RevisionComiteFormateadorResultadosTI_AInt;
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
    private final factoryRevisionComiteInt objFactoryRevsionComite;
    private final RevisionComiteFormateadorResultadosTI_AInt objFormateadorResultadosRevision;

    public GestionarTI_ACU(PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway,
                        factoryTI_AInt objFactoryTI_A,
                        GestionarUsuarioGatewayInt objUsuarioGateway,
                        factoryRevisionComiteInt objFactoryRevisionComite,
                        RevisionComiteFormateadorResultadosTI_AInt objFormateadorResultadosRevision ){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
        this.objFactoryRevsionComite = objFactoryRevisionComite;
        this.objFormateadorResultadosRevision = objFormateadorResultadosRevision;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoTI_ADTOPeticion objPeticion,MultipartFile file) {
        /**
         * Se valida el usuario, si no existe se usuario es null
         * de lo contrario se guarda la informcacion del usuario
         */
        Usuario director = this.validarUsuario(objPeticion.getIdentificacionDirectorTIA());
        Usuario estudiante1 = this.validarUsuario(objPeticion.getIdentificacionEstudiante1TIA());

        // La existencia de estos campos no es relevante para las validaciones
        Usuario estudiante2 = this.validarUsuario(objPeticion.getIdentificacionEstudiante2TIA());
        Usuario codirector = this.validarUsuario(objPeticion.getIdentificacionCodirectorTIA());

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

        this.objPropuestaGateway.guardar(objPropuetaCreada);    

        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuetaCreada);
    }

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

    @Override
    public boolean existePropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta)){
            return true;
        }
        return false;
    }

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


    private boolean fileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path);
    }

    private String cargarArchivoRecibidos(String filePath, String nombreEstudiantes) {
        try {
            Path sourcePath = Paths.get(filePath);
            String baseFileName = nombreEstudiantes;
            int counter = 1;
            Path destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Recibidos", baseFileName + ".docx");
    
            while (Files.exists(destinoPath)) {
                baseFileName = nombreEstudiantes + "(" + counter + ")";
                destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Recibidos", baseFileName + ".docx");
                counter++;
            }
    
            Files.copy(sourcePath, destinoPath);
            return destinoPath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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

package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RutaAprobadaADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.GestionarPropuestaTrabajoGradoPP_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.PropuestaTrabajoGradoPP_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.PP_A.RevisionComiteFormateadorResultadosPP_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A.factoryPP_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarPP_ACU implements GestionarPP_ACUInt {

    private final PropuestaTrabajoGradoPP_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoPP_AGatewayInt objPropuestaGateway;
    private final factoryPP_AInt objFactoryPropuesta;
    private final GestionarUsuarioGatewayInt objUsuarioGateway;
    private final factoryRevisionComiteInt objFactoryRevsionComite;
    private final RevisionComiteFormateadorResultadosPP_AInt objFormateadorResultadosRevision;

    public GestionarPP_ACU(PropuestaTrabajoGradoPP_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoPP_AGatewayInt objPropuestaGateway,
                        factoryPP_AInt objFactoryTI_A,
                        GestionarUsuarioGatewayInt objUsuarioGateway,
                        factoryRevisionComiteInt objFactoryRevisionComite,
                        RevisionComiteFormateadorResultadosPP_AInt objFormateadorResultadosRevision ){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
        this.objFactoryRevsionComite = objFactoryRevisionComite;
        this.objFormateadorResultadosRevision = objFormateadorResultadosRevision;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoPP_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoPP_ADTOPeticion objPeticion) {
        if(this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionDirectorPPA()) == false &&  this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionEstudiantePPA()) == false && this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionAsesorPPA()) == false){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error en director o usuario o asesor");
        }
        else{
            Usuario estudiante1 = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiantePPA());
            Usuario director = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionDirectorPPA());
            Usuario asesor = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionAsesorPPA());
            if(this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionCodirectorPPA()) == true){
                if(fileExists(objPeticion.getRutaPropuestaTrabajoGradoOrigen())){
                    PropuestaTrabajoGradoPP_A objPropuetaCreada = this.objFactoryPropuesta
                    .crearPP_A(director, estudiante1, this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionCodirectorPPA()), asesor,
                    objPeticion.getTituloPropuestaTrabajoGrado(),new Date(), objPeticion.getRutaPropuestaTrabajoGradoOrigen());
                    String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();
                    String rutaDestino = cargarArchivoRecibidos(objPeticion.getRutaPropuestaTrabajoGradoOrigen(), nombreArchivo);
                    objPropuetaCreada.setRutaPropuestaTrabajoGrado(rutaDestino);
                    this.objPropuestaGateway.guardar(objPropuetaCreada);
                    return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuetaCreada);
                }else{
                    return this.objFormateadorResultados.prepararRespuestaFallida("No existe la ruta");
                } 
            }
            else{
                if(fileExists(objPeticion.getRutaPropuestaTrabajoGradoOrigen())){
                    PropuestaTrabajoGradoPP_A objPropuetaCreada = this.objFactoryPropuesta
                    .crearPP_A(director, estudiante1,null,asesor,
                    objPeticion.getTituloPropuestaTrabajoGrado(),new Date(), objPeticion.getRutaPropuestaTrabajoGradoOrigen());
                    String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();
                    String rutaDestino = cargarArchivoRecibidos(objPeticion.getRutaPropuestaTrabajoGradoOrigen(), nombreArchivo);
                    objPropuetaCreada.setRutaPropuestaTrabajoGrado(rutaDestino);
                    this.objPropuestaGateway.guardar(objPropuetaCreada);
                    return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuetaCreada);
                }else{
                    return this.objFormateadorResultados.prepararRespuestaFallida("No existe la ruta");
                } 
            }
        }
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta consultarPropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta)){
            PropuestaTrabajoGradoPP_A objPropuesta = this.objPropuestaGateway.consultarPropuesta(idPropuesta);
            return this.objFormateadorResultados
                        .prepararRespuestaSatisfactoriaConsultarPropuesta(objPropuesta); 
        }else{
            return this.objFormateadorResultados
            .prepararRespuestaFallida("Error, no se encontro la propuesta PP_A buscada");
        }
    }

    @Override
    public RevisionComiteDTORespuesta realizarRevision(RevisionComiteDTOPeticion objPeticion) {
        if(this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionComitePrograma()) == false && this.objPropuestaGateway.existePropuesta(objPeticion.getIdPropuestaTrabajoGrado()) == false){
            return this.objFormateadorResultadosRevision.prepararRespuestaFallida("no existe el usuario,el asesor o la propuesta");
        }else{
            Usuario comitePrograma = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionComitePrograma());
            PropuestaTrabajoGradoPP_A propuesta = this.objPropuestaGateway.consultarPropuesta(objPeticion.getIdPropuestaTrabajoGrado());
            RevisionComite revisionCreada = this.objFactoryRevsionComite.crearRevisionComite(comitePrograma, objPeticion.getComentariosRevisionComite(), objPeticion.getEstadoAvalRevisionComite(), new Date());
            propuesta.getRevisiones().add(revisionCreada);
            this.objPropuestaGateway.modificar(objPeticion.getIdPropuestaTrabajoGrado(), propuesta);
            return this.objFormateadorResultadosRevision.prepararRespuestaSatisfactoriaCrearRevision(revisionCreada);
        }
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarPropuestaAprobado(RutaAprobadaADTOPeticion rutaAprobado) {
        if(this.objPropuestaGateway.existePropuesta(rutaAprobado.getIdPropuestaTrabajoGrado())){
            if(fileExists(rutaAprobado.getRutaRespuesta())){
                PropuestaTrabajoGradoPP_A propuesta = this.objPropuestaGateway.consultarPropuesta(rutaAprobado.getIdPropuestaTrabajoGrado());
                String rutaDestino = cargarArchivoAprobado(rutaAprobado.getRutaRespuesta(),propuesta.getIdentificacionEstudiantePPA().getLoginUsuario().getUserNameLogin());
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
    public boolean existePropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta)){
            return true;
        }
        return false;
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestasDirector(int idDirector) {
        if(this.objUsuarioGateway.existeUsuario(idDirector)){
            Usuario director = this.objUsuarioGateway.consultarUsuario(idDirector);
            List<PropuestaTrabajoGradoPP_A> listaObtenida = objPropuestaGateway.listarPorDirector(director);
            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
        }
        return null;
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
            Path destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Recibidos", baseFileName + ".docx");
    
            while (Files.exists(destinoPath)) {
                baseFileName = nombreEstudiantes + "(" + counter + ")";
                destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Recibidos", baseFileName + ".docx");
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
            Path destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Aprobados", baseFileName + ".docx");
    
            while (Files.exists(destinoPath)) {
                baseFileName = nombreEstudiantes + "(" + counter + ")";
                destinoPath = Paths.get("src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Aprobados", baseFileName + ".docx");
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

package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.TI_A.RevisionComiteFormateadorResultadosTI_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarTI_ACU implements GestionarTI_ACUInt{

    private final PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway;
    private final factoryTI_AInt objFactoryPropuesta;
    private final GestionarUsuarioGatewayInt objUsuarioGateway;
    private final factoryRevisionComiteInt objFactoryRevsionComite;
    private final RevisionComiteFormateadorResultadosTI_AInt objFormateadorResultadosRevision;
    private final GestionarNotificacionGatewayInt objNotificacionGateway;
    private final factoryNotificacionInt objFactoryNotificacion;

    public GestionarTI_ACU(PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway,
                        factoryTI_AInt objFactoryTI_A,
                        GestionarUsuarioGatewayInt objUsuarioGateway,
                        factoryRevisionComiteInt objFactoryRevisionComite,
                        RevisionComiteFormateadorResultadosTI_AInt objFormateadorResultadosRevision,
                        GestionarNotificacionGatewayInt objNotificacionGateway,
                        factoryNotificacionInt objFactoryNotificacion){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
        this.objFactoryRevsionComite = objFactoryRevisionComite;
        this.objFormateadorResultadosRevision = objFormateadorResultadosRevision;
        this.objNotificacionGateway = objNotificacionGateway;
        this.objFactoryNotificacion = objFactoryNotificacion;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoTI_ADTOPeticion objPeticion,MultipartFile file) {
        boolean banderaDirector = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionDirectorTIA());
        boolean banderaEstudiante1 = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionEstudiante1TIA());
        boolean banderaEstudiante2 = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionEstudiante2TIA());
        boolean banderaCodirector = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionCodirectorTIA());
        Usuario director = null;
        Usuario estudiante1 = null;
        Usuario estudiante2 = null;
        Usuario codirector = null;

        if(banderaDirector == false || banderaEstudiante1 == false){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error en director o usuario");
        }else{
            estudiante1 = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiante1TIA());
            director = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionDirectorTIA());
            if(objPeticion.getIdentificacionEstudiante2TIA() != -1 && banderaEstudiante2 == false){
                this.objFormateadorResultados.prepararRespuestaFallida("Estudiante 2 no valido");
            }else if(objPeticion.getIdentificacionCodirectorTIA() != -1 && banderaCodirector == false){
                this.objFormateadorResultados.prepararRespuestaFallida("Codirector no valido");
            }else{
                if(banderaCodirector == true && banderaEstudiante2 == false){
                    if(objPeticion.getIdentificacionEstudiante2TIA() == -1){
                        codirector = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionCodirectorTIA());
                    }else{
                        this.objFormateadorResultados.prepararRespuestaFallida("Estudiante 2 no valido");
                    }
                }else if(banderaCodirector == false && banderaEstudiante2 == true){
                    if(objPeticion.getIdentificacionCodirectorTIA() == -1){
                        estudiante2 = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiante2TIA());
                    }else{
                        this.objFormateadorResultados.prepararRespuestaFallida("Codirector no valido");
                    }
                
                }else if(banderaCodirector == true && banderaEstudiante2 == true){
                    codirector = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionCodirectorTIA());
                    estudiante2 = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiante2TIA());
                }
            }
            String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();    
            String rutaDestino = "";   
            try{
                rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
            }  catch(IOException exception){
                return this.objFormateadorResultados.prepararRespuestaFallida("Error al cargar el archivo");
            } 

            PropuestaTrabajoGradoTI_A objPropuestaCreada = this.objFactoryPropuesta.crearTI_A(director, estudiante1, codirector, estudiante2, objPeticion.getTituloPropuestaTrabajoGrado(),new Date(), rutaDestino);

            PropuestaTrabajoGradoTI_A propuestaR = this.objPropuestaGateway.guardar(objPropuestaCreada);
            String mensajeEvidencia = "Usted realizo la entrega de una propuesta de trabajo de grado en modalida de investigacion. con id: "
            + propuestaR.getIdPropuestaTrabajoGradoTIA() + " y titulo: " + propuestaR.getTituloPropuestaTrabajoGrado(); 
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(director,director , mensajeEvidencia, new Date());
            this.objNotificacionGateway.guardar(notificacion);
            this.observadorNotificacionComite(propuestaR);
            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuestaCreada);
        }
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
            String mensaje = "Se ha realizado una revision de la propuesta de trabajo de grado en modalidad de investigacion con id: " + propuesta.getIdPropuestaTrabajoGradoTIA() + " y titulo: " + propuesta.getTituloPropuestaTrabajoGrado();
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(comitePrograma,propuesta.getIdentificacionDirectorTIA(),mensaje,new Date());
            this.objNotificacionGateway.guardar(notificacion);
            return this.objFormateadorResultadosRevision.prepararRespuestaSatisfactoriaCrearRevision(revisionCreada);
        }
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta anexarPropuestaAprobado(int idComiteRevisa,int idPropuesta,MultipartFile file) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta) && this.objUsuarioGateway.existeUsuario(idComiteRevisa)){
            PropuestaTrabajoGradoTI_A propuesta = this.objPropuestaGateway.consultarPropuesta(idPropuesta);
            Usuario comite = this.objUsuarioGateway.consultarUsuario(idComiteRevisa);
            String nombreArchivo = propuesta.getIdentificacionEstudiante1TIA().getLoginUsuario().getUserNameLogin() + "Aprobado";    
            String rutaDestino = "";   
            try{
                rutaDestino = cargarArchivoAprobado(file, nombreArchivo);
            }  catch(IOException exception){
                return this.objFormateadorResultados.prepararRespuestaFallida("Error al cargar el archivo");
            }
            propuesta.setRutaRespuestaPropuestaTrabajoGrado(rutaDestino);
            this.objPropuestaGateway.modificar(idPropuesta, propuesta); 
            String mensaje = "Se ha aprobado su propuesta de trabajo de grado en modalidad de investigacion con id: " + propuesta.getIdPropuestaTrabajoGradoTIA() +
            " y titulo: " + propuesta.getTituloPropuestaTrabajoGrado() + ", ya puede consultar su formato aprobado";
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(comite,propuesta.getIdentificacionDirectorTIA(), mensaje, new Date());
            this.objNotificacionGateway.guardar(notificacion);
            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaModificarPropuesta(propuesta);
        }else{
            return this.objFormateadorResultados.prepararRespuestaFallida("No existe la propuesta solicitada o el evaluador del comite no existe");
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

    @Override
    public void observadorNotificacionComite(PropuestaTrabajoGradoTI_A propuestaRegistrada) {
        Rol comite = new Rol(3,"Comite del programa");
        List<Usuario> usuariosConRolComite = this.objUsuarioGateway.buscarUsuariosPorRol(comite);
        String mensaje = "Se ha registrado una nueva propuesta de trabajo de grado en modalidad de investigacion." + 
        " id propuesta: " + propuestaRegistrada.getIdPropuestaTrabajoGradoTIA() + " titulo: " + propuestaRegistrada.getTituloPropuestaTrabajoGrado();
        for(int i = 0 ; i<usuariosConRolComite.size(); i++){
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(propuestaRegistrada.getIdentificacionDirectorTIA(),usuariosConRolComite.get(i), mensaje, new Date());
            this.objNotificacionGateway.guardar(notificacion);
        }
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Recibidos/" + fileName + ".docx";
        File file = new File(fileDirectory);
    
        int count = 1;
        String baseFileName = fileName;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Recibidos/" + fileName + ".docx";
            file = new File(fileDirectory);
            count++;
        }
    
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


    private String cargarArchivoAprobado(MultipartFile multipartFile, String fileName) throws IOException {
       String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Aprobados/" + fileName + ".docx";
        File file = new File(fileDirectory);
    
        int count = 1;
        String baseFileName = fileName;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_A/Aprobados/" + fileName + ".docx";
            file = new File(fileDirectory);
            count++;
        }
    
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
}

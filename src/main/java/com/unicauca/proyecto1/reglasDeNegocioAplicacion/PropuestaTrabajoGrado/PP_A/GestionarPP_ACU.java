package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoPP_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoPP_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.GestionarPropuestaTrabajoGradoPP_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.PropuestaTrabajoGradoPP_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.PP_A.RevisionComiteFormateadorResultadosPP_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A.factoryPP_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.revisionComite.RevisionComite;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarPP_ACU implements GestionarPP_ACUInt {

    private final PropuestaTrabajoGradoPP_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoPP_AGatewayInt objPropuestaGateway;
    private final factoryPP_AInt objFactoryPropuesta;
    private final GestionarUsuarioGatewayInt objUsuarioGateway;
    private final factoryRevisionComiteInt objFactoryRevsionComite;
    private final RevisionComiteFormateadorResultadosPP_AInt objFormateadorResultadosRevision;
    private final GestionarNotificacionGatewayInt objNotificacionGateway;
    private final factoryNotificacionInt objFactoryNotificacion;
    Dictionary<String, Integer> dict= new Hashtable<>();

    public GestionarPP_ACU(
        PropuestaTrabajoGradoPP_AFormateadorResultadosInt objFormateadorResultados,
        GestionarPropuestaTrabajoGradoPP_AGatewayInt objPropuestaGateway,
        factoryPP_AInt objFactoryTI_A,
        GestionarUsuarioGatewayInt objUsuarioGateway,
        factoryRevisionComiteInt objFactoryRevisionComite,
        RevisionComiteFormateadorResultadosPP_AInt objFormateadorResultadosRevision,
        GestionarNotificacionGatewayInt objNotificacionGateway,
        factoryNotificacionInt objFactoryNotificacion
    ){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
        this.objFactoryRevsionComite = objFactoryRevisionComite;
        this.objFormateadorResultadosRevision = objFormateadorResultadosRevision;
        this.objNotificacionGateway = objNotificacionGateway;
        this.objFactoryNotificacion = objFactoryNotificacion;

        this.dict.put("REVISION", 0);
        this.dict.put("APROBADO", 1);
        this.dict.put("RECHAZADO", -1);
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoPP_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestasPorEstado(int estado) {
        List<PropuestaTrabajoGradoPP_A> listaObtenida = objPropuestaGateway.listarPropuestasPorEstado(estado);
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public List<PropuestaTrabajoGradoPP_ADTORespuesta> listarPropuestasDirectorPorEstado(int idDirector, int estado) {
        if(this.objUsuarioGateway.existeUsuario(idDirector)){
            Usuario director = this.objUsuarioGateway.consultarUsuario(idDirector);
            List<PropuestaTrabajoGradoPP_A> listaObtenida = objPropuestaGateway.listarPorDirectorYestado(director, estado);
            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
        }
        return null;
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoPP_ADTOPeticion objPeticion,MultipartFile file) {
        boolean banderaDirector = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionDirectorPPA());
        boolean banderaEstudiante = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionEstudiantePPA() );
        boolean banderaAsesor = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionAsesorPPA());
        boolean banderaCodirector = this.objUsuarioGateway.existeUsuario(objPeticion.getIdentificacionCodirectorPPA());
        Usuario director = null;
        Usuario estudiante = null;
        Usuario asesor = null;
        Usuario codirector = null;

        if(banderaDirector == false || banderaEstudiante == false || banderaAsesor == false){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error en director,estudiante o asesor");
        }else{
            director = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionDirectorPPA());
            estudiante = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiantePPA());
            asesor = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionAsesorPPA());
            
            if(banderaCodirector == true){
                codirector = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionCodirectorPPA());
            }

            String nombreArchivo = estudiante.getLoginUsuario().getUserNameLogin();    
            String rutaDestino = "";   
            try{
                rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
            }  catch(IOException exception){
                return this.objFormateadorResultados.prepararRespuestaFallida("Error al cargar el archivo");
            } 

            PropuestaTrabajoGradoPP_A objPropuestaCreada = this.objFactoryPropuesta.crearPP_A(
                director, 
                estudiante,
                codirector, 
                asesor, 
                objPeticion.getTituloPropuestaTrabajoGrado(), 
                new Date(), 
                rutaDestino,
                dict.get("REVISION")
            );
            PropuestaTrabajoGradoPP_A propuestaR = this.objPropuestaGateway.guardar(objPropuestaCreada);
            String mensajeEvidencia = "Usted realizo la entrega de una propuesta de trabajo de grado en modalidad de practica profesional. con id: "
            + propuestaR.getIdPropuestaTrabajoGradoPPA() + " y titulo: " + propuestaR.getTituloPropuestaTrabajoGrado(); 
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(director,director , mensajeEvidencia, new Date());
            this.objNotificacionGateway.guardar(notificacion);
            this.observadorNotificacionComite(propuestaR);

            return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuestaCreada);
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
            String mensaje = "Se ha realizado una revision de la propuesta de trabajo de grado en modalidad de practica profesional con id: " + propuesta.getIdPropuestaTrabajoGradoPPA() + " y titulo: " + propuesta.getTituloPropuestaTrabajoGrado();
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(comitePrograma,propuesta.getIdentificacionDirectorPPA(),mensaje,new Date());
            this.objNotificacionGateway.guardar(notificacion);
            return this.objFormateadorResultadosRevision.prepararRespuestaSatisfactoriaCrearRevision(revisionCreada);
        }
    }

    @Override
    public PropuestaTrabajoGradoPP_ADTORespuesta anexarPropuestaAprobado(int idComiteRevisa,int idPropuesta,MultipartFile file) {
        if(this.objPropuestaGateway.existePropuesta(idPropuesta) && this.objUsuarioGateway.existeUsuario(idComiteRevisa)){
        PropuestaTrabajoGradoPP_A propuesta = this.objPropuestaGateway.consultarPropuesta(idPropuesta);
        Usuario comite = this.objUsuarioGateway.consultarUsuario(idComiteRevisa);
        String nombreArchivo = propuesta.getIdentificacionEstudiantePPA().getLoginUsuario().getUserNameLogin() + "Aprobado";    
        String rutaDestino = "";   
        try{
            rutaDestino = cargarArchivoAprobado(file, nombreArchivo);
        }  catch(IOException exception){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error al cargar el archivo");
        }
        propuesta.setRutaRespuestaPropuestaTrabajoGrado(rutaDestino);
        this.objPropuestaGateway.modificar(idPropuesta, propuesta); 
        String mensaje = "Se ha aprobado su propuesta de trabajo de grado en modalidad de practica profesional con id: " + propuesta.getIdPropuestaTrabajoGradoPPA() +
        " y titulo: " + propuesta.getTituloPropuestaTrabajoGrado() + ", ya puede consultar su formato aprobado";
        Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(comite,propuesta.getIdentificacionDirectorPPA(), mensaje, new Date());
        this.objNotificacionGateway.guardar(notificacion);
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaModificarPropuesta(propuesta);
    }else{
        return this.objFormateadorResultados.prepararRespuestaFallida("No existe la propuesta solicitada o el miembro del comite");
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

    @Override
    public void observadorNotificacionComite(PropuestaTrabajoGradoPP_A propuestaRegistrada) {
        Rol comite = new Rol(3,"Comite del programa");
        List<Usuario> usuariosConRolComite = this.objUsuarioGateway.buscarUsuariosPorRol(comite);
        String mensaje = "Se ha registrado una nueva propuesta de trabajo de grado en modalidad de practica profesional." + 
        " id propuesta: " + propuestaRegistrada.getIdPropuestaTrabajoGradoPPA() + " titulo: " + propuestaRegistrada.getTituloPropuestaTrabajoGrado();
        for(int i = 0 ; i<usuariosConRolComite.size(); i++){
            Notificacion notificacion = this.objFactoryNotificacion.crearNotificacion(propuestaRegistrada.getIdentificacionDirectorPPA(),usuariosConRolComite.get(i), mensaje, new Date());
            this.objNotificacionGateway.guardar(notificacion);
        }
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Recibidos/" + fileName + ".docx";
        File file = new File(fileDirectory);
    
        int count = 1;
        String baseFileName = fileName;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Recibidos/" + fileName + ".docx";
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
       String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Aprobados/" + fileName + ".docx";
        File file = new File(fileDirectory);
    
        int count = 1;
        String baseFileName = fileName;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_A/Aprobados/" + fileName + ".docx";
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

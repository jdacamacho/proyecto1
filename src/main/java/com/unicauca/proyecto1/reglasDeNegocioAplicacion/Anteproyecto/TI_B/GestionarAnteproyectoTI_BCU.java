package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.AnteproyectoTI_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayAnteproyectoTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryAnteproyectoTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarAnteproyectoTI_BCU implements GestionarAnteproyectoTI_BCUInt{

    private final GestionarUsuarioGatewayInt gatewayUsuario;
    private final GestionarPropuestaTrabajoGradoTI_AGatewayInt gatewayPropuesta;
    private final GestionarGatewayAnteproyectoTI_BInt gatewayAnteproyecto;
    private final GestionarGatewayRevisionTI_BInt gatewayRevisionAnteproyecto;
    private final GestionarGatewayRevisionEvaluadorTI_BInt gatewayRevisionEvaluador;
    private final AnteproyectoTI_BFormateadorResultadosInt formateadorAnteproyecto;
    private final FactoryAnteproyectoTI_BInt factoryAnteproyecto;
    private final FactoryRevisionEvaluadorTI_BInt factoryRevisionEvaluador;
    private final FactoryRevisionTI_BInt factoryRevisionAnteproyecto;
    private final GestionarNotificacionGatewayInt gatewayNotificacion;
    private final factoryNotificacionInt factoryNotificacion;

    public GestionarAnteproyectoTI_BCU(GestionarUsuarioGatewayInt gatewayUsuario,
                                    GestionarPropuestaTrabajoGradoTI_AGatewayInt  gatewayPropuesta,
                                    GestionarGatewayAnteproyectoTI_BInt gatewayAnteproyecto,
                                    GestionarGatewayRevisionTI_BInt revisionEvaluador,
                                    GestionarGatewayRevisionEvaluadorTI_BInt revisionAnteproyecto,
                                    AnteproyectoTI_BFormateadorResultadosInt formateadorAnteproyecto,
                                    FactoryAnteproyectoTI_BInt factoryAnteproyecto,
                                    FactoryRevisionEvaluadorTI_BInt factoryRevisionEvaluador,
                                    FactoryRevisionTI_BInt factoryRevisionAnteproyecto,
                                    GestionarNotificacionGatewayInt gatewayNotificacion,
                                    factoryNotificacionInt factoryNotificacion){
        
        this.gatewayUsuario = gatewayUsuario;
        this.gatewayPropuesta = gatewayPropuesta;
        this.gatewayAnteproyecto = gatewayAnteproyecto;
        this.gatewayRevisionAnteproyecto = revisionEvaluador;
        this.gatewayRevisionEvaluador = revisionAnteproyecto;
        this.formateadorAnteproyecto = formateadorAnteproyecto;
        this.factoryAnteproyecto = factoryAnteproyecto;
        this.factoryRevisionEvaluador = factoryRevisionEvaluador;
        this.factoryRevisionAnteproyecto = factoryRevisionAnteproyecto;
        this.gatewayNotificacion = gatewayNotificacion;
        this.factoryNotificacion = factoryNotificacion;

    }

    @Override
    public AnteproyectoTI_BDTORespuesta crearAnteproyecto(AnteproyectoTI_BDTOPeticion peticion,MultipartFile file) {
        boolean banderaPropuesta = this.gatewayPropuesta.existePropuesta(peticion.getIdPropuestaTIA());
        boolean banderaDirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionDirectorTIB());
        boolean banderaEstudiante1 = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEstudiante1TIB());
        boolean banderaEstudiante2 = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEstudiante2TIB());
        boolean banderaCodirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionCodirector());
        Usuario director = null;
        Usuario estudiante1 = null;
        Usuario estudiante2 = null;
        Usuario codirector = null;
        if(banderaPropuesta == false || banderaDirector == false || banderaEstudiante1 == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("Error, no existe la propuesta,docente o estudiante 1");
        }else{
            LocalDate fecha = LocalDate.now();
            int año = fecha.getYear();
            if(this.gatewayPropuesta.consultarPropuesta(peticion.getIdPropuestaTIA()).getRutaRespuestaPropuestaTrabajoGrado() == null){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("La propuesta debe ser previamente aprobada");
            }else{
                director = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionDirectorTIB());
                estudiante1 = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiante1TIB());
                if(banderaEstudiante2 == true && banderaCodirector == false){
                    if(peticion.getIdentificacionCodirector() == -1){
                        estudiante2 = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiante2TIB());                
                    }else{
                        return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el codirector");
                    }
                }else if(banderaEstudiante2 == false && banderaCodirector == true){
                    if(peticion.getIdentificacionEstudiante2TIB() == -1){
                        codirector = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionCodirector());
                    }else{
                        return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el estudiante 2");
                    }
                }else if(banderaEstudiante2 == true && banderaCodirector == true){
                    estudiante2 = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiante2TIB()); 
                    codirector = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionCodirector());
                }
                
                String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();    
                String rutaDestino = "";   
                try{
                    rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
                }  catch(IOException exception){
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                } 
                PropuestaTrabajoGradoTI_A propuestaAsociada = this.gatewayPropuesta.consultarPropuesta(peticion.getIdPropuestaTIA());
                String idAnteproyecto = año + "." + peticion.getIdAnteProyectoTIB();
                AnteproyectoTI_B anteproyectoCreado = this.factoryAnteproyecto.crearAnteproyecto(idAnteproyecto, propuestaAsociada, director, estudiante1, estudiante2, codirector, peticion.getTituloAnteproyecto(), rutaDestino);
                String mensaje = "Usted ha realizado el envio de un anteproyecto en modalidad de investigacion con Id:" + anteproyectoCreado.getIdAnteProyectoTIB() + 
                " de la propuesta de trabajo de grado con id: " + anteproyectoCreado.getIdPropuestaTIA().getIdPropuestaTrabajoGradoTIA();
                Notificacion notificacion = this.factoryNotificacion.crearNotificacion(director, director, mensaje, new Date());
                this.gatewayAnteproyecto.guardar(anteproyectoCreado);
                this.gatewayNotificacion.guardar(notificacion);
                observerNotificacionJefatura(anteproyectoCreado);
                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyectoCreado);
            }
        }
    }

    @Override
    public AnteproyectoTI_BDTORespuesta asignarEvaluador(int idEvaluador1, int idEvaluador2, int idAnteproyecto) {
        boolean banderaEvaluador1 = this.gatewayUsuario.existeUsuario(idEvaluador1);
        boolean banderaEvaluador2 = this.gatewayUsuario.existeUsuario(idEvaluador2);
        boolean banderaAnteproyecto = this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto);
        if(banderaEvaluador1 == false && banderaEvaluador2 == false && banderaAnteproyecto == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("error es evaluadores o anteproyecto");
        }else{
            AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            if(anteproyecto.controlMaximoDeVersiones()){
                Usuario evaluador1 = this.gatewayUsuario.consultarUsuario(idEvaluador1);
                Usuario evaluador2 = this.gatewayUsuario.consultarUsuario(idEvaluador2);
                RevisionEvaluadorTI_B revisionEvaluador1 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador1, null, "A revision", null, null);
                RevisionEvaluadorTI_B revisionEvaluador2 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador2, null, "A revision", null, null);
                RevisionEvaluadorTI_B revisionEvaluador1creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador1);
                RevisionEvaluadorTI_B revisionEvaluador2creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador2);
                RevisionTI_B revisionAnteproyecto = this.factoryRevisionAnteproyecto.crearRevisionAnteproyecto(0, revisionEvaluador1creada, revisionEvaluador2creada);
                RevisionTI_B revisionAlmacenada = this.gatewayRevisionAnteproyecto.guardar(revisionAnteproyecto);
                anteproyecto.getRevisiones().add(revisionAlmacenada);
                this.gatewayAnteproyecto.guardar(anteproyecto);
                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyecto);
            }else{
                return this.formateadorAnteproyecto.prepararRespuestaFallida("Error, se alcanzo el maximo numero permitido de revisionees");
            }
           
        }
    }

    @Override
    public void observerNotificacionJefatura(AnteproyectoTI_B anteproyectoRegistrado) {
        Rol JefeDepartamento = new Rol(4,"Jefe de departamento");
        Rol AsistenteJefeDepartamento = new Rol(5,"Asistente del jefe de departamento");
        List<Usuario> usuariosConRolJefeDepartamento = this.gatewayUsuario.buscarUsuariosPorRol(JefeDepartamento);
        List<Usuario> usuariosConRolAsistenteJefeDepartamento = this.gatewayUsuario.buscarUsuariosPorRol(AsistenteJefeDepartamento);
        String mensaje = "Se ha registrado un nuevo anteproyecto en modalidad de investigacion." + 
        " id Anteproyecto: " + anteproyectoRegistrado.getIdAnteProyectoTIB() + " titulo: " + anteproyectoRegistrado.getTituloAnteproyecto() + " para la propuesta de trabajo de grado : " + anteproyectoRegistrado.getIdPropuestaTIA() ;
        for(int i = 0 ; i<usuariosConRolJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorTIB(),usuariosConRolJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
        for(int i = 0 ; i<usuariosConRolAsistenteJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorTIB(),usuariosConRolAsistenteJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
    }



    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_B/Recibidos/" + fileName + ".docx";
        File file = new File(fileDirectory);
    
        int count = 1;
        String baseFileName = fileName;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_B/Recibidos/" + fileName + ".docx";
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

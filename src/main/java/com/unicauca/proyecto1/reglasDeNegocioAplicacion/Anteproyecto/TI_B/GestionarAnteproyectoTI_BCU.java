package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.RevisionEvaluadorTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.RevisionEvaluadorTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.AnteproyectoTI_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayAnteproyectoTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.RevisionEvaluadorTI_BFormateadorResultadosInt;
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
    private final RevisionEvaluadorTI_BFormateadorResultadosInt formateadorRevisionEvaluador;

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
                                    factoryNotificacionInt factoryNotificacion,
                                    RevisionEvaluadorTI_BFormateadorResultadosInt formateadorRevisionEvaluador){
        
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
        this.formateadorRevisionEvaluador = formateadorRevisionEvaluador;

    }

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
                
                String nombreArchivo = "Anteproyecto_Version_1" + estudiante1.getLoginUsuario().getUserNameLogin();    
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
                AnteproyectoTI_B anteproyectoGuardado = this.gatewayAnteproyecto.guardar(anteproyectoCreado);
                this.gatewayNotificacion.guardar(notificacion);
                observerNotificacionJefatura(anteproyectoGuardado);
                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyectoCreado);
            }
        }
    }

    @Override
    public AnteproyectoTI_BDTORespuesta asignarEvaluador(int idJefeDepartamento,int idEvaluador1, int idEvaluador2, String idAnteproyecto) {
        boolean banderaEvaluador1 = this.gatewayUsuario.existeUsuario(idEvaluador1);
        boolean banderaEvaluador2 = this.gatewayUsuario.existeUsuario(idEvaluador2);
        long banderaAnteproyecto = this.gatewayAnteproyecto.contarAnteproyectos(idAnteproyecto);
        if(banderaEvaluador1 == false && banderaEvaluador2 == false && banderaAnteproyecto == 0){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("error es evaluadores o anteproyecto");
        }else{
            AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            if(anteproyecto.controlMaximoDeVersiones()){
                Usuario jefeDepartamento = this.gatewayUsuario.consultarUsuario(idJefeDepartamento);
                Usuario evaluador1 = this.gatewayUsuario.consultarUsuario(idEvaluador1);
                Usuario evaluador2 = this.gatewayUsuario.consultarUsuario(idEvaluador2);
                RevisionEvaluadorTI_B revisionEvaluador1 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador1, null, "En revision", null, null);
                RevisionEvaluadorTI_B revisionEvaluador2 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador2, null, "En revision", null, null);
                RevisionEvaluadorTI_B revisionEvaluador1creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador1);
                RevisionEvaluadorTI_B revisionEvaluador2creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador2);
                RevisionTI_B revisionAnteproyecto = this.factoryRevisionAnteproyecto.crearRevisionAnteproyecto(0, revisionEvaluador1creada, revisionEvaluador2creada);
                RevisionTI_B revisionAlmacenada = this.gatewayRevisionAnteproyecto.guardar(revisionAnteproyecto);
                anteproyecto.getRevisiones().add(revisionAlmacenada);
                this.gatewayAnteproyecto.guardar(anteproyecto);
                String mensaje1 = "Se ha asignado un anteproyecto para revisar con id de anteproyecto:" + idAnteproyecto + ", titulo :" +  
                anteproyecto.getTituloAnteproyecto() + " con id revision:" + revisionEvaluador1creada.getIdRevisionEvaluadorTIB();
                Notificacion notificacion1 = this.factoryNotificacion.crearNotificacion(jefeDepartamento, evaluador1, mensaje1, new Date());
                String mensaje2 = "Se ha asignado un anteproyecto para revisar con id de anteproyecto:" + idAnteproyecto + ", titulo :" +  
                anteproyecto.getTituloAnteproyecto() + " con id revision:" + revisionEvaluador2creada.getIdRevisionEvaluadorTIB();
                Notificacion notificacion2 = this.factoryNotificacion.crearNotificacion(jefeDepartamento, evaluador2, mensaje2, new Date());
                this.gatewayNotificacion.guardar(notificacion1);
                this.gatewayNotificacion.guardar(notificacion2);
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
        " id Anteproyecto: " + anteproyectoRegistrado.getIdAnteProyectoTIB() + " titulo: " + anteproyectoRegistrado.getTituloAnteproyecto() + " para la propuesta de trabajo de grado : " + anteproyectoRegistrado.getIdPropuestaTIA().getIdPropuestaTrabajoGradoTIA() ;
        for(int i = 0 ; i<usuariosConRolJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorTIB(),usuariosConRolJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
        for(int i = 0 ; i<usuariosConRolAsistenteJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorTIB(),usuariosConRolAsistenteJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
    }

    
    @Override
    public AnteproyectoTI_BDTORespuesta consultarAnteproyecto(String idAnteproyecto) {
        if(this.gatewayAnteproyecto.contarAnteproyectos(idAnteproyecto) > 0){
            AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaConsultarAnteproyecto(anteproyecto);
        }else{
            return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el anteproyecto consultado");
        }
    }

    @Override
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectos() {
        List<AnteproyectoTI_B>  lista = this.gatewayAnteproyecto.listarAnteproyectos();
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(lista);
    }

    @Override
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosDirector(int idDirector) {
        boolean banderaDirector = this.gatewayUsuario.existeUsuario(idDirector);
        if(banderaDirector){
            Usuario director  = this.gatewayUsuario.consultarUsuario(idDirector);
            List<AnteproyectoTI_B>  lista = this.gatewayAnteproyecto.listarAnteproyectosDirector(director);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(lista);
        }
        return null;
    }

    @Override
    public AnteproyectoTI_BDTORespuesta realizarRevisionAnteproyecto(RevisionEvaluadorTI_BDTOPeticion peticion,MultipartFile file) {
        boolean banderaAnteproyecto = this.gatewayAnteproyecto.existeAnteproyecto(peticion.getIdAnteproyecto());
        boolean banderaEvaluador = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEvaluador());
        if(banderaAnteproyecto == false || banderaEvaluador == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("error en anteproyecto o evaluador");
        }else{
            List<RevisionEvaluadorTI_B> revisionesEvaluador = getRevisiones(peticion.getIdentificacionEvaluador(), peticion.getIdAnteproyecto());
            RevisionEvaluadorTI_B revisionEvaluador = getRevision(revisionesEvaluador, peticion.getIdRevisionEvaluadorTIB());
            if(revisionEvaluador == null){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe la revision buscada");
            }else{
                RevisionEvaluadorTI_B revisionObtenida = this.gatewayRevisionEvaluador.consultarRevisionEvaluador(peticion.getIdRevisionEvaluadorTIB());
                String nombreArchivo = "Anteproyecto_"+ peticion.getIdAnteproyecto() +"_evaluador_" + revisionObtenida.getIdentificacionEvaluador().getLoginUsuario().getUserNameLogin();    
                String rutaDestino = "";  
                try{
                    if(peticion.getConceptoRevision().equals("Aprobado")){
                        rutaDestino = cargarArchivoAprobadosTI_B(file, nombreArchivo);
                    }else{
                        rutaDestino = cargarArchivoRecibidosTI_B(file, nombreArchivo);
                    }
                }  catch(IOException exception){
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                } 
                revisionObtenida.setConceptoRevision(peticion.getConceptoRevision());
                revisionObtenida.setObservaciones(peticion.getObservaciones());
                revisionObtenida.setFechaConcepto(new Date());
                revisionObtenida.setRutaRespuesta(rutaDestino);
                this.gatewayRevisionEvaluador.guardar(revisionObtenida);
                AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(peticion.getIdAnteproyecto());
                String mensajeDirector = "Se ha realizado una revision al anteproyecto con id: " + anteproyecto.getIdAnteProyectoTIB() + " con titulo: " + anteproyecto.getTituloAnteproyecto();
                String mensajeEvaluador = "usted ha realizado una revision al anteproyecto con id: " + anteproyecto.getIdAnteProyectoTIB() + " con titulo: " + anteproyecto.getTituloAnteproyecto();
                Notificacion notificacionDirector = this.factoryNotificacion.crearNotificacion(revisionEvaluador.getIdentificacionEvaluador(), anteproyecto.getIdentificacionDirectorTIB(), mensajeDirector, new Date());
                Notificacion notificacionEvaluador = this.factoryNotificacion.crearNotificacion(revisionEvaluador.getIdentificacionEvaluador(), revisionEvaluador.getIdentificacionEvaluador(), mensajeEvaluador, new Date());
                this.gatewayNotificacion.guardar(notificacionDirector);
                this.gatewayNotificacion.guardar(notificacionEvaluador);
                checkAnteproyectoEstado(anteproyecto);

                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyecto);
            }
        }
    }

    @Override
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosEvaluadores(int idEvaluador) {
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(anteproyectosPorEvaluador(idEvaluador));
    }

    @Override
    public List<RevisionEvaluadorTI_BDTORespuesta> listarRevisionesAnteproyectoParaEvaluador(int idEvaluador,
            String idAnteproyecto) {
        return this.formateadorRevisionEvaluador.prepararRespuestaSatisfactoriaListar(getRevisiones(idEvaluador, idAnteproyecto));
    }

    @Override
    public List<AnteproyectoTI_BDTORespuesta> listarAnteproyectosConcepto(String concepto) {
        /*Conceptos validos : Aprobado,Rechazado,En revision */
        List<AnteproyectoTI_B> listaPorConcepto = new ArrayList<>();
        List<AnteproyectoTI_B> anteproyectos = this.gatewayAnteproyecto.listarAnteproyectos();
        for(AnteproyectoTI_B anteproyectoTI_B : anteproyectos) {
            if(anteproyectoTI_B.getRevisiones() != null){
                List<RevisionTI_B> revisiones = anteproyectoTI_B.getRevisiones();
                for (RevisionTI_B revisionTI_B : revisiones) {
                    if(revisionTI_B.getIdentificacionEvaluador1().getConceptoRevision().equals(concepto) || revisionTI_B.getIdentificacionEvaluador2().getConceptoRevision().equals(concepto)){
                        if(revisionTI_B.getIdentificacionEvaluador1().getConceptoRevision().equals(concepto) == false){
                            revisionTI_B.setIdentificacionEvaluador1(null);
                        }
                        if(revisionTI_B.getIdentificacionEvaluador2().getConceptoRevision().equals(concepto) == false){
                            revisionTI_B.setIdentificacionEvaluador2(null);
                        }
                        listaPorConcepto.add(anteproyectoTI_B);
                    }
                }
            }
        }
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(listaPorConcepto);
    }

    @Override
    public AnteproyectoTI_BDTORespuesta anexarFormatoTI_C(String idAnteproyecto, MultipartFile file) {
        boolean banderaAnteproyecto = this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto);
        if(banderaAnteproyecto){
            AnteproyectoTI_B anteproyectoAprobado = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            String nombreArchivo = "Anteproyecto_" + anteproyectoAprobado.getIdAnteProyectoTIB() + "_TI_C";
            String rutaDestino = "";  
            try{
                rutaDestino = cargarArchivoTI_C(file, nombreArchivo);
            }  catch(IOException exception){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
            } 
            anteproyectoAprobado.setRutaFormatoTI_C(rutaDestino);
            this.gatewayAnteproyecto.guardar(anteproyectoAprobado);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaModificarAnteproyecto(anteproyectoAprobado);
        }
        return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el anteproyecto consultado...");
    }

    @Override
    public AnteproyectoTI_BDTORespuesta modificarArchivoAnteproyecto(String idAnteproyecto, MultipartFile file) {
        if(this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto)){
            AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            int nuevoIndice = anteproyecto.getNVersion() + 1;
            String nombreArchivo = "Anteproyecto_Version_"+ nuevoIndice +"_"+ anteproyecto.getIdentificacionEstudiante1TIB().getLoginUsuario().getUserNameLogin();
            String rutaDestino = "";  
            try{
                rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
            }  catch(IOException exception){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
            } 
            anteproyecto.setRutaAnteproyectoTIB(rutaDestino);
            anteproyecto.setNVersion(nuevoIndice);
            this.gatewayAnteproyecto.guardar(anteproyecto);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaModificarAnteproyecto(anteproyecto);
        }
        return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el anteproyecto");
    }

    public List<RevisionEvaluadorTI_B> getRevisiones(int idEvaluador,String idAnteproyecto){
        List<RevisionEvaluadorTI_B> revisiones = new ArrayList<>();
        AnteproyectoTI_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
        List<RevisionTI_B>  revisionesEvaluador = anteproyecto.getRevisiones();
        for(int i = 0 ; i < revisionesEvaluador.size() ; i++){
            if(revisionesEvaluador.get(i).getIdentificacionEvaluador1().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                revisiones.add(revisionesEvaluador.get(i).getIdentificacionEvaluador1());
            }
            if(revisionesEvaluador.get(i).getIdentificacionEvaluador2().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                revisiones.add(revisionesEvaluador.get(i).getIdentificacionEvaluador2());
            }
        }
        return revisiones;
    }

    public RevisionEvaluadorTI_B getRevision(List<RevisionEvaluadorTI_B> revisionesEvaluador,int idRevision){
        for(int i = 0 ; i < revisionesEvaluador.size() ; i++){
            if(revisionesEvaluador.get(i).getIdRevisionEvaluadorTIB() == idRevision){
                return revisionesEvaluador.get(i);
            }
        }
        return null;
    }

    public List<AnteproyectoTI_B> anteproyectosPorEvaluador(int idEvaluador){
        List<AnteproyectoTI_B> lista = this.gatewayAnteproyecto.listarAnteproyectos();
        List<AnteproyectoTI_B> listaR = new ArrayList<>();
        for(int i = 0 ; i < lista.size() ; i++){
            List<RevisionTI_B> revisionAnteproyecto = lista.get(i).getRevisiones();
            if(revisionAnteproyecto.size() != 0){
                 for(int j = 0 ; j < revisionAnteproyecto.size() ; j++){
                    if(revisionAnteproyecto.get(j).getIdentificacionEvaluador1().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                        lista.get(i).getRevisiones().get(j).setIdentificacionEvaluador2(null);
                        listaR.add(lista.get(i));
                    }
                    else if(revisionAnteproyecto.get(j).getIdentificacionEvaluador2().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                        lista.get(i).getRevisiones().get(j).setIdentificacionEvaluador1(null);
                        listaR.add(lista.get(i));
                    }
                }
            }
        }
        return listaR;
    }

    public void checkAnteproyectoEstado(AnteproyectoTI_B anteproyectoTI_B){
        RevisionTI_B revision = anteproyectoTI_B.getRevisiones().get(anteproyectoTI_B.getRevisiones().size() - 1);
        if(revision.getIdentificacionEvaluador1().getConceptoRevision().equals("Aprobado") && revision.getIdentificacionEvaluador2().getConceptoRevision().equals("Aprobado")){
            anteproyectoTI_B.setEstado("Aprobado");
            this.gatewayAnteproyecto.guardar(anteproyectoTI_B);
        }
        if(revision.getIdentificacionEvaluador1().getConceptoRevision().equals("Rechazado") && revision.getIdentificacionEvaluador2().getConceptoRevision().equals("Rechazado")){
            anteproyectoTI_B.setEstado("Rechazado");
            this.gatewayAnteproyecto.guardar(anteproyectoTI_B);
        }
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/Anteproyectos/Investigacion/";
        String fileExtension = ".docx";
        
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        String baseFileName = fileName;  
        String fullFilePath = baseDirectory + fileName + fileExtension;
        File file = new File(fullFilePath);
    
        int count = 1;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fullFilePath = baseDirectory + fileName + fileExtension;
            file = new File(fullFilePath);
            count++;
        }
    
        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
    
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error al cargar el archivo", e);
        }
    
        return file.getAbsolutePath();
    }

    public String cargarArchivoRecibidosTI_B(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_B/Recibidos/";
        String fileExtension = ".docx";
        
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        String baseFileName = fileName;  
        String fullFilePath = baseDirectory + fileName + fileExtension;
        File file = new File(fullFilePath);
    
        int count = 1;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fullFilePath = baseDirectory + fileName + fileExtension;
            file = new File(fullFilePath);
            count++;
        }
    
        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
    
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error al cargar el archivo", e);
        }
    
        return file.getAbsolutePath();
    }

    public String cargarArchivoAprobadosTI_B(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_B/Aprobados/";
        String fileExtension = ".docx";
        
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        String baseFileName = fileName;  
        String fullFilePath = baseDirectory + fileName + fileExtension;
        File file = new File(fullFilePath);
    
        int count = 1;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fullFilePath = baseDirectory + fileName + fileExtension;
            file = new File(fullFilePath);
            count++;
        }
    
        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
    
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error al cargar el archivo", e);
        }
    
        return file.getAbsolutePath();
    }

    public String cargarArchivoTI_C(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_C/";
        String fileExtension = ".docx";
        
        File directory = new File(baseDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        String baseFileName = fileName;  
        String fullFilePath = baseDirectory + fileName + fileExtension;
        File file = new File(fullFilePath);
    
        int count = 1;
        while (file.exists()) {
            fileName = baseFileName + "(" + count + ")";
            fullFilePath = baseDirectory + fileName + fileExtension;
            file = new File(fullFilePath);
            count++;
        }
    
        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
    
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new IOException("Error al cargar el archivo", e);
        }
    
        return file.getAbsolutePath();
    }

}

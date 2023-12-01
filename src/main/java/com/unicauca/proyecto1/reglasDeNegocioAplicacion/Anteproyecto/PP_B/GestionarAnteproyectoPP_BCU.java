package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.PP_B;

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

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.AnteproyectoPP_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.PP_B.RevisionEvaluadorPP_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.AnteproyectoPP_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.PP_B.RevisionEvaluadorPP_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.GestionarPropuestaTrabajoGradoPP_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.AnteproyectoPP_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayAnteproyectoPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayRevisionEvaluadorPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayRevisionPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.RevisionEvaluadorPP_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.AnteproyectoPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionEvaluadorPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.PP_B.RevisionPP_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PP_A.PropuestaTrabajoGradoPP_A;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryAnteproyectoPP_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionEvaluadorPP_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionPP_BInt;

import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.notificacion.Notificacion;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.rol.Rol;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarAnteproyectoPP_BCU implements GestionarAnteproyectoPP_BCUInt{

    private final GestionarUsuarioGatewayInt gatewayUsuario;
    private final GestionarPropuestaTrabajoGradoPP_AGatewayInt gatewayPropuesta;
    private final GestionarGatewayAnteproyectoPP_BInt gatewayAnteproyecto;
    private final GestionarGatewayRevisionPP_BInt gatewayRevisionAnteproyecto;
    private final GestionarGatewayRevisionEvaluadorPP_BInt gatewayRevisionEvaluador;
    private final AnteproyectoPP_BFormateadorResultadosInt formateadorAnteproyecto;
    private final FactoryAnteproyectoPP_BInt factoryAnteproyecto;
    private final FactoryRevisionEvaluadorPP_BInt factoryRevisionEvaluador;
    private final FactoryRevisionPP_BInt factoryRevisionAnteproyecto;
    private final GestionarNotificacionGatewayInt gatewayNotificacion;
    private final factoryNotificacionInt factoryNotificacion;
    private final RevisionEvaluadorPP_BFormateadorResultadosInt formateadorRevisionEvaluador;

    public GestionarAnteproyectoPP_BCU(GestionarUsuarioGatewayInt gatewayUsuario,
                                    GestionarPropuestaTrabajoGradoPP_AGatewayInt  gatewayPropuesta,
                                    GestionarGatewayAnteproyectoPP_BInt gatewayAnteproyecto,
                                    GestionarGatewayRevisionPP_BInt revisionEvaluador,
                                    GestionarGatewayRevisionEvaluadorPP_BInt revisionAnteproyecto,
                                    AnteproyectoPP_BFormateadorResultadosInt formateadorAnteproyecto,
                                    FactoryAnteproyectoPP_BInt factoryAnteproyecto,
                                    FactoryRevisionEvaluadorPP_BInt factoryRevisionEvaluador,
                                    FactoryRevisionPP_BInt factoryRevisionAnteproyecto,
                                    GestionarNotificacionGatewayInt gatewayNotificacion,
                                    factoryNotificacionInt factoryNotificacion,
                                    RevisionEvaluadorPP_BFormateadorResultadosInt formateadorRevisionEvaluador){
        
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

    public AnteproyectoPP_BDTORespuesta crearAnteproyecto(AnteproyectoPP_BDTOPeticion peticion,MultipartFile file) {
        boolean banderaPropuesta = this.gatewayPropuesta.existePropuesta(peticion.getIdPropuestaPPA());
        boolean banderaDirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionDirectorPPB());
        boolean banderaEstudiante = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEstudiantePPB());
        boolean banderaAsesor = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionAsesorPPB());
        boolean banderaCodirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionCodirector());
        Usuario director = null;
        Usuario estudiante = null;
        Usuario asesor = null;
        Usuario codirector = null;
        if(banderaPropuesta == false || banderaDirector == false || banderaEstudiante == false || banderaAsesor == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("Error, no existe la propuesta,docente,estudiante o asesor");
        }else{
            LocalDate fecha = LocalDate.now();
            int año = fecha.getYear();
            if(this.gatewayPropuesta.consultarPropuesta(peticion.getIdPropuestaPPA()).getRutaRespuestaPropuestaTrabajoGrado() == null){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("La propuesta debe ser previamente aprobada");
            }else{
                director = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionDirectorPPB());
                estudiante = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiantePPB());
                asesor = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionAsesorPPB());
                if(banderaCodirector == true){
                    codirector = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionCodirector());
                }
                String nombreArchivo = "Anteproyecto_Version_1" + estudiante.getLoginUsuario().getUserNameLogin();    
                String rutaDestino = "";   
                try{
                    rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
                }  catch(IOException exception){
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                } 
                PropuestaTrabajoGradoPP_A propuestaAsociada = this.gatewayPropuesta.consultarPropuesta(peticion.getIdPropuestaPPA());
                String idAnteproyecto = año + "." + peticion.getIdAnteProyectoPPB();
                AnteproyectoPP_B anteproyectoCreado = this.factoryAnteproyecto.crearAnteproyecto(idAnteproyecto, propuestaAsociada, director, estudiante, asesor, codirector, peticion.getTituloAnteproyecto(), rutaDestino);
                String mensaje = "Usted ha realizado el envio de un anteproyecto en modalidad de investigacion con Id:" + anteproyectoCreado.getIdAnteproyectoPPB() + 
                " de la propuesta de trabajo de grado con id: " + anteproyectoCreado.getIdPropuestaPPA().getIdPropuestaTrabajoGradoPPA();
                Notificacion notificacion = this.factoryNotificacion.crearNotificacion(director, director, mensaje, new Date());
                AnteproyectoPP_B anteproyectoGuardado = this.gatewayAnteproyecto.guardar(anteproyectoCreado);
                this.gatewayNotificacion.guardar(notificacion);
                observerNotificacionJefatura(anteproyectoGuardado);
                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyectoCreado);
            }
        }
    }

    @Override
    public AnteproyectoPP_BDTORespuesta asignarEvaluador(int idJefeDepartamento,int idEvaluador1, int idEvaluador2, String idAnteproyecto) {
        boolean banderaEvaluador1 = this.gatewayUsuario.existeUsuario(idEvaluador1);
        boolean banderaEvaluador2 = this.gatewayUsuario.existeUsuario(idEvaluador2);
        long banderaAnteproyecto = this.gatewayAnteproyecto.contarAnteproyectos(idAnteproyecto);
        if(banderaEvaluador1 == false && banderaEvaluador2 == false && banderaAnteproyecto == 0){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("error es evaluadores o anteproyecto");
        }else{
            AnteproyectoPP_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            if(anteproyecto.controlMaximoDeVersiones()){
                Usuario jefeDepartamento = this.gatewayUsuario.consultarUsuario(idJefeDepartamento);
                Usuario evaluador1 = this.gatewayUsuario.consultarUsuario(idEvaluador1);
                Usuario evaluador2 = this.gatewayUsuario.consultarUsuario(idEvaluador2);
                RevisionEvaluadorPP_B revisionEvaluador1 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador1, null, "En revision", null, null,null);
                RevisionEvaluadorPP_B revisionEvaluador2 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0, evaluador2, null, "En revision", null, null,null);
                RevisionEvaluadorPP_B revisionEvaluador1creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador1);
                RevisionEvaluadorPP_B revisionEvaluador2creada = this.gatewayRevisionEvaluador.guardar(revisionEvaluador2);
                RevisionPP_B revisionAnteproyecto = this.factoryRevisionAnteproyecto.crearRevisionAnteproyecto(0, revisionEvaluador1creada, revisionEvaluador2creada);
                RevisionPP_B revisionAlmacenada = this.gatewayRevisionAnteproyecto.guardar(revisionAnteproyecto);
                anteproyecto.getRevisiones().add(revisionAlmacenada);
                this.gatewayAnteproyecto.guardar(anteproyecto);
                String mensaje1 = "Se ha asignado un anteproyecto para revisar con id de anteproyecto:" + idAnteproyecto + ", titulo :" +  
                anteproyecto.getTituloAnteproyecto() + " con id revision:" + revisionEvaluador1creada.getIdRevisionEvaluadorPPB();
                Notificacion notificacion1 = this.factoryNotificacion.crearNotificacion(jefeDepartamento, evaluador1, mensaje1, new Date());
                String mensaje2 = "Se ha asignado un anteproyecto para revisar con id de anteproyecto:" + idAnteproyecto + ", titulo :" +  
                anteproyecto.getTituloAnteproyecto() + " con id revision:" + revisionEvaluador2creada.getIdRevisionEvaluadorPPB();
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
    public void observerNotificacionJefatura(AnteproyectoPP_B anteproyectoRegistrado) {
        Rol JefeDepartamento = new Rol(4,"Jefe de departamento");
        Rol AsistenteJefeDepartamento = new Rol(5,"Asistente del jefe de departamento");
        List<Usuario> usuariosConRolJefeDepartamento = this.gatewayUsuario.buscarUsuariosPorRol(JefeDepartamento);
        List<Usuario> usuariosConRolAsistenteJefeDepartamento = this.gatewayUsuario.buscarUsuariosPorRol(AsistenteJefeDepartamento);
        String mensaje = "Se ha registrado un nuevo anteproyecto en modalidad de practica profesional." + 
        " id Anteproyecto: " + anteproyectoRegistrado.getIdAnteproyectoPPB() + " titulo: " + anteproyectoRegistrado.getTituloAnteproyecto() + " para la propuesta de trabajo de grado : " + anteproyectoRegistrado.getIdPropuestaPPA().getIdPropuestaTrabajoGradoPPA() ;
        for(int i = 0 ; i<usuariosConRolJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorPPB(),usuariosConRolJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
        for(int i = 0 ; i<usuariosConRolAsistenteJefeDepartamento.size(); i++){
            Notificacion notificacion = this.factoryNotificacion.crearNotificacion(anteproyectoRegistrado.getIdentificacionDirectorPPB(),usuariosConRolAsistenteJefeDepartamento.get(i), mensaje, new Date());
            this.gatewayNotificacion.guardar(notificacion);
        }
    }

    
    @Override
    public AnteproyectoPP_BDTORespuesta consultarAnteproyecto(String idAnteproyecto) {
        if(this.gatewayAnteproyecto.contarAnteproyectos(idAnteproyecto) > 0){
            AnteproyectoPP_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaConsultarAnteproyecto(anteproyecto);
        }else{
            return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el anteproyecto consultado");
        }
    }

    @Override
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectos() {
        List<AnteproyectoPP_B>  lista = this.gatewayAnteproyecto.listarAnteproyectos();
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(lista);
    }

    @Override
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosDirector(int idDirector) {
        boolean banderaDirector = this.gatewayUsuario.existeUsuario(idDirector);
        if(banderaDirector){
            Usuario director  = this.gatewayUsuario.consultarUsuario(idDirector);
            List<AnteproyectoPP_B>  lista = this.gatewayAnteproyecto.listarAnteproyectosDirector(director);
            return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(lista);
        }
        return null;
    }

    @Override
    public AnteproyectoPP_BDTORespuesta realizarRevisionAnteproyecto(RevisionEvaluadorPP_BDTOPeticion peticion,MultipartFile fileTI_B,MultipartFile fileAnteproyectoCorreciones) {
        boolean banderaAnteproyecto = this.gatewayAnteproyecto.existeAnteproyecto(peticion.getIdAnteproyecto());
        boolean banderaEvaluador = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEvaluador());
        if(banderaAnteproyecto == false || banderaEvaluador == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("error en anteproyecto o evaluador");
        }else{
            List<RevisionEvaluadorPP_B> revisionesEvaluador = getRevisiones(peticion.getIdentificacionEvaluador(), peticion.getIdAnteproyecto());
            RevisionEvaluadorPP_B revisionEvaluador = getRevision(revisionesEvaluador, peticion.getIdRevisionEvaluadorPPB());
            if(revisionEvaluador == null){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe la revision buscada");
            }else{
                AnteproyectoPP_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(peticion.getIdAnteproyecto());
                RevisionEvaluadorPP_B revisionObtenida = this.gatewayRevisionEvaluador.consultarRevisionEvaluador(peticion.getIdRevisionEvaluadorPPB());
                String nombreArchivo = "Anteproyecto_Version"+ anteproyecto.getNVersion() +"_" + peticion.getIdAnteproyecto() +"_evaluador_" + revisionObtenida.getIdentificacionEvaluador().getLoginUsuario().getUserNameLogin();    
                String rutaDestino = "";  
                try{
                    if(peticion.getConceptoRevision().equals("Aprobado")){
                        rutaDestino = cargarArchivoAprobadosPP_B(fileTI_B, nombreArchivo);
                    }else{
                        rutaDestino = cargarArchivoRecibidosPP_B(fileTI_B, nombreArchivo);
                    }
                }  catch(IOException exception){
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                }
                String rutaDestinoRevisado = ""; 
                if(fileAnteproyectoCorreciones != null){
                    String nombreArchivoRevisado = "Anteproyecto_Version"+ anteproyecto.getNVersion() +"_" + peticion.getIdAnteproyecto() +"_evaluador_" + revisionObtenida.getIdentificacionEvaluador().getLoginUsuario().getUserNameLogin()+"_anotaciones";
                    try {
                        rutaDestinoRevisado = cargarArchivoEvaluadorCorreciones(fileAnteproyectoCorreciones,nombreArchivoRevisado);
                    } catch (Exception e) {
                        return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                    }
                }
                revisionObtenida.setConceptoRevision(peticion.getConceptoRevision());
                revisionObtenida.setObservaciones(peticion.getObservaciones());
                revisionObtenida.setFechaConcepto(new Date());
                revisionObtenida.setRutaRespuesta(rutaDestino);
                revisionObtenida.setRutaAnteproyectoRevisado(rutaDestinoRevisado);
                this.gatewayRevisionEvaluador.guardar(revisionObtenida);
                String mensajeDirector = "Se ha realizado una revision al anteproyecto con id: " + anteproyecto.getIdAnteproyectoPPB() + " con titulo: " + anteproyecto.getTituloAnteproyecto();
                String mensajeEvaluador = "usted ha realizado una revision al anteproyecto con id: " + anteproyecto.getIdAnteproyectoPPB() + " con titulo: " + anteproyecto.getTituloAnteproyecto();
                Notificacion notificacionDirector = this.factoryNotificacion.crearNotificacion(revisionEvaluador.getIdentificacionEvaluador(), anteproyecto.getIdentificacionDirectorPPB(), mensajeDirector, new Date());
                Notificacion notificacionEvaluador = this.factoryNotificacion.crearNotificacion(revisionEvaluador.getIdentificacionEvaluador(), revisionEvaluador.getIdentificacionEvaluador(), mensajeEvaluador, new Date());
                this.gatewayNotificacion.guardar(notificacionDirector);
                this.gatewayNotificacion.guardar(notificacionEvaluador);
                checkAnteproyectoEstado(this.gatewayAnteproyecto.consultarAnteproyecto(peticion.getIdAnteproyecto()));

                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyecto);
            }
        }
    }

    @Override
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosEvaluadores(int idEvaluador) {
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(anteproyectosPorEvaluador(idEvaluador));
    }

    @Override
    public List<RevisionEvaluadorPP_BDTORespuesta> listarRevisionesAnteproyectoParaEvaluador(int idEvaluador,
            String idAnteproyecto) {
        return this.formateadorRevisionEvaluador.prepararRespuestaSatisfactoriaListar(getRevisiones(idEvaluador, idAnteproyecto));
    }

    @Override
    public List<AnteproyectoPP_BDTORespuesta> listarAnteproyectosConcepto(String concepto) {
        /*Conceptos validos : Aprobado,Rechazado,En revision */
        List<AnteproyectoPP_B> listaPorConcepto = new ArrayList<>();
        List<AnteproyectoPP_B> anteproyectos = this.gatewayAnteproyecto.listarAnteproyectos();
        for(AnteproyectoPP_B anteproyectoTI_B : anteproyectos) {
            if(anteproyectoTI_B.getEstado().equals(concepto)){
                listaPorConcepto.add(anteproyectoTI_B);
            }
        }
        return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaListar(listaPorConcepto);
    }

    @Override
    public AnteproyectoPP_BDTORespuesta anexarFormatoTI_C(String idAnteproyecto, MultipartFile file) {
        boolean banderaAnteproyecto = this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto);
        if(banderaAnteproyecto){
            AnteproyectoPP_B anteproyectoAprobado = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            String nombreArchivo = "Anteproyecto_" + anteproyectoAprobado.getIdAnteproyectoPPB() + "_TI_C";
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
    public AnteproyectoPP_BDTORespuesta agregarNuevaVersionAnteproyecto(String idAnteproyecto, MultipartFile file) {
        if(this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto)){
            AnteproyectoPP_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
            int nuevoIndice = anteproyecto.getNVersion() + 1;
            if(nuevoIndice > 3){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("Excede el  numero de revisiones");
            }else{
                String nombreArchivo = "Anteproyecto_Version_"+ nuevoIndice +"_"+ anteproyecto.getIdentificacionEstudiantePPB().getLoginUsuario().getUserNameLogin();
                String rutaDestino = "";
                try {
                    rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
                } catch (IOException exception) {
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                }
                if (nuevoIndice == 2) {
                    anteproyecto.setRutaAnteproyectoPPBV2(rutaDestino);
                } else {
                    anteproyecto.setRutaAnteproyectoPPBV3(rutaDestino);
                }

                anteproyecto.setNVersion(nuevoIndice);
                this.gatewayAnteproyecto.guardar(anteproyecto);
                return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaModificarAnteproyecto(anteproyecto);
            }
            
        }
        return this.formateadorAnteproyecto.prepararRespuestaFallida("No existe el anteproyecto");
    }

    public List<RevisionEvaluadorPP_B> getRevisiones(int idEvaluador,String idAnteproyecto){
        List<RevisionEvaluadorPP_B> revisiones = new ArrayList<>();
        AnteproyectoPP_B anteproyecto = this.gatewayAnteproyecto.consultarAnteproyecto(idAnteproyecto);
        List<RevisionPP_B>  revisionesEvaluador = anteproyecto.getRevisiones();
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

    public RevisionEvaluadorPP_B getRevision(List<RevisionEvaluadorPP_B> revisionesEvaluador,int idRevision){
        for(int i = 0 ; i < revisionesEvaluador.size() ; i++){
            if(revisionesEvaluador.get(i).getIdRevisionEvaluadorPPB() == idRevision){
                return revisionesEvaluador.get(i);
            }
        }
        return null;
    }

    public List<AnteproyectoPP_B> anteproyectosPorEvaluador(int idEvaluador){
        List<AnteproyectoPP_B> lista = this.gatewayAnteproyecto.listarAnteproyectos();
        List<AnteproyectoPP_B> listaR = new ArrayList<>();
        for(int i = 0 ; i < lista.size() ; i++){
            List<RevisionPP_B> revisionAnteproyecto = lista.get(i).getRevisiones();
            if(revisionAnteproyecto.size() != 0){
                 for(int j = 0 ; j < revisionAnteproyecto.size() ; j++){
                    if(revisionAnteproyecto.get(j).getIdentificacionEvaluador1().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                        lista.get(i).getRevisiones().get(j).setIdentificacionEvaluador2(null);
                        listaR.add(lista.get(i));
                        break;
                    }
                    else if(revisionAnteproyecto.get(j).getIdentificacionEvaluador2().getIdentificacionEvaluador().getIdentificacionUsuario() == idEvaluador){
                        lista.get(i).getRevisiones().get(j).setIdentificacionEvaluador1(null);
                        listaR.add(lista.get(i));
                        break;
                    }
                }
            }
        }
        return listaR;
    }

    public void checkAnteproyectoEstado(AnteproyectoPP_B anteproyectoPP_B){
        RevisionPP_B revision = anteproyectoPP_B.getRevisiones().get(anteproyectoPP_B.getNVersion() - 1);
        if(revision.getIdentificacionEvaluador1().getConceptoRevision().equals("Aprobado") && revision.getIdentificacionEvaluador2().getConceptoRevision().equals("Aprobado")){
            anteproyectoPP_B.setEstado("Aprobado");
            this.gatewayAnteproyecto.guardar(anteproyectoPP_B);
        }
        if(revision.getIdentificacionEvaluador1().getConceptoRevision().equals("Rechazado") && revision.getIdentificacionEvaluador2().getConceptoRevision().equals("Rechazado")){
            anteproyectoPP_B.setEstado("Rechazado");
            this.gatewayAnteproyecto.guardar(anteproyectoPP_B);
        }
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/Anteproyectos/PracticaProfesional/";
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

    public String cargarArchivoEvaluadorCorreciones(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/Anteproyectos/AnotacionesEvaluador/";
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

    public String cargarArchivoRecibidosPP_B(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_B/Recibidos/";
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

    public String cargarArchivoAprobadosPP_B(MultipartFile multipartFile, String fileName) throws IOException {
        String baseDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosPP_B/Aprobados/";
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

    @Override
    public boolean existeAnteproyecto(String idAnteproyecto) {
        return this.gatewayAnteproyecto.existeAnteproyecto(idAnteproyecto);
    }

}

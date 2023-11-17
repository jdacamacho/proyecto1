package com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTOPeticion.TI_B.AnteproyectoTI_BDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionAnteproyecto.DTORespuesta.TI_B.AnteproyectoTI_BDTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.AnteproyectoTI_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayAnteproyectoTI_BImpl;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayAnteproyectoTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.AnteproyectoTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionEvaluadorTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.Anteproyecto.TI_B.RevisionTI_B;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.TI_A.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryAnteproyectoTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionTI_BInt;
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

    public GestionarAnteproyectoTI_BCU(GestionarUsuarioGatewayInt gatewayUsuario,
                                    GestionarPropuestaTrabajoGradoTI_AGatewayInt  gatewayPropuesta,
                                    GestionarGatewayAnteproyectoTI_BInt gatewayAnteproyecto,
                                    GestionarGatewayRevisionTI_BInt revisionEvaluador,
                                    GestionarGatewayRevisionEvaluadorTI_BInt revisionAnteproyecto,
                                    AnteproyectoTI_BFormateadorResultadosInt formateadorAnteproyecto,
                                    FactoryAnteproyectoTI_BInt factoryAnteproyecto,
                                    FactoryRevisionEvaluadorTI_BInt factoryRevisionEvaluador,
                                    FactoryRevisionTI_BInt factoryRevisionAnteproyecto){
        
        this.gatewayUsuario = gatewayUsuario;
        this.gatewayPropuesta = gatewayPropuesta;
        this.gatewayAnteproyecto = gatewayAnteproyecto;
        this.gatewayRevisionAnteproyecto = revisionEvaluador;
        this.gatewayRevisionEvaluador = revisionAnteproyecto;
        this.formateadorAnteproyecto = formateadorAnteproyecto;
        this.factoryAnteproyecto = factoryAnteproyecto;
        this.factoryRevisionEvaluador = factoryRevisionEvaluador;
        this.factoryRevisionAnteproyecto = factoryRevisionAnteproyecto;

    }

    @Override
    public AnteproyectoTI_BDTORespuesta crearAnteproyecto(AnteproyectoTI_BDTOPeticion peticion,MultipartFile file) {
        boolean banderaPropuesta = this.gatewayPropuesta.existePropuesta(peticion.getIdPropuestaTIA());
        if(banderaPropuesta == false){
            return this.formateadorAnteproyecto.prepararRespuestaFallida("Error, no existe la propuesta");
        }else{
            boolean banderaDirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionDirectorTIB());
            boolean banderaEstudiante1 = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEstudiante1TIB());
            boolean banderaEstudiante2 = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionEstudiante2TIB());
            boolean banderaCodirector = this.gatewayUsuario.existeUsuario(peticion.getIdentificacionCodirector());
            Usuario director = null;
            Usuario estudiante1 = null;
            Usuario estudiante2 = null;
            Usuario codirector = null;
            if(banderaDirector == false || banderaEstudiante1 == false){
                return this.formateadorAnteproyecto.prepararRespuestaFallida("error en director o estudiante");
            }else{
                director = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionDirectorTIB());
                estudiante1 = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiante1TIB());
                if(banderaEstudiante2 == false && peticion.getIdentificacionEstudiante2TIB() != -1){
                    return this.formateadorAnteproyecto.prepararRespuestaFallida("error en el estudiante 2");
                }else{
                    if(banderaCodirector == false && peticion.getIdentificacionCodirector() != -1){
                        return this.formateadorAnteproyecto.prepararRespuestaFallida("error en el codirector");
                    }
                    estudiante2 = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionEstudiante2TIB());
                    codirector = this.gatewayUsuario.consultarUsuario(peticion.getIdentificacionCodirector());
                    
                    
                    String nombreArchivo = estudiante1.getLoginUsuario().getUserNameLogin();    
                    String rutaDestino = "";   
                    try{
                        rutaDestino = cargarArchivoRecibidos(file, nombreArchivo);
                    }  catch(IOException exception){
                        return this.formateadorAnteproyecto.prepararRespuestaFallida("error al cargar el archivo");
                    } 
                    RevisionEvaluadorTI_B revision1 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0,null, null,"Revision",null,null);
                    RevisionEvaluadorTI_B revision2 = this.factoryRevisionEvaluador.crearRevisionEvaluador(0,null, null,"Revision",null,null);
                    this.gatewayRevisionEvaluador.guardar(revision1);
                    this.gatewayRevisionEvaluador.guardar(revision2);
                    RevisionTI_B revisionAnteproyecto = this.factoryRevisionAnteproyecto.crearRevisionAnteproyecto(0, revision1, revision2);
                    this.gatewayRevisionAnteproyecto.guardar(revisionAnteproyecto);
                    PropuestaTrabajoGradoTI_A propuesta = this.gatewayPropuesta.consultarPropuesta(peticion.getIdPropuestaTIA());
                    AnteproyectoTI_B anteproyectoCreado = this.factoryAnteproyecto.crearAnteproyecto(peticion.getIdAnteProyectoTIB(), propuesta, director, estudiante1, estudiante2, codirector, peticion.getTituloAnteproyecto(), rutaDestino);
                    anteproyectoCreado.getRevisiones().add(revisionAnteproyecto);
                    this.gatewayAnteproyecto.guardar(anteproyectoCreado);
                    return this.formateadorAnteproyecto.prepararRespuestaSatisfactoriaCrearAnteproyecto(anteproyectoCreado);

                }
            }
        }
        
    }

    public String cargarArchivoRecibidos(MultipartFile multipartFile, String fileName) throws IOException {
        String fileDirectory = "src/main/java/com/unicauca/proyecto1/frameworks/archivos/FormatosTI_B/Recibidos/" + fileName + ".docx";
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
    
}

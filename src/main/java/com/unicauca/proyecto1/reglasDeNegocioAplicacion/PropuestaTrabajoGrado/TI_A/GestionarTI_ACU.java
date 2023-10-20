package com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Date;
import java.util.List;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.PropuestaTrabajoGrado.PropuestaTrabajoGradoTI_A;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

public class GestionarTI_ACU implements GestionarTI_ACUInt{

    private final PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados;
    private final GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway;
    private final factoryTI_AInt objFactoryPropuesta;
    private final GestionarUsuarioGatewayInt objUsuarioGateway;

    public GestionarTI_ACU(PropuestaTrabajoGradoTI_AFormateadorResultadosInt objFormateadorResultados,
                        GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway,
                        factoryTI_AInt objFactoryTI_A,
                        GestionarUsuarioGatewayInt objUsuarioGateway){
        this.objFormateadorResultados = objFormateadorResultados;
        this.objPropuestaGateway = objPropuestaGateway;
        this.objFactoryPropuesta = objFactoryTI_A;
        this.objUsuarioGateway = objUsuarioGateway;
    }

    @Override
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listarPropuestas() {
        List<PropuestaTrabajoGradoTI_A> listaObtenida = objPropuestaGateway.listar();
        return this.objFormateadorResultados.prepararRespuestaSatisfactoriaListarPropuestas(listaObtenida);
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuesta(PropuestaTrabajoGradoTI_ADTOPeticion objPeticion) {
        Usuario director = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionDirectorTIA());
        Usuario estudiante1 =this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiante1TIA());
        Usuario codirector = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionCodirectorTIA());
        Usuario estudiante2 = this.objUsuarioGateway.consultarUsuario(objPeticion.getIdentificacionEstudiante2TIA());
        if( director == null &&  estudiante1 == null){
            return this.objFormateadorResultados.prepararRespuestaFallida("Error en director o usuario");
        }
        else{
            if(fileExists(objPeticion.getRutaPropuestaTrabajoGradoOrigen())){
                PropuestaTrabajoGradoTI_A objPropuetaCreada = this.objFactoryPropuesta
                .crearTI_A(director, estudiante1, codirector, estudiante2,
                objPeticion.getTituloPropuestaTrabajoGrado(),new Date(), null, "revision", objPeticion.getRutaPropuestaTrabajoGradoOrigen());
                this.objPropuestaGateway.guardar(objPropuetaCreada);
                return this.objFormateadorResultados.prepararRespuestaSatisfactoriaCrearPropuesta(objPropuetaCreada);
            }else{
                return this.objFormateadorResultados.prepararRespuestaFallida("No existe la ruta");
            }
            
            
           
        }
    }

    @Override
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(int idPropuesta) {
        if(this.objPropuestaGateway.consultarPropuesta(idPropuesta) == null){
            return this.objFormateadorResultados
            .prepararRespuestaFallida("Error, no se encontro la propuesta TI_A buscada");
        }else{
            PropuestaTrabajoGradoTI_A objPropuesta = this.objPropuestaGateway.consultarPropuesta(idPropuesta);
            return this.objFormateadorResultados
                        .prepararRespuestaSatisfactoriaConsultarPropuesta(objPropuesta);        }
    }

    private boolean fileExists(String filePath) {
        Path path = Paths.get(filePath);
        System.out.println("AQUIII" + path.getFileName().toString());
        return Files.exists(path) && !Files.isDirectory(path);
    }
}

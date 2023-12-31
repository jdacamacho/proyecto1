package com.unicauca.proyecto1.frameworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.GestionarPropuestaTrabajoGradoPP_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.PP_A.PropuestaTrabajoGradoPP_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.PP_A.RevisionComiteFormateadorResultadosPP_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRevisionComite.TI_A.RevisionComiteFormateadorResultadosTI_AInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.GestionarRolGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.RolFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.UsuarioFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.AnteproyectoPP_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayAnteproyectoPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayRevisionEvaluadorPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.GestionarGatewayRevisionPP_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.PP_B.RevisionEvaluadorPP_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.AnteproyectoTI_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayAnteproyectoTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.GestionarGatewayRevisionTI_BInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionAnteproyecto.TI_B.RevisionEvaluadorTI_BFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.GestionarNotificacionGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gatewayGestionNotificacion.NotificacionFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.PP_B.GestionarAnteproyectoPP_BCU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Anteproyecto.TI_B.GestionarAnteproyectoTI_BCU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Notificacion.GestionarNotificacionCU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.PP_A.GestionarPP_ACU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A.GestionarTI_ACU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Rol.GestionarRolCU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCU;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryAnteproyectoPP_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryAnteproyectoPP_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionEvaluadorPP_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionEvaluadorPP_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionPP_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.PP_B.FactoryRevisionPP_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryAnteproyectoTI_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryAnteproyectoTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionEvaluadorTI_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionEvaluadorTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionTI_BImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryAnteproyecto.TI_B.FactoryRevisionTI_BInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryNotificacion.factoryNotificacionInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A.factoryPP_AImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.PP_A.factoryPP_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryRevisionComite.factoryRevisionComiteInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioInt;

@Configuration
public class beanConfigurations {

    @Bean
    public factoryUsuarioImpl crearUsuarioFactory() {
        factoryUsuarioImpl objUsuarioFactoryImpl = new factoryUsuarioImpl();
        return objUsuarioFactoryImpl;
    }
    
    @Bean
    public factoryTI_AImpl crearPropuestaFactoryTI_A(){
        factoryTI_AImpl objFactoryTI_AImpl = new factoryTI_AImpl();
        return objFactoryTI_AImpl;
    }

    @Bean
    public factoryPP_AImpl crearPropuestaFactoryPP_A(){
        factoryPP_AImpl objFactoryPP_AImpl = new factoryPP_AImpl();
        return objFactoryPP_AImpl;
    }
    
    @Bean
    public factoryRevisionComiteImpl crearRevisionComiteFactory(){
        factoryRevisionComiteImpl objFactoryRevisionComite = new factoryRevisionComiteImpl();
        return objFactoryRevisionComite;
    }

    @Bean
    public factoryNotificacionImpl crearNotificacionFactory(){
        factoryNotificacionImpl objFactoryNotificacion = new factoryNotificacionImpl();
        return objFactoryNotificacion;
    }

    @Bean
    public FactoryAnteproyectoTI_BImpl crearFactoryAnteproyectoTI_B(){
        FactoryAnteproyectoTI_BImpl objFactoryAnteproyecto = new FactoryAnteproyectoTI_BImpl();
        return objFactoryAnteproyecto;
    }

    @Bean
    public FactoryRevisionEvaluadorTI_BImpl crearFactoryRevisionEvaluadorTI_B(){
        FactoryRevisionEvaluadorTI_BImpl objFactoryRevision = new FactoryRevisionEvaluadorTI_BImpl();
        return objFactoryRevision;
    }

    @Bean 
    public FactoryRevisionTI_BImpl crearFactoryRevisionAnteproyectoTI_B(){
        FactoryRevisionTI_BImpl objFactoryRevisionAnteproyecto = new FactoryRevisionTI_BImpl();
        return objFactoryRevisionAnteproyecto;
    }

    @Bean
    public FactoryAnteproyectoPP_BImpl crearFactoryAnteproyectoPP_B(){
        FactoryAnteproyectoPP_BImpl objFactoryAnteproyecto = new FactoryAnteproyectoPP_BImpl();
        return objFactoryAnteproyecto;
    }

    @Bean
    public FactoryRevisionEvaluadorPP_BImpl crearFactoryRevisionEvaluadorPP_B(){
        FactoryRevisionEvaluadorPP_BImpl objFactoryRevision = new FactoryRevisionEvaluadorPP_BImpl();
        return objFactoryRevision;
    }

    @Bean 
    public FactoryRevisionPP_BImpl crearFactoryRevisionAnteproyectoPP_B(){
        FactoryRevisionPP_BImpl objFactoryRevisionAnteproyecto = new FactoryRevisionPP_BImpl();
        return objFactoryRevisionAnteproyecto;
    }

    @Bean
    public GestionarAnteproyectoTI_BCU crearGestionarAnteproyectoTI_BCUInt(GestionarUsuarioGatewayInt gatewayUsuario,
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
        GestionarAnteproyectoTI_BCU anteproyectoCU = new GestionarAnteproyectoTI_BCU(gatewayUsuario, gatewayPropuesta, 
                                                                                    gatewayAnteproyecto, revisionEvaluador,
                                                                                    revisionAnteproyecto, formateadorAnteproyecto,
                                                                                    factoryAnteproyecto, factoryRevisionEvaluador,
                                                                                    factoryRevisionAnteproyecto,gatewayNotificacion,
                                                                                    factoryNotificacion,formateadorRevisionEvaluador);
        return anteproyectoCU;
    }

    @Bean
    public GestionarAnteproyectoPP_BCU crearGestionarAnteproyectoPP_BCUInt(GestionarUsuarioGatewayInt gatewayUsuario,
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
        GestionarAnteproyectoPP_BCU anteproyectoCU = new GestionarAnteproyectoPP_BCU(gatewayUsuario, gatewayPropuesta, 
                                                                                    gatewayAnteproyecto, revisionEvaluador,
                                                                                    revisionAnteproyecto, formateadorAnteproyecto,
                                                                                    factoryAnteproyecto, factoryRevisionEvaluador,
                                                                                    factoryRevisionAnteproyecto,gatewayNotificacion,
                                                                                    factoryNotificacion,formateadorRevisionEvaluador);
        return anteproyectoCU;
    }

    @Bean
    public GestionarUsuariosCU crearGestionarUsuarioCUInt(
            GestionarUsuarioGatewayInt objGestionarUsuarioGateway,
            UsuarioFormateadorResultadosInt objUsuarioFormateadorResultados,
            factoryUsuarioInt objUsuarioFactory) {
        GestionarUsuariosCU objGestionarUsuarioCU = new GestionarUsuariosCU(objGestionarUsuarioGateway,
                objUsuarioFormateadorResultados, objUsuarioFactory);
        return objGestionarUsuarioCU;
    }

    @Bean
    public GestionarRolCU crearGestionarRolCUInt(GestionarRolGatewayInt objGestionarRolGateway,
                        RolFormateadorResultadosInt objRolFormateadorResultados){
        GestionarRolCU objGestionarRolCU = new GestionarRolCU(objGestionarRolGateway, objRolFormateadorResultados);
        return objGestionarRolCU;
    }
    
    @Bean
    public GestionarTI_ACU crearGestionarTI_ACUInt(GestionarPropuestaTrabajoGradoTI_AGatewayInt objPropuestaGateway,
                                                PropuestaTrabajoGradoTI_AFormateadorResultadosInt objPropuestaFormateador,
                                                factoryTI_AInt objFactoryPropuesta,
                                                GestionarUsuarioGatewayInt objUsuarioGateway,
                                                factoryRevisionComiteInt objFactoryRevisionComite,
                                                RevisionComiteFormateadorResultadosTI_AInt objRevisionFormateador,
                                                GestionarNotificacionGatewayInt objNotificacionGateway,
                                                factoryNotificacionInt objFactoryNotificacion){
        GestionarTI_ACU objTI_ACU = new GestionarTI_ACU(objPropuestaFormateador, objPropuestaGateway,objFactoryPropuesta,objUsuarioGateway,objFactoryRevisionComite,objRevisionFormateador,objNotificacionGateway,objFactoryNotificacion);
        return objTI_ACU;
    }

    @Bean
    public GestionarPP_ACU crearGestionarPP_ACUInt(GestionarPropuestaTrabajoGradoPP_AGatewayInt objPropuestaGateway,
                                                PropuestaTrabajoGradoPP_AFormateadorResultadosInt objPropuestaFormateador,
                                                factoryPP_AInt objFactoryPropuesta,
                                                GestionarUsuarioGatewayInt objUsuarioGateway,
                                                factoryRevisionComiteInt objFactoryRevisionComite,
                                                RevisionComiteFormateadorResultadosPP_AInt objRevisionFormateador,
                                                GestionarNotificacionGatewayInt objNotificacionGateway,
                                                factoryNotificacionInt objFactoryNotificacion){
        GestionarPP_ACU objPP_ACU = new GestionarPP_ACU(objPropuestaFormateador, objPropuestaGateway,objFactoryPropuesta,objUsuarioGateway,objFactoryRevisionComite,objRevisionFormateador,objNotificacionGateway,objFactoryNotificacion);
        return objPP_ACU;
    }

    @Bean
    public GestionarNotificacionCU crearGestionarNotificacionesInt(
        GestionarNotificacionGatewayInt objGestionarNotificacionGateway,
        NotificacionFormateadorResultadosInt objFormateadorResultados,
        GestionarUsuarioGatewayInt objGestionarUsuarioGateway
    ){
        GestionarNotificacionCU objNotificacionCU = new GestionarNotificacionCU(objGestionarNotificacionGateway, objFormateadorResultados, objGestionarUsuarioGateway);
        return objNotificacionCU;
    }

}

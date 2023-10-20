package com.unicauca.proyecto1.frameworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayImpl;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.GestionarPropuestaTrabajoGradoTI_AGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosImpl;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionPropuestas.TI_A.PropuestaTrabajoGradoTI_AFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.GestionarRolGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionRoles.RolFormateadorResultadosInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.UsuarioFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A.GestionarTI_ACU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Rol.GestionarRolCU;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCU;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryPropuesta.TI_A.factoryTI_AInt;
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
    public factoryTI_AImpl crearPropuestaFactory(){
        factoryTI_AImpl objFactoryTI_AImpl = new factoryTI_AImpl();
        return objFactoryTI_AImpl;
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
                                                GestionarUsuarioGatewayInt objUsuarioGateway){
        GestionarTI_ACU objTI_ACU = new GestionarTI_ACU(objPropuestaFormateador, objPropuestaGateway,objFactoryPropuesta,objUsuarioGateway);
        return objTI_ACU;
    }

}

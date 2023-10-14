package com.unicauca.proyecto1.frameworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.GestionarUsuarioGatewayInt;
import com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios.UsuarioFormateadorResultadosInt;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCU;
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
    public GestionarUsuariosCU crearGestionarUsuarioCUInt(
            GestionarUsuarioGatewayInt objGestionarUsuarioGateway,
            UsuarioFormateadorResultadosInt objUsuarioFormateadorResultados,
            factoryUsuarioInt objUsuarioFactory) {
        GestionarUsuariosCU objGestionarUsuarioCU = new GestionarUsuariosCU(objGestionarUsuarioGateway,
                objUsuarioFormateadorResultados, objUsuarioFactory);
        return objGestionarUsuarioCU;
    }

}

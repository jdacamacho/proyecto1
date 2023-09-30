package com.unicauca.proyecto1.frameworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.proyecto1.reglasDeNegocioAplicacion.Usuario.GestionarUsuariosCU;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioImpl;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.factories.factoryUsuario.factoryUsuarioInt;
import com.unicauca.proyecto1.reglasDeNegocioEmpresa.usuario.Usuario;

@Configuration
public class beanConfigurations {

    @Bean
    public factoryUsuarioImpl crearUsuarioFactory() {
        factoryUsuarioImpl objUsuarioFactoryImpl = new factoryUsuarioImpl();
        return objUsuarioFactoryImpl;
    }
/* 
    @Bean
    public GestionarUsuariosCU crearGestionarProductoCUInt(
            GestionarProductoGatewayInt objGestionarProductoGateway,
            ProductoFormateadorResultadosInt objProductoFormateadorResultados,
            factoryUsuarioInt objProductoFactory) {
        GestionarUsuariosCU objGestionarProductoCU = new GestionarUsuariosCU(objGestionarProductoGateway,
                objProductoFormateadorResultados, objProductoFactory);
        return objGestionarProductoCU;
    }*/
}

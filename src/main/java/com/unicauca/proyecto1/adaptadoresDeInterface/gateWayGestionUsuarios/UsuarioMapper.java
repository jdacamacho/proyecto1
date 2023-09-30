package com.unicauca.proyecto1.adaptadoresDeInterface.gateWayGestionUsuarios;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioMapper {
    @Bean
    public ModelMapper crearUsuarioMapper() {
        return new ModelMapper();
    }
}

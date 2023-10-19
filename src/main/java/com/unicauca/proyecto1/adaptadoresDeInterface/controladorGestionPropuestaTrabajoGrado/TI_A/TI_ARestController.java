package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.TI_A;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A.GestionarTI_ACUInt;

@RestController
@RequestMapping("/apiPropuestas")
public class TI_ARestController {
    
    GestionarTI_ACUInt gestionarPropuestaTI_ACU;

    public TI_ARestController(GestionarTI_ACUInt gestionarPropuestaTI_ACU){
        this.gestionarPropuestaTI_ACU = gestionarPropuestaTI_ACU;
    }

    @GetMapping("/propuestas")
    public List<PropuestaTrabajoGradoTI_ADTORespuesta> listar(){
        return this.gestionarPropuestaTI_ACU.listarPropuestas();
    }
}

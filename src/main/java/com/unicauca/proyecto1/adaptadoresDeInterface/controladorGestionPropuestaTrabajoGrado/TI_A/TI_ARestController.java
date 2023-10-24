package com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.TI_A;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.PropuestaTrabajoGradoTI_ADTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTOPeticion.RevisionComiteDTOPeticion;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.PropuestaTrabajoGradoTI_ADTORespuesta;
import com.unicauca.proyecto1.adaptadoresDeInterface.controladorGestionPropuestaTrabajoGrado.DTORespuesta.RevisionComiteDTORespuesta;
import com.unicauca.proyecto1.frameworks.repositorios.formatoTI_ARepositorio.FormatoTI_ARepositoryJPA;
import com.unicauca.proyecto1.reglasDeNegocioAplicacion.PropuestaTrabajoGrado.TI_A.GestionarTI_ACUInt;

@RestController
@RequestMapping("/apiPropuestasTI_A")
public class TI_ARestController {
    
    private final GestionarTI_ACUInt gestionarPropuestaTI_ACU;

    public TI_ARestController(GestionarTI_ACUInt gestionarPropuestaTI_ACU,FormatoTI_ARepositoryJPA repositorio){
        this.gestionarPropuestaTI_ACU = gestionarPropuestaTI_ACU;
    }

    @GetMapping("/propuestas")
    public Iterable<PropuestaTrabajoGradoTI_ADTORespuesta> listar(){
        return this.gestionarPropuestaTI_ACU.listarPropuestas();
    }

    @GetMapping("/propuestas/{id}")
    public PropuestaTrabajoGradoTI_ADTORespuesta consultarPropuesta(@PathVariable int id ){
       return this.gestionarPropuestaTI_ACU.consultarPropuesta(id);
    }

    @PostMapping("/propuestas")
    public PropuestaTrabajoGradoTI_ADTORespuesta crearPropuestas(@RequestBody PropuestaTrabajoGradoTI_ADTOPeticion objPeticion){
        return this.gestionarPropuestaTI_ACU.crearPropuesta(objPeticion);
    }
    
    @PostMapping("/propuestasRevisionComite")
    public RevisionComiteDTORespuesta realizarRevision(@RequestBody RevisionComiteDTOPeticion objPeticion){
        return this.gestionarPropuestaTI_ACU.realizarRevision(objPeticion);
    }


}

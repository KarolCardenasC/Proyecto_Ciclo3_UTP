package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.model.Ingreso;
import com.panoptico.services.IngresoService;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    private IngresoService service;

    public IngresoController() {
        service = new IngresoService();
    }


    @GetMapping
    @CrossOrigin("*")
    public List<Ingreso> getIngreso() {
        return service.getIngreso();
    }

    @GetMapping("/{idIngreso}")
    public Ingreso getxId_Ingreso(@PathVariable(name = "idIngreso") int idIngreso) {
        return service.getxId_Ingreso(idIngreso);
    }
    
    @PostMapping("/visitantes/{idVisitas}")
    @CrossOrigin("*")
    public String create_ingreso(@PathVariable(name = "idVisitas") String ingreso_visita) {
        return service.create_ingreso_visita(ingreso_visita);

    }

    @PostMapping("/estudiantes/{idEstudiante}")
    @CrossOrigin("*")
    public String create_ingreso_estudiante(@PathVariable(name = "idEstudiante") String ingreso_estudiante) {
        return service.create_ingreso_estudiante(ingreso_estudiante);

    }

    @DeleteMapping("/{idIngreso}")
    @CrossOrigin("*")
    public String deleteIngresoxId(@PathVariable(name = "idIngreso") int idIngreso) {
        return service.deleteIngresoxId(idIngreso);
    }
}

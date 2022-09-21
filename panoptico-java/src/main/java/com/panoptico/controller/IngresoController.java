package com.panoptico.controller;

import java.util.List;

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
    public List<Ingreso> getIngreso() {
        return service.getIngreso();
    }
    
    @PostMapping("/{idEstudiante}/{idVisitas}")
    public String create_ingreso(@PathVariable(name = "idEstudiante") int ingreso_estudiante, @PathVariable(name = "idVisitas") int ingreso_visita) {
        return service.create_ingreso(ingreso_estudiante, ingreso_visita);

    }

    @PostMapping("/{idEstudiante}")
    public String create_ingreso_estudiante(@PathVariable(name = "idEstudiante") int ingreso_estudiante) {
        return service.create_ingreso_estudiante(ingreso_estudiante);

    }
}

package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.model.EstudiantesInscritos;
import com.panoptico.services.EstudiantesService;

@RestController
@RequestMapping("/estudiantes_inscritos")
public class EstudiantesInscritosController {
    private EstudiantesService service;

    public EstudiantesInscritosController() {
        service = new EstudiantesService();
    }

    @GetMapping
    public List<EstudiantesInscritos> getEstudiantesInscritos() {
        return service.getEstudiantesInscritos();
    }

    @GetMapping("/{cedula}")
    public List<EstudiantesInscritos> getxCC(@PathVariable(name = "cedula") String cedula) {
        return service.getxCC(cedula);
    }

    
  @PostMapping
  public String create(@RequestBody EstudiantesInscritos estudiante) {
    return service.create(estudiante);
    
  }

}

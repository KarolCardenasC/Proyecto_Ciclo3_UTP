package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.model.EstudiantesInscritos;
import com.panoptico.services.EstudiantesService;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesInscritosController {
    private EstudiantesService service;

    public EstudiantesInscritosController() {
        service = new EstudiantesService();
    }

    @GetMapping
    public List<EstudiantesInscritos> getEstudiantesInscritos() {
        return service.getEstudiantesInscritos();
    }
}
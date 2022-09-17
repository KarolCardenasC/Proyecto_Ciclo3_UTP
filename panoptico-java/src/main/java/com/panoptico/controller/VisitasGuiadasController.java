package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.model.VisitasGuiadas;
import com.panoptico.services.VisitasService;

@RestController
@RequestMapping("/visitas_guiadas")
public class VisitasGuiadasController {

    private VisitasService service;

    public VisitasGuiadasController() {
        service = new VisitasService();
    }

    @GetMapping
    public List<VisitasGuiadas> getVisitasGuiadas() {
        return service.getVisitasGuiadas();
    }

    @PostMapping
    public String create(@RequestBody VisitasGuiadas visitasGuiadas) {
        return service.create(visitasGuiadas);
    }

}

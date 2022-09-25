package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @CrossOrigin("*")
    public List<VisitasGuiadas> getVisitasGuiadas() {
        return service.getVisitasGuiadas();
    }

    @GetMapping("/{cedula}")
    @CrossOrigin("*")
    public VisitasGuiadas getxCC_VisitasGuiadas(@PathVariable(name = "cedula") String cedula) {
        return service.getxCC_VisitasGuiadas(cedula);
    }

    @GetMapping("/id/{idVisitas}")
    @CrossOrigin("*")
    public VisitasGuiadas getxId_VisitasGuiadas(@PathVariable(name = "idVisitas") int idVisitas) {
        return service.getxId_VisitasGuiadas(idVisitas);
    }

    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody VisitasGuiadas visitasGuiadas) {
        return service.create(visitasGuiadas);
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public String create_register_visita(@RequestBody VisitasGuiadas visitasGuiadas) {
        return service.create_register_visita(visitasGuiadas);

    }

    @PutMapping
    @CrossOrigin("*")
    public String updateVisitasGuiadas(@RequestBody VisitasGuiadas visitasGuiadas) {
        return service.updateVisitasGuiadas(visitasGuiadas);
    }

    @DeleteMapping("/id/{idVisitas}")
    @CrossOrigin("*")
    public String deleteVisitasGuiadasxId(@PathVariable(name = "idVisitas") int idVisitas) {
        return service.deleteVisitasGuiadasxId(idVisitas);
    }

    @DeleteMapping("/cc/{cedula}")
    public String deleteVisitasGuiadasxCC(@PathVariable(name = "cedula") String cedula) {
        return service.deleteVisitasGuiadasxCC(cedula);
    }
}

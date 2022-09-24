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
    @CrossOrigin("*")
    public EstudiantesInscritos getxCC(@PathVariable(name = "cedula") String cedula) {      
      return service.getxCC(cedula);
    }
    @GetMapping("/existe/{cedula}")
    @CrossOrigin("*")
    public boolean existe(@PathVariable(name = "cedula") String cedula) {      
      return service.existe(cedula);
    }

    @GetMapping("/id/{idEstudiante}")
    public EstudiantesInscritos getxId(@PathVariable(name = "idEstudiante") int idEstudiante) {
      return service.getxId(idEstudiante);
    }

    @PostMapping
    public String create(@RequestBody EstudiantesInscritos estudiante) {
      return service.create(estudiante);

    }

    @PostMapping("/register")
    public String create_register_estudiante(@RequestBody EstudiantesInscritos estudiante) {
      return service.create_register_estudiante(estudiante);

    }

    @PutMapping
    @CrossOrigin("*")
    public String updateEstudiantesInscritos(@RequestBody EstudiantesInscritos estudiante) {
      return service.updateEstudiantesInscritos(estudiante);
    }

    @DeleteMapping("/id/{idEstudiante}")
    @CrossOrigin("*")
    public String deleteEstudiantesInscritosxId(@PathVariable(name = "idEstudiante") int idEstudiante) {
      return service.deleteEstudiantesInscritosxId(idEstudiante);
    }

    @DeleteMapping("/cc/{cedula}")
    @CrossOrigin("*")
    public String deleteEstudiantesInscritosxCC(@PathVariable(name = "cedula") String cedula) {
      return service.deleteEstudiantesInscritosxCC(cedula);
    }

}

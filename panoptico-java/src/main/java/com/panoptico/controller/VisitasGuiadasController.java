package com.panoptico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.services.VisitasService;

@RestController
@RequestMapping("/#")
public class VisitasGuiadasController {

    private VisitasService service;

    public VisitasGuiadasController() {
        service = new VisitasService();
    }

}

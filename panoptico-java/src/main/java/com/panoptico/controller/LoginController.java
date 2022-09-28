package com.panoptico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panoptico.model.LoginAdmin;
import com.panoptico.services.LoginService;

@RestController
@RequestMapping("/login_admin")
public class LoginController {
    private LoginService service;

    public LoginController() {
        service = new LoginService();
    }

    @GetMapping
    @CrossOrigin("*")
    public List<LoginAdmin> getLoginAdmin() {
        return service.getLoginAdmin();
    }

    @GetMapping("/email{email}")
    @CrossOrigin("*")
    public LoginAdmin getEmail(@PathVariable(name = "email") String email) {
        return service.getEmail(email);
    }

    @GetMapping("/pass{pass}")
    @CrossOrigin("*")
    public LoginAdmin getPass(@PathVariable(name = "pass") String pass) {
        return service.getPass(pass);
    }

    @GetMapping("/login")
    @CrossOrigin("*")
    public boolean login(@RequestParam String username, @RequestParam String clave) {
      return service.login(username, clave);
    }

}

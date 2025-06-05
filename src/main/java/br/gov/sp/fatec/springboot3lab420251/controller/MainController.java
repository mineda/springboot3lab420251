package br.gov.sp.fatec.springboot3lab420251.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping
    public String index() {
        return "Nada aqui! Use uma das outras rotas!";
    }
    
}

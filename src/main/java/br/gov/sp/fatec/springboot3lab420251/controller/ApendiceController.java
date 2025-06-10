package br.gov.sp.fatec.springboot3lab420251.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab420251.entity.Apendice;
import br.gov.sp.fatec.springboot3lab420251.service.ApendiceService;

@RestController
@CrossOrigin
@RequestMapping(value = "/apendice")
public class ApendiceController {

    @Autowired
    private ApendiceService service;

    @GetMapping
    public List<Apendice> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping(value = "/{texto}/{titulo}")
    public List<Apendice> buscarPorTextoETrabalho(@PathVariable("texto") String texto, @PathVariable("titulo") String titulo) {
        return service.buscarPorTextoETrabalho(texto, titulo);
    }

    @PostMapping
    public Apendice novo(@RequestBody Apendice apendice) {
        return service.novo(apendice);
    }

}

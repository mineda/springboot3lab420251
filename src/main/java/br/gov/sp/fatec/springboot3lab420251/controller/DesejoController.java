package br.gov.sp.fatec.springboot3lab420251.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3lab420251.entity.Desejo;
import br.gov.sp.fatec.springboot3lab420251.service.DesejoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/desejo")
public class DesejoController {

    @Autowired
    private DesejoService service;

    @GetMapping
    public List<Desejo> todos() {
        return service.todos();
    }

    @GetMapping(value = "/{nivelInteresse}/{dataHoraAnuncio}")
    public List<Desejo> buscarPorNivelInteresseEDataHoraAnuncio(@PathVariable("nivelInteresse") Integer nivelInteresse, @PathVariable("dataHoraAnuncio") LocalDateTime dataHoraAnuncio) {
        return service.buscarDesejosPorNivelInteresseEDataHoraAnuncio(nivelInteresse, dataHoraAnuncio);
    }
    
    @PostMapping
    public Desejo novoDesejo(@RequestBody Desejo desejo) {
        return service.novoDesejo(desejo);
    }
    
}

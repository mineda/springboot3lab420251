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

import br.gov.sp.fatec.springboot3lab420251.entity.Produto;
import br.gov.sp.fatec.springboot3lab420251.service.ProdutoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> todos() {
        return service.todos();
    }

    @GetMapping(value = "/{descricao}")
    public List<Produto> buscarPorDescricao(@PathVariable("descricao") String descricao) {
        return service.buscarPorDescricao(descricao);
    }

    @PostMapping
    public Produto novo(@RequestBody Produto produto) {
        return service.novo(produto);
    }
    
}

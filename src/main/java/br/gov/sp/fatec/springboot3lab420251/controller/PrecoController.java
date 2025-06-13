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

import br.gov.sp.fatec.springboot3lab420251.entity.Preco;
import br.gov.sp.fatec.springboot3lab420251.service.PrecoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/preco")
public class PrecoController {

    @Autowired
    private PrecoService service;

    @GetMapping
    public List<Preco> todosPrecos() {
        return service.todas();
    }

    @GetMapping(value = "/{descricao}/{dataHora}")
    public List<Preco> buscarPorProdutoDescricaoEDataHora(@PathVariable("descricao") String descricaoProduto, @PathVariable("dataHora") LocalDateTime dataHora) {
        return service.buscarPorProdutoDescricaoEPrecoDataHora(descricaoProduto, dataHora);
    }

    @PostMapping
    public Preco novoPreco(@RequestBody Preco preco) {
        return service.novo(preco);
    }
}

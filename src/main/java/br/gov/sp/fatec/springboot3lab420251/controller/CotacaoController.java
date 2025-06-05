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

import br.gov.sp.fatec.springboot3lab420251.entity.Cotacao;
import br.gov.sp.fatec.springboot3lab420251.service.CotacaoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService service;

    @GetMapping
    public List<Cotacao> todasCotacoes() {
        return service.todas();
    }

    @GetMapping(value = "/{descricao}/{valor}")
    public List<Cotacao> buscarPorProdutoDescricaoEValor(@PathVariable("descricao") String descricaoProduto, @PathVariable("valor") Float valor) {
        return service.buscarPorProdutoDescricaoEValor(descricaoProduto, valor);
    }
    
    @PostMapping
    public Cotacao novaCotacao(@RequestBody Cotacao cotacao) {
        return service.novo(cotacao);
    }
}

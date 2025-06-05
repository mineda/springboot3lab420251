package br.gov.sp.fatec.springboot3lab420251.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab420251.entity.Cotacao;
import br.gov.sp.fatec.springboot3lab420251.repository.CotacaoRepository;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository repo;

    @Autowired
    private ProdutoService produtoService;

    public List<Cotacao> buscarPorProdutoDescricaoEValor(String descricaoProduto, Float valor) {
        if(descricaoProduto == null || descricaoProduto.isBlank() || valor == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição do produto e valor não podem ser nulos ou vazios.");
        }
        return repo.findByProdutoDescricaoContainingIgnoreCaseAndValorLessThan(descricaoProduto, valor);
    }

    public Cotacao novo(Cotacao cotacao) {
        if(cotacao == null || 
               cotacao.getProduto() == null || 
               cotacao.getProduto().getId() == null ||
               cotacao.getValor() == null ||
               cotacao.getValor() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cotação, valor e produto não podem ser nulos ou vazios.");
        }
        if(cotacao.getDataHora() == null) {
            cotacao.setDataHora(LocalDateTime.now());
        }
        cotacao.setProduto(produtoService.buscarPorId(cotacao.getProduto().getId()));
        cotacao.setId(null);
        return repo.save(cotacao);

    }

    public List<Cotacao> todas() {
        return repo.findAll();
    }
    
}

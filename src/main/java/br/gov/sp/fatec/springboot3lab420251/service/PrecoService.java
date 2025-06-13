package br.gov.sp.fatec.springboot3lab420251.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab420251.entity.Preco;
import br.gov.sp.fatec.springboot3lab420251.repository.PrecoRepository;

@Service
public class PrecoService {

    @Autowired
    private PrecoRepository repo;

    @Autowired
    private ProdutoService produtoService;

    public List<Preco> buscarPorProdutoDescricaoEPrecoDataHora(String descricaoProduto, LocalDateTime dataHora) {
        if(descricaoProduto == null || descricaoProduto.isBlank() || dataHora == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição do produto e data/hora não podem ser nulos ou vazios.");
        }
        return repo.findByProdutoDescricaoContainingIgnoreCaseAndDataHoraLessThanEqualOrderByDataHoraDesc(descricaoProduto, dataHora);
    }

    public Preco novo(Preco preco) {
        if(preco == null || 
               preco.getProduto() == null || 
               preco.getProduto().getId() == null ||
               preco.getValor() == null ||
               preco.getValor() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preço, valor e produto não podem ser nulos ou vazios.");
        }
        if(preco.getDataHora() == null) {
            preco.setDataHora(LocalDateTime.now());
        }
        preco.setProduto(produtoService.buscarPorId(preco.getProduto().getId()));
        preco.setId(null);
        return repo.save(preco);

    }

    public List<Preco> todas() {
        return repo.findAll();
    }
    
}


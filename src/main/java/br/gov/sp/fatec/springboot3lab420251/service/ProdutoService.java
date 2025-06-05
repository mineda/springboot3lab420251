package br.gov.sp.fatec.springboot3lab420251.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab420251.entity.Produto;
import br.gov.sp.fatec.springboot3lab420251.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public List<Produto> buscarPorDescricao(String descricao) {
        return repo.findByDescricaoContainingIgnoreCase(descricao);
    }

    public Produto novo(Produto produto) {
        if(produto == null ||
           produto.getDescricao() == null || produto.getDescricao().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto e descrição não podem ser nulos ou vazios.");
        }
        if(produto.getDataHoraAnuncio() == null) {
            produto.setDataHoraAnuncio(LocalDateTime.now());
        }
        produto.setId(null); 
        return repo.save(produto);
    }

    public List<Produto> todos() {
        return repo.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }

}

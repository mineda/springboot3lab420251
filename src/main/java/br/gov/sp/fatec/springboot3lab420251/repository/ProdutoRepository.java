package br.gov.sp.fatec.springboot3lab420251.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab420251.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    public List<Produto> findByDescricaoContainingIgnoreCase(String descricao);
    
}

package br.gov.sp.fatec.springboot3lab420251.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab420251.entity.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
    
    public List<Cotacao> findByProdutoDescricaoContainingIgnoreCaseAndValorLessThan(String descricaoProduto, Float valor);
    
}

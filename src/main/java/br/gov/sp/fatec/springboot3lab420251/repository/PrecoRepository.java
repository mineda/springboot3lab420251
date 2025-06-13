package br.gov.sp.fatec.springboot3lab420251.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab420251.entity.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long> {

    public List<Preco> findByProdutoDescricaoContainingIgnoreCaseAndDataHoraLessThanEqualOrderByDataHoraDesc(String descricao, LocalDateTime dataHora);
    
}

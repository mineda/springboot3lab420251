package br.gov.sp.fatec.springboot3lab420251.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab420251.entity.Apendice;

public interface ApendiceRepository extends JpaRepository<Apendice, Long> {
    
    List<Apendice> findByTextoContainingIgnoreCaseAndTrabalhoTituloContainingIgnoreCase(String texto, String titulo);
    
}

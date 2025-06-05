package br.gov.sp.fatec.springboot3lab420251.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3lab420251.entity.Desejo;

public interface DesejoRepository extends JpaRepository<Desejo, Long> {

    public List<Desejo> findByNivelInteresseGreaterThanAndProdutoDataHoraAnuncioLessThan(Integer nivelInteresse, LocalDateTime dataHoraAnuncio);

}

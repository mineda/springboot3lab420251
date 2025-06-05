package br.gov.sp.fatec.springboot3lab420251.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pro_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "pro_data_hora_anuncio", nullable = false)
    private LocalDateTime dataHoraAnuncio;

    @Column(name = "pro_data_hora_lancamento")
    private LocalDateTime dataHoraLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraAnuncio() {
        return dataHoraAnuncio;
    }

    public void setDataHoraAnuncio(LocalDateTime dataHoraAnuncio) {
        this.dataHoraAnuncio = dataHoraAnuncio;
    }

    public LocalDateTime getDataHoraLancamento() {
        return dataHoraLancamento;
    }

    public void setDataHoraLancamento(LocalDateTime dataHoraLancamento) {
        this.dataHoraLancamento = dataHoraLancamento;
    }
    
}

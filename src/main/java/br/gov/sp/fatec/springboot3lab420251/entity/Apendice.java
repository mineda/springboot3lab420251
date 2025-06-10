package br.gov.sp.fatec.springboot3lab420251.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ape_apendice")
public class Apendice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ape_id")
    private Long id;

    @Column(name = "ape_texto", nullable = false, length = 200)
    private String texto;

    @Column(name = "ape_data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "ape_data_hora_aprovacao")
    private LocalDateTime dataHoraAprovacao;

    @ManyToOne
    @JoinColumn(name = "ape_tra_id", nullable = false)
    private Trabalho trabalho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHoraAprovacao() {
        return dataHoraAprovacao;
    }

    public void setDataHoraAprovacao(LocalDateTime dataHoraAprovacao) {
        this.dataHoraAprovacao = dataHoraAprovacao;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}

package br.gov.sp.fatec.springboot3lab420251.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab420251.entity.Apendice;
import br.gov.sp.fatec.springboot3lab420251.repository.ApendiceRepository;

@Service
public class ApendiceService {

    @Autowired
    private ApendiceRepository repo;

    @Autowired
    private TrabalhoService trabalhoService;

    public List<Apendice> listarTodos() {
        return repo.findAll();
    }

    public Apendice buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Apendice não encontrado"));
    }

    public Apendice novo(Apendice apendice) {
        if (apendice.getTexto() == null || apendice.getTexto().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Texto do apêndice não pode ser vazio");
        }
        if (apendice.getTrabalho() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trabalho associado ao apêndice não pode ser nulo");
        }
        if (apendice.getDataHora() == null) {
            apendice.setDataHora(LocalDateTime.now());
        }
        apendice.setTrabalho(trabalhoService.buscarPorId(apendice.getTrabalho().getId()));
        apendice.setId(null);
        return repo.save(apendice);
    }

    public List<Apendice> buscarPorTextoETrabalho(String texto, String titulo) {
        if (texto == null || texto.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Texto não pode ser vazio");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Título do trabalho não pode ser vazio");
        }
        return repo.findByTextoContainingIgnoreCaseAndTrabalhoTituloContainingIgnoreCase(texto, titulo);
    }
    
}

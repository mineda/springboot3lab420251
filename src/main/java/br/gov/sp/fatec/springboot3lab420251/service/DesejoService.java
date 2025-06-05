package br.gov.sp.fatec.springboot3lab420251.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3lab420251.entity.Desejo;
import br.gov.sp.fatec.springboot3lab420251.repository.DesejoRepository;

@Service
public class DesejoService {

    @Autowired
    private DesejoRepository repo;

    @Autowired
    private ProdutoService produtoService;

    public List<Desejo> buscarDesejosPorNivelInteresseEDataHoraAnuncio(Integer nivelInteresse, LocalDateTime dataHoraAnuncio) {
        if(nivelInteresse == null || nivelInteresse < 0 || dataHoraAnuncio == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nível de interesse não pode ser nulo ou negativo e data/hora do anúncio não pode ser nula.");
        }
        return repo.findByNivelInteresseGreaterThanAndProdutoDataHoraAnuncioLessThan(nivelInteresse, dataHoraAnuncio);
    }
    public Desejo novoDesejo(Desejo desejo) {
        if (desejo == null || 
                desejo.getProduto() == null || 
                desejo.getProduto().getId() == null ||
                desejo.getNivelInteresse() == null ||
                desejo.getNivelInteresse() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Desejo, produto e nível de interesse não podem ser nulos.");
        }
        if (desejo.getDataHoraInclusao() == null) {
            desejo.setDataHoraInclusao(LocalDateTime.now());
        }
        desejo.setProduto(produtoService.buscarPorId(desejo.getProduto().getId()));
        desejo.setId(null); 
        return repo.save(desejo);
    }
    public List<Desejo> todos() {
        return repo.findAll();
    }
    
}

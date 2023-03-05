package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.CidadeDTO;
import br.com.rmc.rocket.entity.Cidade;
import br.com.rmc.rocket.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeDTO> buscarTodos() {
        List<Cidade> cidadeList = cidadeRepository.findAll();

        return cidadeList.stream().map(this::converterParaDTO).toList();
    }

    private CidadeDTO converterParaDTO(Cidade cidade) {
        return CidadeDTO.builder().id(cidade.getId()).nome(cidade.getNome()).build();
    }


}

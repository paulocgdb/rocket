package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.CandidaturaDTO;
import br.com.rmc.rocket.entity.Candidatura;
import br.com.rmc.rocket.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;

    public CandidaturaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    public List<CandidaturaDTO> buscarTodos() {
        List<Candidatura> candidaturaDTOList = candidaturaRepository.findAll();

        return candidaturaDTOList.stream().map(this::converterParaDTO).toList();
    }

    private CandidaturaDTO converterParaDTO(Candidatura candidatura) {
        return CandidaturaDTO.builder().id(candidatura.getId()).build();
    }


}

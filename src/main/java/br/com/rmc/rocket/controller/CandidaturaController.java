package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.dto.CandidaturaDTO;
import br.com.rmc.rocket.service.CandidaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    public CandidaturaController(CandidaturaService candidaturaService) {
        this.candidaturaService = candidaturaService;
    }

    @GetMapping
    public ResponseEntity<List<CandidaturaDTO>> buscarTodos() {
        List<CandidaturaDTO> candidaturaDTOList = candidaturaService.buscarTodos();
        if (!candidaturaDTOList.isEmpty()) {
            return ResponseEntity.ok(candidaturaDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

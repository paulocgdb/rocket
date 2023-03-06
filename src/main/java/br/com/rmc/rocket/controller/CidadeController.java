package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.dto.CidadeDTO;
import br.com.rmc.rocket.service.CidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> buscarTodos() {
        List<CidadeDTO> cidadeDTOList = cidadeService.buscarTodos();
        if (!cidadeDTOList.isEmpty()) {
            return ResponseEntity.ok(cidadeDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}

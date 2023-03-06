package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.dto.CandidaturaDTO;
import br.com.rmc.rocket.entity.Candidatura;
import br.com.rmc.rocket.service.CandidaturaService;
import br.com.rmc.rocket.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/candidaturas")
@CrossOrigin(origins = "*")
public class CandidaturaController {

    private final CandidaturaService candidaturaService;
    private final UsuarioService usuarioService;

    public CandidaturaController(CandidaturaService candidaturaService,
                                 UsuarioService usuarioService) {
        this.candidaturaService = candidaturaService;
        this.usuarioService = usuarioService;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Candidatura> salvarCandidatura(@RequestParam("candidatura") CandidaturaDTO candidaturaDTO,
                                                         @RequestPart("documentos") List<MultipartFile> documentos
    ) {
        if (usuarioService.ehUsuarioJaCadastrado(candidaturaDTO.getUsuario().getEmail())) {
            throw new RuntimeException("Usuário já existente! Acesse a área restrita.");
        }

        Candidatura candidaturaSalva = candidaturaService.salvar(candidaturaDTO, documentos);

        return ResponseEntity.ok(candidaturaSalva);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<CandidaturaDTO>> buscarPorIdUsuario(@PathVariable("idUsuario") Long idUsuario) {
        List<CandidaturaDTO> candidaturaDTOList = candidaturaService.buscarPorUsuarioId(idUsuario);
        if (!candidaturaDTOList.isEmpty()) {
            return ResponseEntity.ok(candidaturaDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CandidaturaDTO>> buscarTodasEmAnalise() {
        List<CandidaturaDTO> candidaturaDTOList = candidaturaService.buscarTodasEmAnalise();
        if (!candidaturaDTOList.isEmpty()) {
            return ResponseEntity.ok(candidaturaDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/aprovar/{id}")
    public ResponseEntity<Boolean> aprovarCandidatura(@PathVariable("id") Long id) {
        return ResponseEntity.ok(candidaturaService.aprovar(id));
    }

    @GetMapping("/reprovar/{id}")
    public ResponseEntity<Boolean> reprovarCandidatura(@PathVariable("id") Long id) {
        return ResponseEntity.ok(candidaturaService.reprovar(id));
    }
}

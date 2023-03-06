package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.dto.CandidaturaDTO;
import br.com.rmc.rocket.dto.UsuarioDTO;
import br.com.rmc.rocket.entity.Candidatura;
import br.com.rmc.rocket.service.CandidaturaService;
import br.com.rmc.rocket.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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

    @PostMapping(value = "/cadastrar", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Candidatura> salvarCandidatura(@RequestPart("usuario") UsuarioDTO usuarioDTO,
                                                         @RequestPart("documentos") List<MultipartFile> documentos
    ) {
        if (usuarioService.ehUsuarioJaCadastrado(usuarioDTO.getEmail())) {
            throw new RuntimeException("Usuário já existente! Acesse a área restrita.");
        }

        Candidatura candidaturaSalva = candidaturaService.salvar(usuarioDTO, documentos);

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

    @GetMapping("/em-analise")
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

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<Candidatura> buscarCandidatura(@PathVariable("id") Long id) {
        Optional<Candidatura> candidatura = candidaturaService.buscarPorId(id);

        return candidatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

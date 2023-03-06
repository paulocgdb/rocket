package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.CandidaturaDTO;
import br.com.rmc.rocket.dto.UsuarioDTO;
import br.com.rmc.rocket.entity.Candidatura;
import br.com.rmc.rocket.entity.Status;
import br.com.rmc.rocket.entity.Usuario;
import br.com.rmc.rocket.repository.CandidaturaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final UsuarioService usuarioService;
    private final DocumentoService documentoService;
    private final StatusService statusService;

    public CandidaturaService(DocumentoService documentoService,
                              StatusService statusService,
                              CandidaturaRepository candidaturaRepository,
                              UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.documentoService = documentoService;
        this.statusService = statusService;
        this.candidaturaRepository = candidaturaRepository;
    }

    public List<CandidaturaDTO> buscarTodasEmAnalise() {
        List<Candidatura> candidaturaDTOList = candidaturaRepository.findAllByStatusEmAnalise();

        return candidaturaDTOList.stream().map(this::converterParaDTO).toList();
    }

    private CandidaturaDTO converterParaDTO(Candidatura candidatura) {
        return CandidaturaDTO.builder().id(candidatura.getId()).build();
    }

    @Transactional
    public Candidatura salvar(UsuarioDTO usuarioDTO, List<MultipartFile> documentos) {
        Usuario usuarioSalvo = usuarioService.salvar(usuarioDTO);

        documentoService.salvarDocumentos(documentos, usuarioSalvo);

        Status statusInicial = statusService.buscarStatusPorId(1L).get();

        Candidatura candidatura = new Candidatura();
        candidatura.setUsuario(usuarioSalvo);
        candidatura.setStatus(statusInicial);
        candidatura.setDataCriacao(LocalDateTime.now());

        candidaturaRepository.save(candidatura);

        return candidatura;
    }

    public List<CandidaturaDTO> buscarPorUsuarioId(Long id) {
        List<Candidatura> candidaturaDTOList = candidaturaRepository.findByUsuarioId(id);

        return candidaturaDTOList.stream().map(this::converterParaDTO).toList();
    }

    public boolean aprovar(Long id) {
        Optional<Candidatura> candidatura = candidaturaRepository.findById(id);

        if (candidatura.isPresent()) {
            Status statusAprovada = statusService.buscarStatusPorId(3L).get();
            candidatura.get().setStatus(statusAprovada);
            candidaturaRepository.save(candidatura.get());
            return true;
        }

        throw new RuntimeException("Não foi possível aprovar a candidatura!");
    }

    public boolean reprovar(Long id) {
        Optional<Candidatura> candidatura = candidaturaRepository.findById(id);

        if (candidatura.isPresent()) {
            Status statusAprovada = statusService.buscarStatusPorId(2L).get();
            candidatura.get().setStatus(statusAprovada);
            candidaturaRepository.save(candidatura.get());
            return true;
        }

        throw new RuntimeException("Não foi possível reprovar a candidatura!");
    }
}

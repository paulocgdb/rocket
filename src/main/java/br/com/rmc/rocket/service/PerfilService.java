package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.PerfilDTO;
import br.com.rmc.rocket.entity.Perfil;
import br.com.rmc.rocket.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<PerfilDTO> buscarTodos() {
        List<Perfil> cidadeList = perfilRepository.findAll();

        return cidadeList.stream().map(this::converterParaDTO).toList();
    }

    private PerfilDTO converterParaDTO(Perfil perfil) {
        return PerfilDTO.builder().id(perfil.getId()).nome(perfil.getNome()).build();
    }

    public Optional<Perfil> buscarPerfilPorId(Long id) {
        return perfilRepository.findById(id);
    }

}

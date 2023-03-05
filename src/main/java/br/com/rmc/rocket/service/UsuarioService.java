package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.UsuarioDTO;
import br.com.rmc.rocket.entity.Usuario;
import br.com.rmc.rocket.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> buscarTodos() {
        List<Usuario> usuarioList = usuarioRepository.findAll();

        return usuarioList.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    private UsuarioDTO converterParaDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .build();
    }

    private Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .nome(usuarioDTO.getNome())
                .build();
    }


}

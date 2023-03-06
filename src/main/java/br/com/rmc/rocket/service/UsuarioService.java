package br.com.rmc.rocket.service;

import br.com.rmc.rocket.dto.UsuarioDTO;
import br.com.rmc.rocket.entity.Usuario;
import br.com.rmc.rocket.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilService perfilService) {
        this.usuarioRepository = usuarioRepository;
        this.perfilService = perfilService;
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioDTO buscarPorEmail(String email) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email);

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public boolean ehUsuarioJaCadastrado(String email) {
        return usuarioRepository.findUsuarioByEmail(email) != null;
    }

    @Transactional
    public Usuario salvar(UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);

        if (usuarioDTO.getEmail().contains("@rocket.com")) {
            usuario.setPerfil(perfilService.buscarPerfilPorId(1L).get());
        } else {
            usuario.setPerfil(perfilService.buscarPerfilPorId(2L).get());
        }

        usuarioRepository.save(usuario);

        return usuario;
    }

}

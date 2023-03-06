package br.com.rmc.rocket.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UsuarioService usuarioService;

    public LoginService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public boolean realizarLogin() {
        return true;
    }

}

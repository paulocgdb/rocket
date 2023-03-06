package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.entity.Usuario;
import br.com.rmc.rocket.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService
    ) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> realizarLogin(@RequestParam("email") String email,
                                                 @RequestParam("senha") String senha
    ) {

        Usuario usuario = usuarioService.buscarPorEmailESenha(email, senha);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario.getPerfil().getId());
    }

}

package br.com.rmc.rocket.controller;

import br.com.rmc.rocket.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Boolean> realizarLogin(@RequestParam("email") String email,
                                                 @RequestParam("senha") String senha
    ) {
        return ResponseEntity.ok(true);

    }

}

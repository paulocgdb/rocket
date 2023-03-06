package br.com.rmc.rocket.repository;

import br.com.rmc.rocket.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuarioByEmail(String email);
    public Usuario findUsuarioByEmailEqualsAndSenhaEquals(String email, String senha);
}

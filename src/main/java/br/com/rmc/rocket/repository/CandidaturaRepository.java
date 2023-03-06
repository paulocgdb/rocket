package br.com.rmc.rocket.repository;

import br.com.rmc.rocket.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    @Query("SELECT c FROM Candidatura c WHERE c.status.id = 1")
    public List<Candidatura> findAllByStatusEmAnalise();

    @Query("SELECT c FROM Candidatura c WHERE c.usuario.id = :idUsuario")
    List<Candidatura> findByUsuarioId(Long idUsuario);
}

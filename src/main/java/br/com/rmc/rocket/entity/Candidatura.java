package br.com.rmc.rocket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @JoinColumn(name = "usuario_id", nullable = false)
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "status_id", nullable = false)
    @ManyToOne
    private Status status;
}

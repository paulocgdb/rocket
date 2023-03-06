package br.com.rmc.rocket.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidatura implements Serializable {

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

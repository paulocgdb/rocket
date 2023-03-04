package br.com.rmc.rocket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "nome_da_mae", nullable = false)
    private String nomeMae;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @JoinColumn(name = "cidade_id", nullable = false)
    @ManyToOne
    private Cidade cidade;

    @JoinColumn(name = "perfil_id", nullable = false)
    @ManyToOne
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Documento> documentoList;
}

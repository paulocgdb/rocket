package br.com.rmc.rocket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private CidadeDTO cidade;
    private PerfilDTO perfil;

    private String email;

    private String senha;
    private String cpf;
    private String nomeMae;

    private LocalDateTime dataNascimento;

    private Long quantidadeCandidaturas;

    private List<CandidaturaDTO> candidaturaDTOList;

    private List<DocumentoDTO> documentoDTOList;
}

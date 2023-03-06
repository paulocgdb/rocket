package br.com.rmc.rocket.dto;

import br.com.rmc.rocket.entity.Cidade;
import br.com.rmc.rocket.entity.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

    private Long id;

    private String nome;

    private Cidade cidade;
    private Perfil perfil;

    private String email;

    private String senha;
    private String cpf;
    private String nomeDaMae;

    private LocalDateTime dataNascimento;
//
//    private Long quantidadeCandidaturas;
//
//    private List<Candidatura> candidaturaList;
//
//    private List<Documento> documentoList;
}

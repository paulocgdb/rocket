package br.com.rmc.rocket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String cidade;

    private Long quantidadeCandidaturas;

    private List<CandidaturaDTO> candidaturaDTOList;

    private List<DocumentoDTO> documentoDTOList;
}

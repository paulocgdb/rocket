package br.com.rmc.rocket.dto;

import br.com.rmc.rocket.entity.Cidade;
import br.com.rmc.rocket.entity.Documento;
import br.com.rmc.rocket.entity.Usuario;
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
public class CandidaturaDTO {

    private Long id;

    private LocalDateTime dataCriacao;

    private Usuario usuario;

    private Cidade cidade;

    private List<Documento> documentoList;
}

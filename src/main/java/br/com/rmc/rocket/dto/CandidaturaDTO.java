package br.com.rmc.rocket.dto;

import br.com.rmc.rocket.entity.Cidade;
import br.com.rmc.rocket.entity.Documento;
import br.com.rmc.rocket.entity.Status;
import br.com.rmc.rocket.entity.Usuario;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidaturaDTO {

    private Long id;

    private LocalDateTime dataCriacao;

    private Usuario usuario;

    private Cidade cidade;

    private Status status;

    private List<Documento> documentoList;
}

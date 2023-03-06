package br.com.rmc.rocket.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDTO {

    private Long id;
    private String nome;

    private LocalDateTime dataCriacao;
}

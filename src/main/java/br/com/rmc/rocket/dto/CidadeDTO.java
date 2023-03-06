package br.com.rmc.rocket.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {

    private Long id;
    private String nome;
}

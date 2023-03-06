package br.com.rmc.rocket.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {

    private Long id;
    private String nome;
}

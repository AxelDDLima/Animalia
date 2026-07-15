package com.br.animania.cadastroanimais.dto.busca;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BuscarAnimalDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(
            example = "AVE",
            allowableValues = {
                    "AVE",
                    "MAMIFERO",
                    "REPTIL"
            }
    )
    private String classificacao;

    public BuscarAnimalDTO(String  classificacao) {
        this.classificacao = classificacao;
    }
}

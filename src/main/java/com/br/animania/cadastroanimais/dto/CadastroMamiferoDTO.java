package com.br.animania.cadastroanimais.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CadastroMamiferoDTO extends CadastroAnimalDTO {
    private String corPelo;
    private String tamanhoPelo;
}

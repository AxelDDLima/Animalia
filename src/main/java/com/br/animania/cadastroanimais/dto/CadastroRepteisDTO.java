package com.br.animania.cadastroanimais.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CadastroRepteisDTO extends CadastroAnimalDTO {
    private String tipoEstruturaExterna;
    private String corDaEstrutura;
    private String quantidadePatas;

}

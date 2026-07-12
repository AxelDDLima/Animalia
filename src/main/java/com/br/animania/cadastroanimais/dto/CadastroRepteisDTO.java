package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Repteis;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CadastroRepteisDTO extends CadastroAnimalDTO {
    private String tipoEstruturaExterna;
    private String corDaEstrutura;
    private String quantidadePatas;

    public CadastroRepteisDTO(Repteis entity) {
        this.tipoEstruturaExterna = entity.getTipoEstruturaExterna();
        this.corDaEstrutura       = entity.getCorDaEstrutura();
        this.quantidadePatas      = entity.getQuantidadePatas();
        super.setNomeAnimal(entity.getNomeAnimal());
        super.setIdadeAnimal(entity.getIdadeAnimal());
        super.setTipoAnimal(entity.getTipoAnimal());
        super.setClassificacao(entity.getClassificacao());
        super.setTutorAnimal(entity.getTutorAnimal());
    }
}

package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Ave;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CadastroAveDTO extends CadastroAnimalDTO {
    private boolean isVoa;
    private String corPena;

    public CadastroAveDTO(Ave entity) {
        this.corPena = entity.getCorPena();
        this.isVoa = entity.isVoa();
        super.setNomeAnimal(entity.getNomeAnimal());
        super.setIdadeAnimal(entity.getIdadeAnimal());
        super.setTipoAnimal(entity.getTipoAnimal());
        super.setClassificacao(entity.getClassificacao());
        super.setTutorAnimal(entity.getTutorAnimal());

    }
}

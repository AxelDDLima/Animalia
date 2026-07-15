package com.br.animania.cadastroanimais.dto.cadastro;

import com.br.animania.cadastroanimais.entities.Ave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CadastroAveDTO extends CadastroAnimalDTO {
    private boolean isVoa;
    private String corPena;

    public CadastroAveDTO(Ave entity) {
        this.corPena = entity.getCorPena();
        this.isVoa   = entity.isVoa();
        super.setId(entity.getId());
        super.setNomeAnimal(entity.getNomeAnimal());
        super.setIdadeAnimal(entity.getIdadeAnimal());
        super.setTipoAnimal(entity.getTipoAnimal());
        super.setClassificacao(entity.getClassificacao());
        super.setTutorAnimal(entity.getTutorAnimal());
    }
}

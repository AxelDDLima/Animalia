package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Mamifero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CadastroMamiferoDTO extends CadastroAnimalDTO {
    private String corPelo;
    private String tamanhoPelo;

    public CadastroMamiferoDTO(Mamifero entity) {
        this.corPelo     = entity.getCorPelo();
        this.tamanhoPelo = entity.getTamanhoPelo();
        super.setNomeAnimal(entity.getNomeAnimal());
        super.setIdadeAnimal(entity.getIdadeAnimal());
        super.setTipoAnimal(entity.getTipoAnimal());
        super.setClassificacao(entity.getClassificacao());
        super.setTutorAnimal(entity.getTutorAnimal());
    }
}

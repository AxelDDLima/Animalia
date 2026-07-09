package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Tutor;
import lombok.Data;

@Data
public class CadastroAnimalDTO {
    private String nomeAnimal;
    private String idadeAnimal;
    private String tipoAnimal;
    private String classificacao;
    private CadastroTutorDTO tutorAnimal;

    public void setTutorAnimal(Tutor entity) {
        this.tutorAnimal.setNomeTutor(entity.getNomeTutor());
        this.tutorAnimal.setTelefoneTutor(entity.getTelefoneTutor());
        this.tutorAnimal.setEnderecoTutor(entity.getEnderecoTutor());
    }
}

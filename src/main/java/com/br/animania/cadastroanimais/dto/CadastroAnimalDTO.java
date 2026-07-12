package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Tutor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.Locale;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "classificacao"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CadastroAveDTO.class, name = "AVE"),
        @JsonSubTypes.Type(value = CadastroMamiferoDTO.class, name = "Mamifero"),
        @JsonSubTypes.Type(value = CadastroRepteisDTO.class, name = "Reptil")
})
@Data
public abstract class CadastroAnimalDTO {
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

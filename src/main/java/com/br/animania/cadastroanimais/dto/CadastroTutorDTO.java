package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Endereco;
import lombok.Data;

@Data
public class CadastroTutorDTO {
    private String nomeTutor;
    private String telefoneTutor;
    private CadastroEnderecoDTO enderecoTutor;

    public void setEnderecoTutor(Endereco entity) {
        this.enderecoTutor.setCep(entity.getCep());
        this.enderecoTutor.setLogradouro(entity.getLogradouro());
        this.enderecoTutor.setBairro(entity.getBairro());
        this.enderecoTutor.setUf(entity.getUf());
    }
}

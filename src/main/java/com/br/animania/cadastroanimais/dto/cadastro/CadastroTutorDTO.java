package com.br.animania.cadastroanimais.dto.cadastro;

import com.br.animania.cadastroanimais.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroTutorDTO {
    private String nomeTutor;
    private String telefoneTutor;
    private CadastroEnderecoDTO enderecoTutor;

    public void setEnderecoTutor(Endereco entity) {
        enderecoTutor = new CadastroEnderecoDTO(entity);
        this.enderecoTutor.setCep(entity.getCep());
        this.enderecoTutor.setLogradouro(entity.getLogradouro());
        this.enderecoTutor.setBairro(entity.getBairro());
        this.enderecoTutor.setUf(entity.getUf());
    }
}

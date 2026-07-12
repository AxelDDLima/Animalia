package com.br.animania.cadastroanimais.dto;

import com.br.animania.cadastroanimais.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroEnderecoDTO {
    public String cep;
    public String logradouro;
    public String bairro;
    public String uf;

    public CadastroEnderecoDTO(Endereco entity) {
        this.cep        = entity.getCep();
        this.logradouro = entity.getLogradouro();
        this.bairro     = entity.getBairro();
        this.uf         = entity.getUf();
    }
}

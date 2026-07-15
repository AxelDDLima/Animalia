package com.br.animania.cadastroanimais.entities;

import com.br.animania.cadastroanimais.dto.cadastro.CadastroEnderecoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;

    @OneToOne(mappedBy = "enderecoTutor", cascade = CascadeType.ALL)
    private Tutor tutor;

    public Endereco(CadastroEnderecoDTO dto) {
        this.cep        = dto.getCep() ;
        this.logradouro = dto.getLogradouro() ;
        this.bairro     = dto.getBairro() ;
        this.uf         = dto.getUf() ;
    }
}

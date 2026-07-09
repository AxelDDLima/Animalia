package com.br.animania.cadastroanimais.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;

    @OneToOne(mappedBy = "enderecoTutor", cascade = CascadeType.ALL)
    private Tutor tutor;

}

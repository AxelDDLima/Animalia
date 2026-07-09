package com.br.animania.cadastroanimais.dto;

import lombok.Data;

@Data
public class CadastroTutorDTO {
    private String nomeTutor;
    private String telefoneTutor;
    private CadastroEnderecoDTO enderecoTutor;

}

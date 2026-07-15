package com.br.animania.cadastroanimais.exceptions.response;

import java.time.LocalDateTime;

public record ErroResponse(
        LocalDateTime dataHora,
        int status,
        String erro,
        String mensagem,
        String path
){

}

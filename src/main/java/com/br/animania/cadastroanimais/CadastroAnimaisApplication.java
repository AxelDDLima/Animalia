package com.br.animania.cadastroanimais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring boot criado para estudo e aplicação de conhecimento.
 * Depencias ultilizadas:
 * -Data JPA
 * -Banco de Dados H2
 * -Lombok
 * -Openapi-ui
 * -liquibase
 * -OpenFeign
 * @author Axel d. Lima
 */

@EnableFeignClients
@SpringBootApplication
public class CadastroAnimaisApplication {

    public static void main(String[] args) {

        SpringApplication.run(CadastroAnimaisApplication.class, args);
    }

}

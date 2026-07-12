package com.br.animania.cadastroanimais.services;

import com.br.animania.cadastroanimais.dto.CadastroAnimalDTO;
import org.springframework.http.ResponseEntity;

public interface CadastroAnimal {
    CadastroAnimalDTO  cadastrarAnimal(CadastroAnimalDTO animal);
    void alterarCadastro();
    <T> ResponseEntity<T> buscarCadastroId();
    <T> ResponseEntity<T>  buscarTodosCadastros();
    <T> ResponseEntity<T> buscarTodosPorCategoria();
    void deletarCadastroPorId();
}

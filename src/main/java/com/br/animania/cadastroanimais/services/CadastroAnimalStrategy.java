package com.br.animania.cadastroanimais.services;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;

import java.util.List;

public interface CadastroAnimalStrategy {
    String getClassificacao();
    CadastroAnimalDTO cadastrarAnimal(CadastroAnimalDTO animalDTO);
    CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO animalDTO);
    CadastroAnimalDTO buscarCadastroId(BuscarAnimalDTO animalDTO);
    List<CadastroAnimalDTO> buscarTodosOsCadastrosPorClassificacao();
    void deletarCadastro(BuscarAnimalDTO animalDTO);
}

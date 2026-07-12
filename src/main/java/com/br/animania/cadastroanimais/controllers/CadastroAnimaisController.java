package com.br.animania.cadastroanimais.controllers;

import com.br.animania.cadastroanimais.dto.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.services.CadastroAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastroAnimal")
public class CadastroAnimaisController {

    @Autowired
    private CadastroAnimal cadastroAnimal;
    /**
    cadastrarAnimal()
    alterarCadastro()
    buscarCadastroId()
    buscarTodosCadastros()
    buscarTodosPorCategoria()
    deletarCadastroPorId()
    */
    @PostMapping("/animais")
    public ResponseEntity<CadastroAnimalDTO> cadastrarAnimal(@RequestBody CadastroAnimalDTO animal){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadastroAnimal.cadastrarAnimal(animal));
    }

    @GetMapping("/ok")
    public ResponseEntity<String> ok(){
        return ResponseEntity.ok("tudo certo!");
    }


}

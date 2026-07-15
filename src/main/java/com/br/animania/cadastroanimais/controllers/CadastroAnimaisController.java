package com.br.animania.cadastroanimais.controllers;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.services.imp.CadastroAnimalImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/cadastroAnimal")
public class CadastroAnimaisController {

    @Autowired
    private CadastroAnimalImp cadastroAnimalService;
    /**
     * cadastrarAnimal()
     * alterarCadastro()
     * buscarCadastroId()
     * buscarTodosCadastros()
     * buscarTodosPorCategoria()
     * deletarCadastroPorId()
     *
     */
    @GetMapping("/ok")
    public ResponseEntity<?> ok(){
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/animais")
    public ResponseEntity<?> cadastrarAnimal(@RequestBody CadastroAnimalDTO animal){
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroAnimalService.cadastrar(animal));

    }

    @GetMapping("/animais/{id}/{classificacao}")
    public ResponseEntity<?> buscarCadastroId(@PathVariable String classificacao,
                                              @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastroAnimalService.buscarCadastroId(new BuscarAnimalDTO(id, classificacao)));
    }

    @GetMapping("/animais/{classificacao}")
    public ResponseEntity<?> buscarTodosOsCadastrosPorClassificacao(@PathVariable String classificacao){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastroAnimalService.buscarTodosOsCadastrosPorClassificacao(new BuscarAnimalDTO(classificacao)));
    }

    @PutMapping("/animais")
    public ResponseEntity<?> alterarCadastro(@RequestBody CadastroAnimalDTO animal){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cadastroAnimalService.alterarCadastro(animal));
    }

    @DeleteMapping("/animais/{id}/{classificacao}")
    public ResponseEntity<?> deletarCadastro(@PathVariable String classificacao,
                                             @PathVariable Long id){
        cadastroAnimalService.deletarCadastro(new BuscarAnimalDTO(id, classificacao));
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deletado com sucesso!");
    }
}

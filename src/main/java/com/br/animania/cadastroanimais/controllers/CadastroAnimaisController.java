package com.br.animania.cadastroanimais.controllers;

import com.br.animania.cadastroanimais.dto.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.dto.CadastroAveDTO;
import com.br.animania.cadastroanimais.dto.CadastroMamiferoDTO;
import com.br.animania.cadastroanimais.dto.CadastroRepteisDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastroAnimal")
public class CadastroAnimaisController {
    /**
    cadastrarAnimal()
    alterarCadastro()
    buscarCadastroId()
    buscarTodosCadastros()
    buscarTodosPorCategoria()
    deletarCadastroPorId()
    */
    @PostMapping("/animais")
    public ResponseEntity<CadastroAnimalDTO> cadastrar(@RequestBody CadastroAnimalDTO animal){
        if (animal instanceof CadastroAveDTO aveDTO) {
            System.out.println("Recebeu uma ave: " + aveDTO.getCorPena());
        }

        if (animal instanceof CadastroMamiferoDTO mamiferoDTO) {
            System.out.println("Recebeu um mamifero: " + mamiferoDTO.getCorPelo());
        }

        if (animal instanceof CadastroRepteisDTO repteisDTO) {
            System.out.println("Recebeu um reptil: " + repteisDTO.getTipoEstruturaExterna());
        }

        return ResponseEntity.ok(animal);
    }

    @GetMapping("/ok")
    public ResponseEntity<String> ok(){
        
        return ResponseEntity.ok("tudo certo!");
    }


}

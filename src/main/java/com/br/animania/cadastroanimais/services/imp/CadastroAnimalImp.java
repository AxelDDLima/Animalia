package com.br.animania.cadastroanimais.services.imp;

import com.br.animania.cadastroanimais.dto.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.dto.CadastroAveDTO;
import com.br.animania.cadastroanimais.dto.CadastroMamiferoDTO;
import com.br.animania.cadastroanimais.dto.CadastroRepteisDTO;
import com.br.animania.cadastroanimais.entities.Ave;
import com.br.animania.cadastroanimais.entities.Mamifero;
import com.br.animania.cadastroanimais.entities.Repteis;
import com.br.animania.cadastroanimais.repositories.AveRepository;
import com.br.animania.cadastroanimais.repositories.MamiferoRepository;
import com.br.animania.cadastroanimais.repositories.RepteisRepository;
import com.br.animania.cadastroanimais.services.CadastroAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroAnimalImp implements CadastroAnimal {
    @Autowired
    private AveRepository aveRepository;
    @Autowired
    private MamiferoRepository mamiferoRepository;
    @Autowired
    private RepteisRepository repteisRepository;

    @Override
    public CadastroAnimalDTO cadastrarAnimal(CadastroAnimalDTO animal) {
        if (animal instanceof CadastroAveDTO dto) {
            return cadastrarAve(dto);
        }
        if (animal instanceof CadastroMamiferoDTO dto) {
            return cadastrarMamifero(dto);
        }
        if (animal instanceof CadastroRepteisDTO dto) {
            return cadastrarReptil(dto);
        }

        throw new IllegalArgumentException(
                "Tipo de animal não suportado: " + animal.getClass().getSimpleName()
        );
    }

    @Override
    public void alterarCadastro() {

    }

    @Override
    public <T> ResponseEntity<T> buscarCadastroId() {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> buscarTodosCadastros() {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> buscarTodosPorCategoria() {
        return null;
    }

    @Override
    public void deletarCadastroPorId() {

    }

    private CadastroAnimalDTO cadastrarAve(CadastroAveDTO dto) {
        return new CadastroAveDTO(aveRepository.save(new Ave(dto)));
    }

    private CadastroAnimalDTO cadastrarMamifero(CadastroMamiferoDTO dto) {
        return new CadastroMamiferoDTO(mamiferoRepository.save(new Mamifero(dto)));
    }

    private CadastroAnimalDTO cadastrarReptil(CadastroRepteisDTO dto) {
        return new CadastroRepteisDTO(repteisRepository.save(new Repteis(dto)));
    }
}

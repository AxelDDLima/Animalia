package com.br.animania.cadastroanimais.services.imp;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroEnderecoDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroMamiferoDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroTutorDTO;
import com.br.animania.cadastroanimais.entities.Endereco;
import com.br.animania.cadastroanimais.entities.Mamifero;
import com.br.animania.cadastroanimais.entities.Tutor;
import com.br.animania.cadastroanimais.exceptions.RecursoNaoEncontradoException;
import com.br.animania.cadastroanimais.repositories.MamiferoRepository;
import com.br.animania.cadastroanimais.services.CadastroAnimalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.br.animania.cadastroanimais.enums.ClassificacaoEnum.MAMIFERO;

@Service
public class MamiferoServiceImp implements CadastroAnimalStrategy {
    @Autowired
    private MamiferoRepository mamiferoRepository;

    @Override
    public CadastroAnimalDTO cadastrarAnimal(CadastroAnimalDTO mamiferoDTO) {
        return new CadastroMamiferoDTO(mamiferoRepository.save(new Mamifero((CadastroMamiferoDTO) mamiferoDTO)));
    }

    @Override
    public CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO mamiferoDTO) {
        return new CadastroMamiferoDTO(atualizarCampos(buscarCadastroId(mamiferoDTO.getId()), (CadastroMamiferoDTO) mamiferoDTO));
    }

    @Override
    public CadastroMamiferoDTO buscarCadastroId(BuscarAnimalDTO mamiferoDTO) {
        return new CadastroMamiferoDTO(buscarCadastroId(mamiferoDTO.getId()));
    }

    @Override
    public List<CadastroAnimalDTO> buscarTodosOsCadastrosPorClassificacao() {
        List<CadastroAnimalDTO> list = new ArrayList<>();
        mamiferoRepository.findAll().forEach( mamifero -> list.add(new CadastroMamiferoDTO(mamifero)));
        return list;
    }

    @Override
    public void deletarCadastro(BuscarAnimalDTO animalDTO) {
        mamiferoRepository.deleteById(animalDTO.getId());
    }

    @Override
    public String getClassificacao() {
        return MAMIFERO.toString();
    }

    private Mamifero atualizarCampos(Mamifero mamifero, CadastroMamiferoDTO dto) {

        mamifero.setNomeAnimal(dto.getNomeAnimal());
        mamifero.setIdadeAnimal(dto.getIdadeAnimal());
        mamifero.setTipoAnimal(dto.getTipoAnimal());
        mamifero.setClassificacao(dto.getClassificacao());
        mamifero.setCorPelo(dto.getCorPelo());
        mamifero.setTamanhoPelo(dto.getTamanhoPelo());

        Tutor tutor = mamifero.getTutorAnimal();
        CadastroTutorDTO tutorDTO = dto.getTutorAnimal();

        tutor.setNomeTutor(tutorDTO.getNomeTutor());
        tutor.setTelefoneTutor(tutorDTO.getTelefoneTutor());

        Endereco endereco = tutor.getEnderecoTutor();
        CadastroEnderecoDTO enderecoDTO = tutorDTO.getEnderecoTutor();

        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setUf(enderecoDTO.getUf());

        return mamiferoRepository.save(mamifero);
    }

    public Mamifero buscarCadastroId(Long id) {
        return mamiferoRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException(
                        "Mamifero não encontrada com o id: " + id
                )
        );
    }
}

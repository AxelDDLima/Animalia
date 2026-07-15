package com.br.animania.cadastroanimais.services.imp;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroEnderecoDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroRepteisDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroTutorDTO;
import com.br.animania.cadastroanimais.entities.Endereco;
import com.br.animania.cadastroanimais.entities.Repteis;
import com.br.animania.cadastroanimais.entities.Tutor;
import com.br.animania.cadastroanimais.exceptions.RecursoNaoEncontradoException;
import com.br.animania.cadastroanimais.repositories.RepteisRepository;
import com.br.animania.cadastroanimais.services.CadastroAnimalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.br.animania.cadastroanimais.enums.ClassificacaoEnum.REPTIL;

@Service
public class ReptilServiceImp implements CadastroAnimalStrategy {
    @Autowired
    private RepteisRepository reptilRepository;

    @Override
    public CadastroAnimalDTO cadastrarAnimal(CadastroAnimalDTO reptilDTO) {
        return new CadastroRepteisDTO(reptilRepository.save(new Repteis((CadastroRepteisDTO) reptilDTO)));
    }

    @Override
    public CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO reptilDTO) {
        return new CadastroRepteisDTO(atualizarCampos(buscarCadastroId(reptilDTO.getId()), (CadastroRepteisDTO) reptilDTO));
    }

    @Override
    public CadastroRepteisDTO buscarCadastroId(BuscarAnimalDTO reptilDTO) {
        return new CadastroRepteisDTO(buscarCadastroId(reptilDTO.getId()));
    }

    @Override
    public List<CadastroAnimalDTO> buscarTodosOsCadastrosPorClassificacao() {
        List<CadastroAnimalDTO> list = new ArrayList<>();
        reptilRepository.findAll().forEach( ave -> list.add(new CadastroRepteisDTO(ave)));
        return list;
    }

    @Override
    public void deletarCadastro(BuscarAnimalDTO animalDTO) {
        reptilRepository.deleteById(animalDTO.getId());
    }

    @Override
    public String getClassificacao() {
        return REPTIL.toString();
    }

    private Repteis atualizarCampos(Repteis reptil, CadastroRepteisDTO dto) {

        reptil.setNomeAnimal(dto.getNomeAnimal());
        reptil.setIdadeAnimal(dto.getIdadeAnimal());
        reptil.setTipoAnimal(dto.getTipoAnimal());
        reptil.setClassificacao(dto.getClassificacao());
        reptil.setCorDaEstrutura(dto.getCorDaEstrutura());
        reptil.setQuantidadePatas(dto.getQuantidadePatas());
        reptil.setTipoEstruturaExterna(dto.getTipoEstruturaExterna());

        Tutor tutor = reptil.getTutorAnimal();
        CadastroTutorDTO tutorDTO = dto.getTutorAnimal();

        tutor.setNomeTutor(tutorDTO.getNomeTutor());
        tutor.setTelefoneTutor(tutorDTO.getTelefoneTutor());

        Endereco endereco = tutor.getEnderecoTutor();
        CadastroEnderecoDTO enderecoDTO = tutorDTO.getEnderecoTutor();

        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setUf(enderecoDTO.getUf());

        return reptilRepository.save(reptil);
    }

    public Repteis buscarCadastroId(Long id) {
        return reptilRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException(
                        "Reptil não encontrada com o id: " + id
                )
        );
    }
}

package com.br.animania.cadastroanimais.services.imp;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAveDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroEnderecoDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroTutorDTO;
import com.br.animania.cadastroanimais.entities.Ave;
import com.br.animania.cadastroanimais.entities.Endereco;
import com.br.animania.cadastroanimais.entities.Tutor;
import com.br.animania.cadastroanimais.exceptions.RecursoNaoEncontradoException;
import com.br.animania.cadastroanimais.repositories.AveRepository;
import com.br.animania.cadastroanimais.services.CadastroAnimalStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.br.animania.cadastroanimais.enums.ClassificacaoEnum.AVE;

@Service
public class AveServiceImp implements CadastroAnimalStrategy {
    @Autowired
    private AveRepository aveRepository;

    @Override
    public CadastroAnimalDTO cadastrarAnimal(CadastroAnimalDTO aveDTO) {
        return new CadastroAveDTO(aveRepository.save(new Ave((CadastroAveDTO) aveDTO)));
    }

    @Override
    public CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO aveDTO) {
        return new CadastroAveDTO(atualizarCampos(buscarCadastroId(aveDTO.getId()), (CadastroAveDTO) aveDTO));
    }

    @Override
    public CadastroAveDTO buscarCadastroId(BuscarAnimalDTO aveDTO) {
        return new CadastroAveDTO(buscarCadastroId(aveDTO.getId()));
    }

    @Override
    public List<CadastroAnimalDTO> buscarTodosOsCadastrosPorClassificacao() {
        List<CadastroAnimalDTO> list = new ArrayList<>();
        aveRepository.findAll().forEach( ave -> list.add(new CadastroAveDTO(ave)));
        return list;
    }

    @Override
    public void deletarCadastro(BuscarAnimalDTO animalDTO) {
        aveRepository.deleteById(animalDTO.getId());
    }

    @Override
    public String getClassificacao() {
        return AVE.toString();
    }

    private Ave atualizarCampos(Ave ave, CadastroAveDTO dto) {

        ave.setNomeAnimal(dto.getNomeAnimal());
        ave.setIdadeAnimal(dto.getIdadeAnimal());
        ave.setTipoAnimal(dto.getTipoAnimal());
        ave.setClassificacao(dto.getClassificacao());
        ave.setCorPena(dto.getCorPena());
        ave.setVoa(dto.isVoa());

        Tutor tutor = ave.getTutorAnimal();
        CadastroTutorDTO tutorDTO = dto.getTutorAnimal();

        tutor.setNomeTutor(tutorDTO.getNomeTutor());
        tutor.setTelefoneTutor(tutorDTO.getTelefoneTutor());

        Endereco endereco = tutor.getEnderecoTutor();
        CadastroEnderecoDTO enderecoDTO = tutorDTO.getEnderecoTutor();

        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setUf(enderecoDTO.getUf());

        return aveRepository.save(ave);
    }

    public Ave buscarCadastroId(Long id) {
        return aveRepository.findById(id).orElseThrow(() ->
                new RecursoNaoEncontradoException(
                        "Ave não encontrada com o id: " + id
                )
        );
    }
}

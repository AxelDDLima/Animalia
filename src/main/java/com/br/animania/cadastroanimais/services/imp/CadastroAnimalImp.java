package com.br.animania.cadastroanimais.services.imp;

import com.br.animania.cadastroanimais.dto.busca.BuscarAnimalDTO;
import com.br.animania.cadastroanimais.dto.cadastro.CadastroAnimalDTO;
import com.br.animania.cadastroanimais.exceptions.TipoNaoSuportadoException;
import com.br.animania.cadastroanimais.services.CadastroAnimalStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroAnimalImp{

    private final List<CadastroAnimalStrategy> strategies;

    public CadastroAnimalImp(List<CadastroAnimalStrategy> strategies) {
        this.strategies = strategies;
    }

    public CadastroAnimalDTO cadastrar(CadastroAnimalDTO dto) {
        return buscarStrategy(dto.getClassificacao())
                .cadastrarAnimal(dto);
    }

    public CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO dto) {
        return buscarStrategy(dto.getClassificacao())
                .alterarCadastro(dto);
    }

    public CadastroAnimalDTO buscarCadastroId(BuscarAnimalDTO dto) {
        return buscarStrategy(dto.getClassificacao())
                .buscarCadastroId(dto);
    }

    public List<CadastroAnimalDTO> buscarTodosOsCadastrosPorClassificacao(BuscarAnimalDTO animalDTO) {
        return buscarStrategy(animalDTO.getClassificacao())
                .buscarTodosOsCadastrosPorClassificacao();
    }

    public void deletarCadastro(BuscarAnimalDTO animalDTO) {
        buscarStrategy(animalDTO.getClassificacao())
            .deletarCadastro(animalDTO);
    }

    private CadastroAnimalStrategy buscarStrategy(
            String classificacao) {

        return strategies.stream()
                .filter(strategy ->
                        strategy.getClassificacao()
                                .equalsIgnoreCase(classificacao))
                .findFirst()
                .orElseThrow(() ->
                        new TipoNaoSuportadoException(
                                "Tipo de animal '" + classificacao + "' não suportado."
                        ));
    }





    /*
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
    public CadastroAnimalDTO alterarCadastro(CadastroAnimalDTO animal) {

        if (animal instanceof CadastroAveDTO dto) {
            return alterarCadastroAve(dto);
        }
        if (animal instanceof CadastroMamiferoDTO dto) {
            return alterarCadastroMamifero(dto);
        }
        if (animal instanceof CadastroRepteisDTO dto) {
            return alterarCadastroReptil(dto);
        }

        throw new IllegalArgumentException(
                "Tipo de animal não suportado: " + animal.getClass().getSimpleName()
        );
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

    private CadastroAnimalDTO alterarCadastroAve(CadastroAveDTO dto) {
        Optional<Ave> ave = aveRepository.findById(dto.getId());
        return ave.map(value -> new CadastroAveDTO(aveRepository.save(value))).orElse(null);
    }

    private CadastroAnimalDTO cadastrarMamifero(CadastroMamiferoDTO dto) {
        return new CadastroMamiferoDTO(mamiferoRepository.save(new Mamifero(dto)));
    }

    private CadastroAnimalDTO alterarCadastroMamifero(CadastroMamiferoDTO dto) {
        Optional<Mamifero> mamifero = mamiferoRepository.findById(dto.getId());
        if (mamifero.isPresent()) {
            return cadastrarMamifero(dto);
        } return null;
    }

    private CadastroAnimalDTO cadastrarReptil(CadastroRepteisDTO dto) {
        return new CadastroRepteisDTO(repteisRepository.save(new Repteis(dto)));
    }

    private CadastroAnimalDTO alterarCadastroReptil(CadastroRepteisDTO dto) {
        Optional<Repteis> reptil = repteisRepository.findById(dto.getId());
        if (reptil.isPresent()) {
            return cadastrarReptil(dto);
        } return null;
    }
    */

}

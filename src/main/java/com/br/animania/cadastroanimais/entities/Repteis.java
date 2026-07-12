package com.br.animania.cadastroanimais.entities;

import com.br.animania.cadastroanimais.dto.CadastroRepteisDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_repteis")
public class Repteis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeAnimal;
    private String idadeAnimal;
    private String tipoAnimal;
    private String classificacao;
    private String tipoEstruturaExterna;
    private String corDaEstrutura;
    private String quantidadePatas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id")
    private Tutor tutorAnimal;

    public Repteis(CadastroRepteisDTO entity) {
        this.tipoEstruturaExterna = entity.getTipoEstruturaExterna();
        this.corDaEstrutura       =  entity.getCorDaEstrutura();
        this.quantidadePatas      = entity.getQuantidadePatas();
        this.nomeAnimal           =  entity.getNomeAnimal();
        this.idadeAnimal          =  entity.getIdadeAnimal();
        this.tipoAnimal           =  entity.getTipoAnimal();
        this.classificacao        =  entity.getClassificacao();
        this.tutorAnimal          = new Tutor(entity.getTutorAnimal());
    }

}

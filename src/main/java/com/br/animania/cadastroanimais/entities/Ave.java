package com.br.animania.cadastroanimais.entities;

import com.br.animania.cadastroanimais.dto.CadastroAveDTO;

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
@Table(name = "tb_ave")
public class Ave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeAnimal;
    private String idadeAnimal;
    private String tipoAnimal;
    private String classificacao;
    private boolean isVoa;
    private String corPena;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id")
    private Tutor tutorAnimal;

    public Ave(CadastroAveDTO entity) {
        this.corPena       = entity.getCorPena();
        this.isVoa         =  entity.isVoa();
        this.nomeAnimal    =  entity.getNomeAnimal();
        this.idadeAnimal   =  entity.getIdadeAnimal();
        this.tipoAnimal    =  entity.getTipoAnimal();
        this.classificacao =  entity.getClassificacao();
        this.tutorAnimal   = new Tutor(entity.getTutorAnimal());
    }
}

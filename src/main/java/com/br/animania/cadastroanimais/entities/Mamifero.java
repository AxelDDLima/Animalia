package com.br.animania.cadastroanimais.entities;

import com.br.animania.cadastroanimais.dto.cadastro.CadastroMamiferoDTO;
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
@Table(name = "tb_mamifero")
public class Mamifero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeAnimal;
    private String idadeAnimal;
    private String tipoAnimal;
    private String classificacao;
    private String corPelo;
    private String tamanhoPelo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id")
    private Tutor tutorAnimal;

    public Mamifero(CadastroMamiferoDTO entity) {
        this.corPelo       = entity.getCorPelo();
        this.tamanhoPelo   =  entity.getTamanhoPelo();
        this.nomeAnimal    =  entity.getNomeAnimal();
        this.idadeAnimal   =  entity.getIdadeAnimal();
        this.tipoAnimal    =  entity.getTipoAnimal();
        this.classificacao =  entity.getClassificacao();
        this.tutorAnimal   = new Tutor(entity.getTutorAnimal());
    }

}

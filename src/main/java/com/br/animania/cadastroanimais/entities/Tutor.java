package com.br.animania.cadastroanimais.entities;

import com.br.animania.cadastroanimais.dto.cadastro.CadastroTutorDTO;
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
@Table(name = "tb_tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeTutor;
    private String telefoneTutor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoTutor;

    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Ave ave;
    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Mamifero mamifero;
    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Repteis repteis;

    public Tutor(CadastroTutorDTO entity) {
        this.nomeTutor     = entity.getNomeTutor();
        this.telefoneTutor = entity.getTelefoneTutor();
        this.enderecoTutor = new Endereco(entity.getEnderecoTutor());
    }
}

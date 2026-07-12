package com.br.animania.cadastroanimais.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeTutor;
    private String telefoneTutor;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoTutor;

    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Ave ave;
    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Mamifero mamifero;
    @OneToOne(mappedBy = "tutorAnimal", cascade = CascadeType.ALL)
    private Repteis repteis;

}

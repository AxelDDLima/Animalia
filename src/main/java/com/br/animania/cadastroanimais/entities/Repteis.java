package com.br.animania.cadastroanimais.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

    @OneToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutorAnimal;
}

package com.br.animania.cadastroanimais.repositories;

import com.br.animania.cadastroanimais.entities.Mamifero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MamiferoRepository extends JpaRepository<Mamifero, Long> {

}

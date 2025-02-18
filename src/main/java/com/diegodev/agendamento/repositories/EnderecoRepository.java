package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

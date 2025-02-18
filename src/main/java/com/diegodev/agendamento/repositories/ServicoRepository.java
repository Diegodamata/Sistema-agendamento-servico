package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}

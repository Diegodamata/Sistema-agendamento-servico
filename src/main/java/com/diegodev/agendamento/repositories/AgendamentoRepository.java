package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}

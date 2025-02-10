package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}

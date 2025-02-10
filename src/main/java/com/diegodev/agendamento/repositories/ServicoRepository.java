package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}

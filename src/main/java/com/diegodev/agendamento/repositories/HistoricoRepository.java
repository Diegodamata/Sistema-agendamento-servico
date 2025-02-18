package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}

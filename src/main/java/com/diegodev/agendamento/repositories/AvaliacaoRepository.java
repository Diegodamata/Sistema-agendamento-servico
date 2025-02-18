package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.ProfissionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfissionalRepository extends JpaRepository<ProfissionalInfo, UUID> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PapelRepository extends JpaRepository<Papel, UUID> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Dono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonoRepository extends JpaRepository<Dono, Long> {
}

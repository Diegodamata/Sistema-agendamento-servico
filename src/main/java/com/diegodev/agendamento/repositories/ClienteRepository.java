package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

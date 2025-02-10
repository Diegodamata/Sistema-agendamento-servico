package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Telefone;
import com.diegodev.agendamento.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {
}

package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Endereco;
import com.diegodev.agendamento.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}

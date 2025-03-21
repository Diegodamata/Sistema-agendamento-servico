package com.diegodev.agendamento.repositories;

import com.diegodev.agendamento.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
